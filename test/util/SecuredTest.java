package util;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.callAction;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.header;
import static play.test.Helpers.status;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Result;
import play.test.WithApplication;
/**
 *
 * @author srnkrkgrd
 *
 */
public class SecuredTest extends WithApplication {

	/**
	 * Http Ok response code.
	 */
	static final int HTTP_OK = 200;
	/**
	 * Http Redirect Moved Permanently code.
	 */
	static final int HTTP_REDIRECT = 301;

	@Before
	public void setUp() {
		start(fakeApplication());
	}

	@Test
	public void authenticated() {
		Result result = callAction(
			controllers.routes.ref.Application.index(),
			fakeRequest().withSession("username", "authed@test.com")
		);
		assertEquals(HTTP_OK, status(result));
	}

	@Test
	public void notAuthenticated() {
		Result result = callAction(
				controllers.routes.ref.Application.index(),
				fakeRequest()
		);
		assertEquals(HTTP_REDIRECT , status(result));
		assertEquals("/login", header("Location", result));
	}
}
