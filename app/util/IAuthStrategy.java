package util;
/**
 * Interface that decouples the implementation of a Authentication Strategy for
 * the application.
 * @author srnkrkgrd
 *
 */
public interface IAuthStrategy {
	/**
	 *  @param username username part of credientals to be validated
	 * @param password password part of credientals to be validated
	 * @return true if user is valid
	 */
	IAuthResponse authentication(final String username, final String password);

	//TODO Add Authorization maybe in its own file?
}
