require.config({
	paths: { 
        'jquery': '//code.jquery.com/jquery-1.9.1.min',
        'bootstrap': '//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min'
    },
    shim: {
        'bootstrap': [ 'jquery' ]
    }
});

require(["jquery", "bootstrap", "processQuery", "validate", "modolus11"],function($,b,p,v,m) {
	// wait for the document to be ready
	$(function() {
	   	// give focus to the search field
		$('#query').focus();
	   	
	   // handle submition routing
	   $('#quicksearchbutton').click(function(event) {
		   event.preventDefault();
		   var query = $('#query').val(); //get the content of the input field
		   var query2 = $('#query2').val(); //get the content of the input field
		   var online = ($("input[name=online]:checked").val() == "true");
		   p.processQuery(query, query2,online);
	   });
	   
	   // handle submition routing on enter as well
	   $('#query').keypress(function(event) {
		    if(event.which == 13) {
		    	event.preventDefault();
		    	var query = $('#query').val(); //get the content of the input field
				var query2 = $('#query2').val(); //get the content of the input field
				var online = ($("input[name=online]:checked").val() == "true");
				p.processQuery(query, query2,online);
			}
	   });
	   
	   // validate incomming input
	   $('#query').keyup(function(event) {
     	  var queryfield = $('#query'); // the query input field
    	  var query = queryfield.val(); // value of the input field
    	  var querygroup = $('#querygroup'); // form-group wrapping input

	      v.validateQuery(queryfield, query, querygroup);
	   });
	}); //end ready
});

