	    $(document).ready(function(){
		   	$('#query').focus();

		    // Attach a click handler for the pagination
		   	$('.pagination > li > a').click(function() {

		   	    //make ajax call
		   		$.ajax({
			   		type: "POST",
		   			url: "/ajax/pagination/",
		   			contentType: "application/json; charset=utf-8",
		   		    dataType: "json",
		   		    data: JSON.stringify( {
			   		    "lastname" : "jensen",
			   		    "maxresults" : 10,
			   		    "startindex" : 10 
		   		    })
		   	    }).done(function(){
			   	    console.log("yarr");
		   	    });
		   	    
			   	   
		   	});
		});	  	
       // very crude check on where to pass the submition
       $('#quicksearch').submit(function() {

	        //get the content of the input field
	        var query = $('#query').val();
	
	        // a cpr consists of exactly 10 numbers
	        var cpr = /\b[0-9]{10}$/;
	
	        // containsnumbers
	        var containsnumbers = /[0-9]/;
	
	        // no commas 
	        var lastname = /.*$/;
	
	        // one comma 
	        var lastfirstname = /.*,\s*.*$/;
	
	        // two commas
	        var lastmiddlefirstname = /.*,\s*.*,\s.*$/;

	        //TODO test on empty string
	        if(cpr.test(query)) {
	            var action = 'cpr/' + query + '/';
	        } else if(containsnumbers.test(query)) {
	        	alert('contains numbers and is not a cpr!');
	        	return false;
	        } else if (lastmiddlefirstname.test(query) || lastfirstname.test(query)) {
	        	var action = 'name/' + query.replace(/ *?(?=,)/g, '').replace(/, */g, '/') + '/page/1';
	        } else if(lastname.test(query)) {
	        	var action = 'name/' + query + '/page/1';
	        } else {
	            alert('error');
	            return false;
	        }
	        $("#quicksearch").attr("action", "/search/" + action);
        });
