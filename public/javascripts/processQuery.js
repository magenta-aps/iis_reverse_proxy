define(function() {
    return {
         processQuery: function(query) {

        	    var cpr = /\b[0-9]{10}$/; // a cpr consists of exactly 10 numbers
        	    var cprpattern = /[0-9]{6}-[0-9]{4}$/; // or 10 numbers with a - between 6th and 7th char 
        	    var lastname = /.*$/; // no commas 
        	    var firstlastname = /.*,\s*.*$/; // one comma 
        	    var firstmiddlelastname = /.*,\s*.*,\s.*$/; // two commas

        	    if(cpr.test(query)) {
        	    		$.post('/search/cpr/', {"query": query}, function(data) {
        	    			window.location = '/show/uuid/' + data + '/';
        	    		});
        	    } 
        	    else if (cprpattern.test(query)) {
        	   		$.post('/search/cpr/', {"query": query.replace("-", "")}, function(data) {
        	    			window.location = '/show/uuid/' + data + '/';
        	    		});    	   
        	    }
        	    
        	    else if (firstmiddlelastname.test(query) || firstlastname.test(query)) {
        	    	window.location = '/search/name/' + query.replace(/ *?(?=,)/g, '').replace(/, */g, '/') + '/page/1';
        	    } 
        	    
        	    else if(lastname.test(query)) {
        	 	   if(query.length > 0) {
        	 		   window.location = '/search/name/' + query + '/page/1';
        	 	   }
        	    } 
        	    
        	    else {
        	        alert('error');
        	    }
        	}
    }
});