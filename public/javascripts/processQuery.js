define(function () {
    return {
        processQuery: function (query, query2, online) {

            var cpr = /\b[0-9]{10}$/; // a cpr consists of exactly 10 numbers
            var cprpattern = /[0-9]{6}-[0-9]{4}$/; // or 10 numbers with a - between 6th and 7th char
            var lastname = /.*$/; // no commas
            var firstlastname = /.*,\s*.*$/; // one comma
            var firstmiddlelastname = /.*,\s*.*,\s.*$/; // two commas

            var redirectLocation = null;
            var queryExists = false;

            if (cpr.test(query) || cprpattern.test(query)) {
                $.post('/search/cpr/', {"query": query.replace("-", "")}, function (data) {
                    window.location = '/show/uuid/' + data + '/';
                });
            }

            else if (firstmiddlelastname.test(query) || firstlastname.test(query) || lastname.test(query)) {
                redirectLocation = '/search'
                if (query.length > 0) {
                    queryExists = true;
                    redirectLocation += '/name/' + query;
                }
                if (query2.length > 0) {
                    queryExists = true;
                    redirectLocation += '/address/' + query2;
                }
                if (online)
                    redirectLocation += '/online'
                redirectLocation += '/page/1';
            }

            else {
                alert('error');
            }

            if (queryExists) {
                window.location = redirectLocation;
            }

        }
    }
});