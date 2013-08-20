package util;
/**
 * Interface that decouples the implementation of a Authentication Strategy for
 * the application. 
 * @author srnkrkgrd
 *
 */
public interface IAuthenticationStrategy {
	/**
	 * 
	 * @param username username part of credientals to be validated 
	 * @param password password part of credientals to be validated
	 * @return true if user is valid
	 */
	public boolean auth(final String username, final String password);
}
