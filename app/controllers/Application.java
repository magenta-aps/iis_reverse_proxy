package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.login;
import play.mvc.Http.Session;
import play.mvc.Security;

public class Application extends Controller {
  
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static class Login {
    	public String username;
    	public String password;
    }
    
    public static Result login() {
    	return ok(
    			login.render(Form.form(Login.class))
    	);
    }
    
    public static Result authenticate() {
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	
    	session().clear();
    	session("username", loginForm.get().username);
    	return redirect(
    			routes.Application.index()
    	);    	
    }
    
    public static Result logout() {
    	session().clear();
    	flash("success", "You've been logged out");
    	return redirect(
    			routes.Application.login()
    	);
    }
  
}
