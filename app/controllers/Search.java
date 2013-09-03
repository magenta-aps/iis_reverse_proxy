package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.auth.Secured;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.IPerson;
import util.cprbroker.IUuid;
import controllers.Search.SearchInput;
import views.html.*;

@Singleton
public class Search extends Controller {

	private static ICprBrokerAccessor cprBroker;
	
	@Inject
	public Search(ICprBrokerAccessor newCprBroker) {
		cprBroker = newCprBroker;
	}

	public Result error() {
		return ok();
	}

	// route for searching cpr numbers
	// will replace the current search!
	public Result searchCpr(String cpr) {
		play.Logger.info(cpr);
		return ok();
	}
	
	public Result searchLastname(String lastname) {
		return searchLastMiddleFirstname(lastname, null, null);
	}

	public Result searchLastFirstname(String lastname, String firstname) {
		return searchLastMiddleFirstname(lastname, null, firstname);
	}

	
	public Result searchLastMiddleFirstname(String lastname, String middlename, String firstname) {
		play.Logger.info(lastname + ", " + middlename + ", " + firstname);
		
		//TODO REMOVE THE FOLLOWING LINE AND ADD IT AS A CONTROLLER METHOD - Just a quick and dirty test
		cprBroker.search(firstname, middlename, lastname, 100);
		//return ok();
		return redirect(controllers.routes.Search.show("Bob"));
	}
	
	public Result show(String uuid) {
		play.Logger.info(uuid);
		
		IPerson person = cprBroker.read(uuid);
		
		return ok(search.render(Form.form(SearchInput.class), person));
		
	}
	
	//@Security.Authenticated(Secured.class)
	public Result search() {

		Form<SearchInput> searchForm = Form.form(SearchInput.class).bindFromRequest();

		// Check if there is errors (empty strings)
		if (searchForm.hasErrors()) {
			return badRequest(search.render(Form.form(SearchInput.class), null));
		}
		
		//Input type == cprnumber
		IUuid uuid = cprBroker.getUuid(searchForm.get().query);
		
		if (uuid.code() == 200) {		
			return redirect(controllers.routes.Search.show(uuid.uuid()));
		} else {
			return ok(search.render(Form.form(SearchInput.class), null));	
		}	
	}

	public static class SearchInput {

		@Required
		public String query;

		public String getQuery() {
			return query;
		}

		public void setQuery(String query) {
			this.query = query;
		}

	}

}
