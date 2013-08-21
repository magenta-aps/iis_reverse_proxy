package util;

import controllers.routes;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;

public class Secured extends Security.Authenticator {

	@Override
	public final String getUsername(final Context ctx) {
		return ctx.session().get("username");
	}

	@Override
	public final Result onUnauthorized(final Context ctx) {
		return redirect(routes.Application.login());
	}

}
