package util;

import models.User;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SimpleBindRequest;


public class Ldap {

    final String hostname = "localhost";
    final int port = 389;
    //final String dn = "cn=admin,dc=nodomain";
    //final String password = "nosoup4u";
    	
	public boolean auth(User user) {

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
            final BindRequest bindRequest = new SimpleBindRequest(user.dn, user.password);
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
