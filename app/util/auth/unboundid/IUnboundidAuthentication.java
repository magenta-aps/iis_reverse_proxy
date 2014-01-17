package util.auth.unboundid;

import util.auth.IAuthentication;

/**
 * Extention of the IAuthentication. Suggested to be as a Adapter pattern for
 * the strategies IAuthenticationStrategy and IUnboundidConnectionStrategy
 * @author Søren Kirkegård
 *
 */
public interface IUnboundidAuthentication extends IAuthentication, IUnboundidConnection {

}
