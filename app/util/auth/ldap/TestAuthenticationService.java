package util.auth.ldap;

import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;

public class TestAuthenticationService implements IAuthStrategy {

	@Override
	public IAuthResponse authentication(String username, String password) {
		play.Logger.info("User tried to login with: " + username + ", " + password);
		if(username.equals("test") && password.equals("test")) {
			play.Logger.info("Returning AuthResponse with SUCCESS");
			return new LdapAuthResponse(AuthResponseType.SUCCESS, "OK");
		} else {
			return new LdapAuthResponse(AuthResponseType.ERROR, "Bad credientials");
		}
	}

}
