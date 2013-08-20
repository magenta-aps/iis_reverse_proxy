package util;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

import org.junit.*;

import controllers.routes.ref;

import play.mvc.Result;
import play.test.WithApplication;

public class SecuredTest extends WithApplication {

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
		assertEquals(200, status(result));
	}

	@Test
	public void notAuthenticated() {
		Result result = callAction(
				controllers.routes.ref.Application.index(),
				fakeRequest()
		);
		assertEquals(303, status(result));
		assertEquals("/login", header("Location", result));
	}
}
