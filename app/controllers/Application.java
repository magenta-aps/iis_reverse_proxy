package controllers;

import java.util.ArrayList;
import java.util.List;

import play.Play;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.Ldap;
import util.Secured;
import views.html.index;
import views.html.login;

public class Application extends Controller {
  
	final static String hostname = Play.application().configuration().getString("ldap.hostname");
	final static int port = Play.application().configuration().getInt("ldap.port");
	final static String basedn = Play.application().configuration().getString("ldap.basedn");
	
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render(request().username() ));
    }

    public static class Login {
    	@Required(message = "Username is required")
    	public String username;
    	@Required(message = "Password is required")
    	public String password;   	
    }
    
    public static Result login() {
    	return ok(
    			login.render(Form.form(Login.class))
    	);
    }
    
    public static Result authenticate() {
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	
    	// Check if there is errors (empty strings)
    	if(loginForm.hasErrors()) {
    		return badRequest( login.render( loginForm ));
    	}
    	
    	//TODO Remove this hard dependency by dependency injection - Google Guice?
		Ldap ldap = new Ldap(hostname, port, basedn);
		
		boolean isValid = ldap.auth(loginForm.get().username, loginForm.get().password);
		
		if(isValid) {

			session().clear();
	    	session("username", loginForm.get().username);
	    	return redirect(
	    			routes.Application.index()
	    	);    	

		} else {
			List<ValidationError> errors = new ArrayList<ValidationError>();
			ValidationError error = new ValidationError("credentials", "Wrong credentials");
			errors.add(error);
			
			loginForm.errors().put("credentials", errors);
			return badRequest(login.render(loginForm));
		}  	
    }
        
    public static Result logout() {
    	session().clear();
    	flash("success", "You've been logged out");
    	return redirect(
    			routes.Application.login()
    	);
    }
  
}
