package util.auth;
/**
 * A response object containing the result of the Authentication/Authorization 
 * @author srnkrkgrd
 *
 */
public interface IAuthResponse {
	/**
	 * Get the response message
	 * @return Description of the response
	 */
	String message();
	
	/**
	 * Get the type of the response
	 * @return Reponse type eg. success, error etc
	 */
	AuthResponseType type();
}
