package util.auth.unboundid;

import com.unboundid.ldap.sdk.LDAPInterface;

/**
 * Interface for getting an connection to authorize against using the Unboundid
 * SDK. Meant to be used as an Adapter pattern and pass the actual work to the
 * IUnboundidConnectionStrategy. 
 * @author Søren Kirkegård
 *
 */
public interface IUnboundidConnection {
	
	LDAPInterface getConnection();

}
