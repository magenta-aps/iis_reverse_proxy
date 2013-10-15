package util.auth.ldap;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

import javax.inject.Inject;

import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;

import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.SimpleBindRequest;
import com.unboundid.util.ssl.SSLUtil;
import com.unboundid.util.ssl.TrustAllTrustManager;
import com.unboundid.util.ssl.TrustStoreTrustManager;

public class GenericLdapAuthenticationStrategy implements IAuthStrategy {

	private final String hostname;
	private final int port;
	private final String basedn;
	private final String userattribute;
	private final String usergrouprdn;
	private final String authorizedgrouprdn;
	private final String authorizedattribute;
	
	@Inject
	public GenericLdapAuthenticationStrategy(String newHostname,
											 int newPort,
											 String newBasedn,
											 String newUserattribute,
											 String newUsergrouprdn,
											 String newAuthorizedgrouprdn,
											 String newAuthorizedattribute) {

		hostname = newHostname;
		port = newPort;
		basedn = newBasedn;
		userattribute = newUserattribute;
		usergrouprdn = newUsergrouprdn;
		authorizedgrouprdn = newAuthorizedgrouprdn;
		authorizedattribute = newAuthorizedattribute;

	}

	private final LDAPConnection getConnection() {
		StopWatch stopWatch = new Slf4JStopWatch("LdapAuthenticationStrategy.getConnection");
		
		LDAPConnection ldapConnection = null;
		try {
			// get the path to the truststore from the application.conf
			String trustStoreString  = "/etc/java/security/jssecacerts";
			
			// make a path and check that the file exists
			Path path = Paths.get(trustStoreString);
			if(Files.notExists(path)) throw new FileNotFoundException();

			// convert path to file and use it to configure the TrustStoreTrustManager
			File trustStoreFile = path.toFile();
			SSLUtil sslUtil = new SSLUtil(new TrustStoreTrustManager(trustStoreFile));

			//SSLUtil sslUtil = new SSLUtil(new TrustAllTrustManager());
		    ldapConnection = new LDAPConnection(sslUtil.createSSLSocketFactory(), hostname, port);

		} catch (LDAPException | GeneralSecurityException e) {
			play.Logger.error(e.getMessage());
			stopWatch.stop("LdapAuthenticationStrategy.getConnection.failed", e.getMessage());
			
		} catch (FileNotFoundException e) {
			play.Logger.error("Truststore file does not exist. Check trustStoreFile path in application.conf.");
			stopWatch.stop("LdapAuthenticationStrategy.getConnection.failed", e.getMessage());
		} 
		
		stopWatch.stop();
		return ldapConnection;
	}

	@Override
	public final IAuthResponse authentication(final String username,
			final String password) {
		StopWatch stopWatch = new Slf4JStopWatch("LdapAuthenticationStrategy.authentication");

		// Try to get a connection
		LDAPConnection ldapConnection = getConnection();

		if (ldapConnection == null) {
			stopWatch.stop("LdapAuthenticationStrategy.authentication.noConnection");
			return new LdapAuthResponse(AuthResponseType.ERROR,
					"Connection error");
		}

		try {
			final String binddn = userattribute + "=" +
								  username + "," +
								  usergrouprdn + "," +
								  basedn;
			play.Logger.debug("Created binddn: " + binddn);
					
			final BindRequest bindRequest = new SimpleBindRequest(binddn ,password);
			
			BindResult bindResult = ldapConnection.bind(bindRequest);

			if (bindResult.getResultCode() == ResultCode.SUCCESS) {
				play.Logger.debug("ResultCode.SUCCESS");

				// search and check if the user is member of the predefined group
				SearchRequest searchRequest = new SearchRequest(authorizedgrouprdn + ", " + basedn,
						SearchScope.SUB, Filter.createEqualityFilter(
								authorizedattribute, binddn));

				SearchResult sr = ldapConnection.search(searchRequest);
				
				if (sr.getEntryCount() == 1) {
					play.Logger.debug("Got 1 result");
					stopWatch.stop("LdapAuthenticationStrategy.authentication.succesful");
					// found one entry, so must be okay
					return new LdapAuthResponse(AuthResponseType.SUCCESS,
							"login.succesful");
				} else if (sr.getEntryCount() == 0) {
					play.Logger.debug("Got 0 results");
					stopWatch.stop("LdapAuthenticationStrategy.authentication.unsuccesful");
					// didn't return any, so user isn't authorized
					return new LdapAuthResponse(AuthResponseType.INFO,
							"login.not_authorized");
				} else {
					stopWatch.stop("LdapAuthenticationStrategy.authentication.unexpectedSearchResult");
					// something went wrong!
					play.Logger
							.error(this.getClass().getName()
									+ ": return unexpected multiply result - should be 0 or 1");
					return new LdapAuthResponse(AuthResponseType.ERROR,
							"login.unexpected_error");
				}
			} else {
				stopWatch.stop("LdapAuthenticationStrategy.authentication.unsuccesful");
				// ResultCode != success
				return new LdapAuthResponse(AuthResponseType.INFO,
						"login.invalid_credientials");
			}
		} catch (final LDAPException lex) {

			stopWatch.stop("LdapAuthenticationStrategy.authentication.unsuccesful", lex.getMessage());
			play.Logger.warn(lex.toString());

			return new LdapAuthResponse(AuthResponseType.INFO,
					"login.invalid_credientials");

		} finally {
			// always close the connection afterwards
			ldapConnection.close();

		}
	}
}
