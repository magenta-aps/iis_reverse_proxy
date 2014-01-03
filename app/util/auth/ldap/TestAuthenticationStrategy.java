/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package util.auth.ldap;

import play.Configuration;
import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;
/**
 * Example implementation of the IAuthStrategy
 * @author Søren Kirkegård
 *
 */
public class TestAuthenticationStrategy implements IAuthStrategy {

	/**
	 * Constructor taking a configuration-object and validating it.
	 * @param config
	 */
	public TestAuthenticationStrategy(final play.Configuration config) {
		//Use the importantConfigurationString
		validate(config);
	}

	/**
	 * Helper method to validate an IAuthStrategy.
	 * Note this SHOULD handle error logging, if the state of the
	 * configuration-object isn't valid and throw an IllegalStateException.
	 * @param config
	 * @return
	 */
	private static void validate(final Configuration config) {
		
		// Validate the configuration object here
		// String importantConfigurationString = conf.getString("important.configuration");
		// if (importantConfigurationString == null) throw new IllegalStateException();
		
	}

	@Override
	public IAuthResponse authentication(final String username, final String password) {
		play.Logger.info("User tried to login with: " + username + ", " + password);
		if(username.equals("test") && password.equals("test")) {
			play.Logger.info("Returning AuthResponse with SUCCESS");
			return new LdapAuthResponse(AuthResponseType.SUCCESS, "OK");
		} else {
			return new LdapAuthResponse(AuthResponseType.ERROR, "Forkert brugernavn eller kodeord");
		}
	}	
}
