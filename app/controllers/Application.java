package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.auth.AuthResponseType;
import util.auth.IAuthResponse;
import util.auth.IAuthStrategy;
import util.auth.Secured;
import views.html.index;
import views.html.login;
import controllers.Search.SearchInput;

/**
 * 
 * @author Søren Kirkegård
 *
 */
@Singleton
public class Application extends Controller {
	
	private static IAuthStrategy authenticationStrategy;
	
	/**
	 * 
	 * @param newAuthenticationStrategy
	 */
	@Inject
	public Application(IAuthStrategy newAuthenticationStrategy) {
		authenticationStrategy = newAuthenticationStrategy;
	}
		
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render(Form.form(SearchInput.class), request().username()));
    }

    public static class Login {
   	
    	@Required
    	public String username;

    	@Required
    	public String password;


    	public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
    }

    public static Result login() {
    	return ok(
    			login.render(Form.form(Login.class))
    	);
    }

    public Result authenticate() {
    	
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

    	// Check if there is errors (empty strings)
    	if (loginForm.hasErrors()) {
    		return badRequest(login.render(loginForm));
    	}

    	IAuthResponse authResponse = authenticationStrategy.authentication(
						loginForm.get().username,
						loginForm.get().password);
    	   	
		if (authResponse.type().equals(AuthResponseType.SUCCESS)) {
			session().clear();
	    	session("username", loginForm.get().username);
	    	
	    	play.Logger.info("[" + request().remoteAddress() + "] " +
	    			session("username") +  
	    			" has succesfully logged in.");

	    	
	    	return redirect(
	    			routes.Application.index()
	    	);
		} else {
			List<ValidationError> errors =
					new ArrayList<ValidationError>();
			ValidationError error =
					new ValidationError(authResponse.type().toString(),
							play.i18n.Messages.get(authResponse.message()));
			errors.add(error);
			loginForm.errors().put("error", errors);

			// logging the login attempt
			play.Logger.info("[" + request().remoteAddress() + "] " +
							 "Login attempt with bad credientials.");
			
			return badRequest(login.render(loginForm));
		}
    }

    public static Result logout() {

    	// logging that a user has logged out
    	play.Logger.info("[" + request().remoteAddress() + "] " +
    			session("username") + 
    			" has succesfully logged out.");
    	
    	session().clear();
    	//flash("success", play.i18n.Messages.get("logout.succesful"));
    	return redirect(
    			routes.Application.login()
    	);
    }
}
