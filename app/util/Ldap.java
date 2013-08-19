package util;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SimpleBindRequest;


public class Ldap {

	private final String hostname;
	private final int port;
	private final String basedn;
	
	public Ldap(final String hostname, final int port, final String basedn) {
		this.hostname = hostname;
		this.port = port;
		this.basedn = basedn;
	}
	    	
	public boolean auth(final String dn, final String password) {

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
