package util;

import play.Play;

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

    private static String hostname;
    private static int port;
    private static String basedn;
    private static String groupdn;
    private static String groupfield;
    

    public LdapAuthenticationStrategy() {

        //TODO Remove this logger
    	play.Logger.info("LdapAuthenticationStrategy constructor!");
    	play.Configuration conf = Play.application().configuration();
		hostname = conf.getString("ldap.hostname");
		port = conf.getInt("ldap.port");
		basedn  = conf.getString("ldap.basedn");
		groupdn = conf.getString("ldap.groupdn");
		groupfield = conf.getString("ldap.groupfield");
	}

    //TODO make some sort of better report than a boolean report type
    @Override
	public final IAuthResponse authentication(
			final String dn, final String password) {

    	// combine dn + basedn to get userdn
        final String userdn = dn + "," + basedn;
        
		//TODO Remove this Logger
		play.Logger.info("Authentication method");

		LDAPConnection ldapConnection;
		
		// Try to get a connection
        try {
            ldapConnection = new LDAPConnection(hostname, port);
        } catch (final LDAPException lex) {
            play.Logger.error("failed to connect to "
                   + hostname + " "
                   + lex.getMessage());
            //TODO Makde this message customizable
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
