package controllers;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.Secured;
import views.html.search;

public class Search extends Controller {

	@Security.Authenticated(Secured.class)
	public static Result search() {

		Form<SearchInput> searchForm = Form.form(SearchInput.class).bindFromRequest();

		// Check if there is errors (empty strings)
		if (searchForm.hasErrors()) {
			return badRequest(search.render(Form.form(SearchInput.class), "Form has errors"));
		}

		
		return ok(search.render(Form.form(SearchInput.class), searchForm.toString() ));
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
