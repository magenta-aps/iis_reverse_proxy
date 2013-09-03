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
	
	@Security.Authenticated(Secured.class)
	public Result search() {

		Form<SearchInput> searchForm = Form.form(SearchInput.class).bindFromRequest();

		// Check if there is errors (empty strings)
		if (searchForm.hasErrors()) {
			return badRequest(search.render(Form.form(SearchInput.class), null));
		}

		//TODO REMOVE THE FOLLOWING LINE AND ADD IT AS A CONTROLLER METHOD - Just a quick and dirty test
		cprBroker.search(null, null, "Jensen", 100);
		
		//Input type == cprnumber
		IUuid uuid = cprBroker.getUuid(searchForm.get().query);
		
		if (uuid.code() == 200) {
			IPerson person = cprBroker.read(uuid.uuid());
			
			return ok(search.render(Form.form(SearchInput.class), person));
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
