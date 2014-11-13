/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package controllers;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.auth.Secured;
import util.cprbroker.*;
import util.cprbroker.models.Uuids;
import views.html.list;
import views.html.search;
import views.html.show_error;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Search extends Controller {

    private static ICprBrokerAccessor cprBroker;

    @Inject
    public Search(ICprBrokerAccessor newCprBroker) {
        cprBroker = newCprBroker;
    }


    /**
     * @param lastname   String containing a lastname
     * @param middlename String containing a middlename(s)
     * @param firstname  String containing a firstname
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
        IUuids uuids = cprBroker.search(firstname, middlename, lastname, -1, -1);

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

            String query = getQuery(firstname, lastname, middlename, null);

            return ok(list.render(persons, uuids.values().size(), page, path,
                    query));
        }

        // TODO Make a decent error! bad request
        return ok();
    }

    private String getQuery(String firstname, String middlename, String lastname, String address) {
        String ret = "";
        if (lastname != null) {
            if (firstname != null) {
                if (middlename != null) {
                    ret = firstname + ", " + middlename + ", " + lastname;
                } else {
                    ret = firstname + ", " + lastname;
                }
            } else {
                ret = lastname;
            }
        } else {
            ret = "";
        }

        if (address != null && !address.isEmpty()) {
            ret += " " + address;
        }
        return ret;
    }

    @Security.Authenticated(Secured.class)
    public Result searchNameAndAddress(String firstname, String middlename, String lastname, String address, boolean online, int page) {

        List<IPerson> persons = cprBroker.searchList(
                firstname, middlename, lastname,
                address,
                online ? ESourceUsageOrder.ExternalOnly : ESourceUsageOrder.LocalOnly,
                -1, -1);

        String path = request().path();
        path = path.substring(0, path.indexOf("page") + 5);

        String query = getQuery(firstname, middlename, lastname, address);

        return ok(list.render(persons, persons.size(), page, path,
                query));
    }

    /**
     * @param uuid String with the uuid of a person
     * @return Result containing the response from the cprBroker
     */
    @Security.Authenticated(Secured.class)
    public Result show(String uuid) {
        // Logging the show request
        play.Logger.info(session("username") +
                " requested to see uuid " +
                uuid);

        IPerson person = cprBroker
                .read(uuid, true);

        // Logging the show request
        play.Logger.info(session("username") +
                "'s request to CPRBroker responded, " +
                person.code() +
                " - " +
                person.message());

        if (person.code() == 200) {
            return ok(search.render(person));
        } else {
            //TODO - A person wasn't found
            return ok(show_error.render(person.code()));
        }
    }

    @Security.Authenticated(Secured.class)
    public Result getUuidFromCpr() {

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
            // this should never happen as person master will just assign
            // a new uuid if it doesn't exist
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

        public String addressQuery;

        public String getAddressQuery() {
            return addressQuery;
        }

        public void setAddressQuery(String query) {
            this.addressQuery = query;
        }

        public boolean online;

        public boolean getOnline() {
            return this.online;
        }

        public void setOnline(boolean value) {
            this.online = value;
        }


    }

}
