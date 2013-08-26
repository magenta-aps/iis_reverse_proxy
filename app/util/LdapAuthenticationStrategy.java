package util;

import com.google.inject.Inject;
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

public class LdapAuthenticationStrategy implements IAuthStrategy {

    private final String hostname;
    private final int port;
    private final String basedn;
    private final String groupdn;
    private final String groupfield;
    
    @Inject
    public LdapAuthenticationStrategy(final String newHostname,
    									final int newPort,
    									final String newBasedn,
    									final String newGroupdn,
    									final String newGroupfield) {
   	
		hostname = newHostname;
		port = newPort;
		basedn  = newBasedn;
		groupdn = newGroupdn;
		groupfield = newGroupfield;
	}
    
    private final LDAPConnection getConnection() {
    	LDAPConnection ldapConnection = null;
        try {
            ldapConnection = new LDAPConnection(hostname, port);
        } catch (final LDAPException lex) {
            play.Logger.error("failed to connect to "
                   + hostname + " "
                   + lex.getMessage());

        } finally {
        	return ldapConnection;
        }
    }

    //TODO make some sort of better report than a boolean report type
    @Override
	public final IAuthResponse authentication(
			final String dn, final String password) {

    	// combine dn + basedn to get userdn
        final String userdn = dn + "," + basedn;
        
		//TODO Remove this Logger
		play.Logger.info("Authentication method");

		// Try to get a connection
		LDAPConnection ldapConnection = getConnection();
		if(ldapConnection == null) {
            return new LdapAuthResponse(AuthResponseType.ERROR, "Connection error");
		}

        try {
            final BindRequest bindRequest =
            		new SimpleBindRequest(userdn, password);
            BindResult bindResult = ldapConnection.bind(bindRequest);
                      
            if (bindResult.getResultCode() == ResultCode.SUCCESS) {

            	// search and check if the user is member of the predefined group
                SearchRequest searchRequest = new SearchRequest(groupdn, 
                        SearchScope.SUB, Filter.createEqualityFilter(groupfield, userdn));

                SearchResult sr = ldapConnection.search(searchRequest);
                
                if(sr.getEntryCount() == 1) {
                	// found one entry, so must be okay
                	return new LdapAuthResponse(AuthResponseType.SUCCESS, "Successful authentication and authorization");
                } else if (sr.getEntryCount() == 0) {
                	// didn't return any, so user isn't authorized
                	return new LdapAuthResponse(AuthResponseType.INFO, "Not authorized");
                } else {
                	// something went wrong!
                	play.Logger.error(this.getClass().getName() + ": return unexpected multiply result - should be 0 or 1");
                	return new LdapAuthResponse(AuthResponseType.ERROR, "Something went wrong");
                }
            } else {
            	// ResultCode != success
                return new LdapAuthResponse(AuthResponseType.INFO, "Invalid credientials");
            }
        } catch (final LDAPException lex) {
            System.err.println("bind failed");
            System.err.println(lex.getMessage());

            return new LdapAuthResponse(AuthResponseType.INFO, "Invalid credientials");

        } finally {
        	// always close the connection afterwards
        	ldapConnection.close();
        }
	}
}
