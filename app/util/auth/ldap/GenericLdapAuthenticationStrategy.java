/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

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

import play.Configuration;
import play.Play;
import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.SimpleBindRequest;
import com.unboundid.util.ssl.SSLUtil;
import com.unboundid.util.ssl.TrustStoreTrustManager;

public class GenericLdapAuthenticationStrategy implements IAuthStrategy {

	private final String hostname;
	private final int port;
	private final boolean usingSsl;
	private final String basedn;
	private final String userattribute;
	private final String usergrouprdn;
	private final String authorizedgrouprdn;
	private final String authorizedattribute;
	
	@Inject
	public GenericLdapAuthenticationStrategy(final play.Configuration config) {	
		validate(config);
		
		hostname = config.getString("ldap.hostname");
		port = config.getInt("ldap.port");
		usingSsl = config.getBoolean("ldap.ssl");
		basedn  = config.getString("ldap.basedn");
		usergrouprdn = config.getString("ldap.usergrouprdn");
		userattribute = config.getString("ldap.userattribute");
		authorizedgrouprdn = config.getString("ldap.authorizedgrouprdn");
		authorizedattribute = config.getString("ldap.authorizedattribute");
		
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, hostname: " + hostname);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, port: " + port);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, usingSsl: " + usingSsl);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, basedn: " + basedn);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, usergrouprdn: " + usergrouprdn);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, userattribute: " + userattribute);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, authorizedgrouprdn: " + authorizedgrouprdn);
		play.Logger.debug("GenericLdapAutenticationStrategy.constructor, authorizedattribute: " + authorizedattribute);

	}
	
	/**
	 * Helper method to validate an IAuthStrategy.
	 * Note this should handle error logging, if the state of the
	 * configuration-object isn't valid.
	 * @param config
	 * @return
	 */
	private static void validate(final Configuration config) {
		String[] stringValues = {"ldap.hostname", "ldap.basedn",
				"ldap.usergrouprdn", "ldap.userattribute",
				"ldap.authorizedgrouprdn", "ldap.authorizedattribute",
				"keystorefile", "keystorepassword"};
		String[] integerValues = {"ldap.port"};
		
		for(String value : stringValues) {
			if(config.getString(value) == null) {
				play.Logger.error("GenericLdapAutenticationStrategy lacking configuration string: " + value);
				throw new IllegalStateException("Configuration returns null for " + value);
			}
		}
		
		for(String value : integerValues) {
			if(config.getString(value) == null) {
				play.Logger.error("GenericLdapAutenticationStrategy lacking configuration string: " + value);
				throw new IllegalStateException("Configuration returns null for " + value);
			}
		}
		// Validate the configuration object here
		// String importantConfigurationString = conf.getString("important.configuration");
		// if (importantConfigurationString == null) return false;
		
	}
	
	/**
	 * Helper method to get a connection to the ldap
	 * @return
	 */
	private final LDAPConnection getConnection() {
		StopWatch stopWatch = new Slf4JStopWatch("LdapAuthenticationStrategy.getConnection");
		
		LDAPConnection ldapConnection = null;
		
		// check if it is using ssl or not
		if(usingSsl) {
			try {
				// get the path to the truststore from the application.conf
				String trustStoreString  = Play.application().configuration().getString("keystorefile");
				if(trustStoreString.length() == 0) throw new IllegalArgumentException();
				
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
				String trustStoreString  = Play.application().configuration().getString("keystorefile");
				play.Logger.error("Truststore file does not exist at :'" + trustStoreString + "'. Check trustStoreFile path in your configuration.");
				stopWatch.stop("LdapAuthenticationStrategy.getConnection.failed", e.getMessage());
			} 			
		} else {
			try {
				ldapConnection = new LDAPConnection(hostname, port);
			} catch (LDAPException e) {
				e.printStackTrace();
			}
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
