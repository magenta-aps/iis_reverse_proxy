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
import util.AuthResponseType;
import util.IAuthResponse;
import util.IAuthStrategy;
import util.LdapAuthResponse;

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

	// TODO Really need to decouple that damned Authentication
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
