package util;

import net.sf.ehcache.config.generator.ConfigurationSource;
import play.Play;
import play.api.Configuration;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SimpleBindRequest;

public class LdapAuthenticationStrategy implements IAuthenticationStrategy {

    private static String hostname;
    private static int port;
    private static String basedn;

    public LdapAuthenticationStrategy() {

        //TODO Remove this logger
    	play.Logger.info("constructor!");
    	play.Configuration conf = Play.application().configuration();
		hostname = conf.getString("ldap.hostname");
		port = conf.getInt("ldap.port");
		basedn  = conf.getString("ldap.basedn");
	}

    @Override
	public final boolean authentication(
			final String dn, final String password) {

		//TODO Remove this Logger
		play.Logger.info("Authentication method");

		LDAPConnection ldapConnection;

        try {
            ldapConnection = new LDAPConnection(hostname, port);
        } catch (final LDAPException lex) {
            System.err.println("failed to connect to "
                   + hostname + " "
                   + lex.getMessage());
            return false;
        }

        try {
            final BindRequest bindRequest =
            		new SimpleBindRequest(dn + "," + basedn, password);
            BindResult bindResult = ldapConnection.bind(bindRequest);

            if (bindResult.getResultCode() == ResultCode.SUCCESS) {
            	return true;
            }

        } catch (final LDAPException lex) {
            System.err.println("bind failed");
            System.err.println(lex.getMessage());

            return false;

        } finally {
        	// always close the connection afterwards
        	ldapConnection.close();
        }

		return false;
	}
}
