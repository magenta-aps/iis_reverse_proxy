package util;

import play.Play;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SimpleBindRequest;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LdapAuthenticationStrategy implements IAuthenticationStrategy {

	private static String hostname;
	private static int port;
	private static String basedn;
	
	public LdapAuthenticationStrategy() {
		//TODO: Remove this Logger
		play.Logger.info("constructor!");
		
		hostname = Play.application().configuration().getString("ldap.hostname");
		port = Play.application().configuration().getInt("ldap.port");
		basedn  = Play.application().configuration().getString("ldap.basedn");
	}
	    	
	public boolean authentication(final String dn, final String password) {

		//TODO: Remove this Logger
		play.Logger.info("Authentication method");

        LDAPConnection ldapConnection;     

        try {
            ldapConnection = new LDAPConnection(hostname,port);
        } catch(final LDAPException lex) {
            System.err.println("failed to connect to "
                   + hostname + " " +
                   lex.getMessage());
            return false;
        }

        try {
            final BindRequest bindRequest = new SimpleBindRequest(dn+","+basedn, password);
            BindResult bindResult = ldapConnection.bind(bindRequest);
            
            if(bindResult.getResultCode() == ResultCode.SUCCESS) {
            	return true;
            }
                       
        } catch(final LDAPException lex ) {
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
