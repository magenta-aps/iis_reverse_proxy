package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import itst.dk.PartSoap12;
import oio.sagdok.person._1_0.GetUuidOutputType;
import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.auth.Secured;
import util.cprbroker.ICprBrokerRequest;
import util.cprbroker.IUuidReturnType;
import util.cprbroker.jaxws.Uuid;
import views.html.search;

@Singleton
public class Search extends Controller {

	private static ICprBrokerRequest cprBroker;
	
	@Inject
	public Search(ICprBrokerRequest newCprBroker) {
		cprBroker = newCprBroker;
	}
	
	@Security.Authenticated(Secured.class)
	public Result search() {

		Form<SearchInput> searchForm = Form.form(SearchInput.class).bindFromRequest();

		// Check if there is errors (empty strings)
		if (searchForm.hasErrors()) {
			return badRequest(search.render(Form.form(SearchInput.class), new Uuid("", 0, "")));
		}
		
		//Input type == cprnumber
		IUuidReturnType uuid = cprBroker.getUuid(searchForm.get().query);
		
		
		return ok(search.render(Form.form(SearchInput.class), uuid));
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
