package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.callAction;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.data.Form;
import play.mvc.Result;
import play.test.WithApplication;

public class ApplicationTest extends WithApplication  {
	
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

	@Before
	public void setUp() {
		start(fakeApplication());
	}
	
	@Test
	public void testApplicationIsInstantiable() {
		Application app = new Application();
		assertNotNull(app);
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
		Result result = callAction(
				controllers.routes.ref.Application.login(),
				fakeRequest()
		);
		assertEquals(HTTP_OK , status(result));
	}
	
	@Test
	public void callLogout() {
		Result result = callAction(
				controllers.routes.ref.Application.logout(),
				fakeRequest()
		);
		assertEquals(HTTP_REDIRECT , status(result));
	}

	//TODO Really need to decouple that damned Authentication
	@Test
	public void callAuthenticateWithValidCredientials() {

		Map<String, String> data = new HashMap<String, String>();
	    data.put("username", "cn=soren+sn=kirkegaard");
	    data.put("password", "nosoup4u");


		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest()
					.withFormUrlEncodedBody(
							Form.form(Application.Login.class)
							.bind(data)
							.data())
		);
		assertEquals(HTTP_REDIRECT, status(result));
		//TODO Test returned errors
	}

	
	@Test
	public void callAuthenticateWithBadCredientials() {

		Map<String, String> data = new HashMap<String, String>();
	    data.put("username", "test1");
	    data.put("password", "test2");


		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest()
					.withFormUrlEncodedBody(
							Form.form(Application.Login.class)
							.bind(data)
							.data())
		);
		assertEquals(HTTP_BAD_REQUEST , status(result));
		//TODO Test returned errors
	}
	
	@Test
	public void callAuthenticateWithFormErrors() {

		Map<String, String> data = new HashMap<String, String>();


		Result result = callAction(
				controllers.routes.ref.Application.authenticate(),
				fakeRequest()
					.withFormUrlEncodedBody(
							Form.form(Application.Login.class)
							.bind(data)
							.data())
		);
		assertEquals(HTTP_BAD_REQUEST , status(result));
		//TODO Test returned errors
	}

}
