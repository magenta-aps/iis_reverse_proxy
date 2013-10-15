package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.auth.Secured;
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


	/**
	 * helper controller passing its request to searchLastMiddleFirstname
	 * 
	 * @param lastname
	 *            String containing a lastname
	 * @return Result with the response from the cprBroker
	 */
	@Security.Authenticated(Secured.class)
	public Result searchLastname(String lastname, int page) {
		return searchLastMiddleFirstname(lastname, null, null, page);
	}

	/**
	 * 
	 * helper controller passing its request to searchLastMiddleFirstname
	 * 
	 * @param lastname
	 *            String containing a lastname
	 * @param firstname
	 *            String containing a firstname
	 * @return Result with the response from the cprBroker
	 */
	public Result searchLastFirstname(String lastname, String firstname,
			int page) {
		return searchLastMiddleFirstname(lastname, null, firstname, page);
	}

	/**
	 * 
	 * @param lastname
	 *            String containing a lastname
	 * @param middlename
	 *            String containing a middlename(s)
	 * @param firstname
	 *            String containing a firstname
	 * @return Result with the response from the cprBroker
	 */
	@Security.Authenticated(Secured.class)
	public Result searchLastMiddleFirstname(String lastname, String middlename,
			String firstname, int page) {
		
		// Logging the search
		play.Logger.info(session("username") + " searched for: " + 
				lastname + ", " +
				middlename + ", " +
				firstname);

		// search for the results
		IUuids uuids = cprBroker
				.search(firstname, middlename, lastname, -1, -1);

		// logging the returned resultcode
		play.Logger.info(session("username") +
				"'s search request to CPRBroker responded, " +
				uuids.code() +
				" - " +
				uuids.message() +
				", results: " +
				uuids.values().size());
		
		if (uuids.code() == 200) {
			
			// calculate the searchIndex, which is the starting point of the
			// search
			int fromIndex = ((page - 1) * 10);
			int toIndex = ((page) * 10);

			// log what page the user requested
			play.Logger.info(session("username") + 
					" requested page " + 
					page + 
					", showing " +
					fromIndex +
					"-" +
					toIndex);

			
			if (uuids.values().size() < fromIndex)
				return badRequest();

			if (uuids.values().size() < toIndex)
				toIndex = uuids.values().size();
			
			IUuids subUuuids = new Uuids(uuids.code(), uuids.message(), uuids
					.values().subList(fromIndex, toIndex));
			
			
			List<IPerson> persons = cprBroker.list(subUuuids,
					ESourceUsageOrder.LocalOnly);

			String path = request().path();
			path = path.substring(0, path.indexOf("page") + 5);

			String query = (lastname != null) ? ((firstname != null) ? ((middlename != null) ? lastname
					+ ", " + middlename + ", " + firstname
					: lastname + ", " + firstname)
					: lastname)
					: "";

			return ok(list.render(persons, uuids.values().size(), page, path,
					query));
		}

		// TODO Make a decent error! bad request
		return ok();
	}

	/**
	 * 
	 * @param uuid
	 *            String with the uuid of a person
	 * @return Result containing the response from the cprBroker
	 */
	@Security.Authenticated(Secured.class)
	public Result show(String uuid) {
		// Logging the show request
		play.Logger.info(session("username") +
				" requested to see uuid " +
				uuid);

		IPerson person = cprBroker
				.read(uuid, ESourceUsageOrder.LocalOnly, true);

		// Logging the show request
		play.Logger.info(session("username") +
				"'s request to CPRBroker responded, " +
				person.code() +
				" - " +
				person.message());

		if(person.code() == 200) {
			return ok(search.render(Form.form(SearchInput.class), person));	
		} else {
			//TODO - If Person isn't found local ask if user wants to look external
			return ok();
		}
		

	}

	@Security.Authenticated(Secured.class)
	public Result searchCpr() {

		Form<SearchInput> searchForm = Form.form(SearchInput.class)
				.bindFromRequest();

		// Logging the search
		play.Logger.info(session("username") + " searched for: " + 
				searchForm.get().query);
		
		// Check if there is errors (empty strings)
		if (searchForm.hasErrors()) {		
			return badRequest("Form had errors");
		}

		// Input type == cprnumber
		IUuid uuid = cprBroker.getUuid(searchForm.get().query);

		// logging the returned resultcode
		play.Logger.info(session("username") +
				"'s search request to CPRBroker responded, " +
				uuid.code() +
				" - " +
				uuid.message());
		
		if (uuid.code() == 200) {
			return ok(uuid.value());
		} else {
			play.Logger.info("search form has errors");
			return badRequest("CPR not found in local");
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
