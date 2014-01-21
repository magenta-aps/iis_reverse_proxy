package util.auth.unboundid;

import com.unboundid.ldap.sdk.LDAPInterface;

/**
 * Strategy interface for getting an connection to authorize against using the
 * Unboundid SDK.
 * @author Søren Kirkegård
 *
 */
public interface IUnboundidConnection {
	
	LDAPInterface getConnection();

}
