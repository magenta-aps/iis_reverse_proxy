package util.auth.unboundid.implementations;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

import javax.inject.Inject;

import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;

import play.Play;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.util.ssl.SSLUtil;
import com.unboundid.util.ssl.TrustStoreTrustManager;

import conf.IConfiguration;
import util.auth.unboundid.IUnboundidConnection;

public class UnboundidConnection implements IUnboundidConnection {

	public static final int DEFAULT_PORT = 389;
	public static final int DEFAULT_SSL_PORT = 636;
	
	private final String hostname;
	private final int port;
	private final boolean usingSsl;
	
	private final IConfiguration configuration;
	
	@Inject
	public UnboundidConnection(final IConfiguration configuration) {
		
		this.configuration = configuration;
		
		play.Configuration config = this.configuration.getConfiguration();
		hostname = config.getString("ldap.hostname");
		usingSsl = config.getBoolean("ldap.ssl");
		// is a custom port defined?
		if (config.getInt("ldap.port") == null) {
			//if not use defaults
			port = (usingSsl == true) ? DEFAULT_SSL_PORT : DEFAULT_PORT ;
		} else {
			//else use the custom
			port = config.getInt("ldap.port");
		}
		
		play.Logger.debug("UnboundidConnection.constructor, hostname: " + hostname);
		play.Logger.debug("UnboundidConnection.constructor, port: " + port);
		play.Logger.debug("UnboundidConnection.constructor, usingSsl: " + usingSsl);
	}
	
	@Override
	public LDAPInterface getConnection() {
		StopWatch stopWatch = new Slf4JStopWatch("UnboundidConnection.getConnection");
		
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
				stopWatch.stop("UnboundidConnection.getConnection.failed", e.getMessage());
				
			} catch (FileNotFoundException e) {
				String trustStoreString  = Play.application().configuration().getString("keystorefile");
				play.Logger.error("Truststore file does not exist at :'" + trustStoreString + "'. Check trustStoreFile path in your configuration.");
				stopWatch.stop("UnboundidConnection.getConnection.failed", e.getMessage());
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
}
