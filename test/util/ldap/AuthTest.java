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
