package controllers;

import models.User;
import play.data.Form;
import play.libs.Scala;
import play.mvc.Controller;
import play.mvc.Result;
import util.Ldap;
import views.html.data;

public class Data extends Controller {
	
	static Form<User> userForm = Form.form(User.class);

	public static Result test() {
		return ok(data.render(Scala.Option((User) null)));
	}
	
	public static Result post() {
		
		User user = userForm.bindFromRequest().get();
		
		Ldap ldap = new Ldap();
		boolean isValid = ldap.auth(user);
		
		if(isValid) {
			user.authenticated = "true";
		} else {
			user.authenticated = "false";
		}
		
		return ok(data.render(Scala.Option(user)));
	}
}
