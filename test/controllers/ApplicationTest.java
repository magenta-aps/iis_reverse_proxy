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

package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.test.Helpers.callAction;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.GlobalSettings;
import play.data.Form;
import play.mvc.Result;
import play.test.WithApplication;
import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;

public class ApplicationTest extends WithApplication {

	/**
	 * Http Ok response code.
	 */
	static final int HTTP_OK = 200;

	/**
	 * Http Redirect See Other code.
	 */
	static final int HTTP_REDIRECT = 303;

	/**
	 * Http Bad Request code.
	 */
	static final int HTTP_BAD_REQUEST = 400;

	/**
	 * Private helper class to fake the global settings of a play application
	 * in order to seperate testing of the application controller from an 
	 * actual implementation of IAuthStrategy.
	 * @author Søren Kirkegård
	 *
	 */
	private class MockedGlobal extends GlobalSettings {
		
		@SuppressWarnings("unchecked")
		@Override
		public <A> A getControllerInstance(Class<A> arg0) throws Exception {

			//Mocking
			IAuthStrategy mockedStrategy = mock(IAuthStrategy.class);
			IAuthResponse mockedSuccessResponse = mock(IAuthResponse.class);
			IAuthResponse mockedErrorResponse = mock(IAuthResponse.class);
			
			//Mocking a successful request
			when(mockedStrategy.authentication("username", "goodpassword")).thenReturn(mockedSuccessResponse);
			when(mockedSuccessResponse.type()).thenReturn(AuthResponseType.SUCCESS);
			
			//Mocking a successful request
			when(mockedStrategy.authentication("username", "badpassword")).thenReturn(mockedErrorResponse);
			when(mockedErrorResponse.type()).thenReturn(AuthResponseType.ERROR);
			when(mockedErrorResponse.message()).thenReturn("Test error");


			return (A) new Application(mockedStrategy);
		}
	}

	
	@Before
	public void setUp() {
		
		Map<String, Object> config = new HashMap<String, Object>();
		List<String> plugins = new ArrayList<String>();
		
		// Make the MockedGlobal class
	    GlobalSettings global = new MockedGlobal();
	    
	    // Start the fakeApplication with the mockedglobal
	    start(fakeApplication(config, plugins, global));
	    		   
	}

	@Test
	public void testStaticLoginClass() {
		Application.Login login = new Application.Login();
		login.setUsername("Dummy");
		login.setPassword("secret");
		assertEquals("Dummy", login.getUsername());
		assertEquals("secret", login.getPassword());
	}

	@Test
	public void callLogin() {
		Result result = callAction(controllers.routes.ref.Application.login(),
				fakeRequest());
		assertEquals(HTTP_OK, status(result));
	}

	@Test
	public void callLogout() {
		Result result = callAction(controllers.routes.ref.Application.logout(),
				fakeRequest());
		assertEquals(HTTP_REDIRECT, status(result));
	}

	@Test
	public void callAuthenticateWithValidCredientials() {

		Map<String, String> data = new HashMap<String, String>();
		data.put("username", "username");
		data.put("password", "goodpassword");

		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest().withFormUrlEncodedBody(
						Form.form(Application.Login.class).bind(data).data()));
		assertEquals(HTTP_REDIRECT, status(result));
		// TODO Test returned errors
	}

	@Test
	public void callAuthenticateWithBadCredientials() {

		Map<String, String> data = new HashMap<String, String>();
		data.put("username", "username");
		data.put("password", "badpassword");

		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest().withFormUrlEncodedBody(
						Form.form(Application.Login.class).bind(data).data()));
		assertEquals(HTTP_BAD_REQUEST, status(result));
		// TODO Test returned errors
	}

	@Test
	public void callAuthenticateWithFormErrors() {

		Map<String, String> data = new HashMap<String, String>();

		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest().withFormUrlEncodedBody(
						Form.form(Application.Login.class).bind(data).data()));
		assertEquals(HTTP_BAD_REQUEST, status(result));
		// TODO Test returned errors
	}

}
