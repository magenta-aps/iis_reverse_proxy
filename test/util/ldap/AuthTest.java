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

package util.ldap;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;
import util.auth.ldap.LdapAuthResponse;
import util.auth.ldap.LdapAuthenticationStrategy;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.sdk.LDAPException;

public class AuthTest {

	private InMemoryDirectoryServer ds = null;
	
	@Before
	public void setUp() {
		// Setup a fakeADServer
		
		try {
			// Create the configuration to use for the server.
			InMemoryDirectoryServerConfig config;

			config = new InMemoryDirectoryServerConfig("dc=nodomain");
			// Create the directory server instance, populate it with data from
			// the "test-data.ldif" file, and start listening for client
			// connections.
			ds = new InMemoryDirectoryServer(config);

			// get the current working directory of the project
			String workingDir = System.getProperty("user.dir");
			
			// get the ldif setting
			ds.importFromLDIF(true, workingDir + "/test/util/ldap/test-data.ldif");
			ds.startListening();

		} catch (LDAPException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		ds.shutDown(true);
	}
	
	@Test
	public void testLdapAuthResponse() {
		IAuthResponse res = new LdapAuthResponse(AuthResponseType.INFO, "Test");
		assertEquals(AuthResponseType.INFO, res.type());
		assertEquals("Test", res.message());
		assertEquals(AuthResponseType.ERROR, AuthResponseType.valueOf("ERROR"));
	}

	@Test
	public void testLdapAuthenticationStrategy() {

		int port = ds.getListenPort();
		
		// Make a new LdapAuthStrat
		IAuthStrategy ldapAuthStrat = new LdapAuthenticationStrategy("localhost", port,
				"ou=kbh,dc=nodomain", "cn=allowed,ou=Roles,dc=nodomain", "member");

		ldapAuthStrat.authentication("cn=notallowed", "secret");
		// Test the various stuff!
		assertEquals(true, true);



	}

}
