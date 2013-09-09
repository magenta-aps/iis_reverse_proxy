package controllers;

import java.awt.image.renderable.RenderableImage;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.cprbroker.ESourceUsageOrder;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.IPerson;
import util.cprbroker.IUuid;
import util.cprbroker.IUuids;
import util.cprbroker.models.Uuids;
import views.html.list;
import views.html.search;

@Singleton
public class Search extends Controller {

	private static ICprBrokerAccessor cprBroker;
	
	@Inject
	public Search(ICprBrokerAccessor newCprBroker) {
		cprBroker = newCprBroker;
	}

	// route for searching cpr numbers
	// will replace the current search!
	public Result searchCpr(String cpr) {
		
		//Input type == cprnumber
		IUuid uuid = cprBroker.getUuid(cpr);
		
		if (uuid.code() == 200) {		
			return redirect(controllers.routes.Search.show(uuid.uuid()));
		} else {
			return ok(search.render(Form.form(SearchInput.class), null));	
		}	
	}
	
	/**
	 * helper controller passing its request to searchLastMiddleFirstname
	 * @param lastname String containing a lastname
	 * @return Result with the response from the cprBroker
	 */
	public Result searchLastname(String lastname, int page) {
		return searchLastMiddleFirstname(lastname, null, null, page);
	}

	/**
	 * 
	 * helper controller passing its request to searchLastMiddleFirstname
	 * @param lastname String containing a lastname
	 * @param firstname String containing a firstname
	 * @return Result with the response from the cprBroker
	 */
	public Result searchLastFirstname(String lastname, String firstname, int page) {
		return searchLastMiddleFirstname(lastname, null, firstname, page);
	}
	
	
	/**
	 * 
	 * @param lastname String containing a lastname
	 * @param middlename String containing a middlename(s)
	 * @param firstname String containing a firstname
	 * @return Result with the response from the cprBroker
	 */
	public Result searchLastMiddleFirstname(String lastname, String middlename, String firstname, int page) {
		play.Logger.info(lastname + ", " + middlename + ", " + firstname);
				
		// search for the results
    	IUuids uuids = cprBroker.search(firstname, middlename, lastname, -1, -1);
		
		if(uuids.code() == 200) {
		
			// calculate the searchIndex, which is the starting point of the search
			int fromIndex = ((page-1)*10);
			int toIndex = ((page)*10);
			
			if(uuids.uuids().size() < fromIndex) return badRequest();
			
			if(uuids.uuids().size() < toIndex) toIndex = uuids.uuids().size();
			IUuids subUuuids = new Uuids(uuids.code(), uuids.message(), uuids.uuids().subList(fromIndex, toIndex));  

			List<IPerson> persons = cprBroker.list(subUuuids, ESourceUsageOrder.LocalOnly);
			
			String path = request().path();
			path = path.substring(0, path.indexOf("page") + 5 );
			
			return ok(list.render(persons, uuids.uuids().size(), page, path));
		}
		
		//TODO Make a decent error! bad request
		return ok();
	}
	
			
	/**
	 * 
	 * @param uuid String with the uuid of a person
	 * @return Result containing the response from teh cprBroker
	 */
	public Result show(String uuid) {
		play.Logger.info(uuid);
		
		IPerson person = cprBroker.read(uuid, ESourceUsageOrder.LocalOnly, true);
		
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

		public String getQuery() { return query; }

		public void setQuery(String query) { this.query = query; }

	}

}
