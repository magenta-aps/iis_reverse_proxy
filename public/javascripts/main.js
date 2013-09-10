$(document).ready(function(){
   	$('#query').focus();
   	
   // very crude check on where to pass the submition
   $('#quicksearchbutton').click(function(event) {
	   processform();
	   event.preventDefault();
   });
   
   $('#query').keypress(function(event) {
	    if(event.which == 13) {
	    	processform(event);
	    	event.preventDefault();
	    }
   });
   
   var processform = function() {

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

       if(cpr.test(query)) {
       		$.post('/search/cpr/', {"query": query}, function(data) {
       			window.location = '/show/uuid/' + data + '/';
       		});
       } else if(containsnumbers.test(query)) {
       	alert('contains numbers and is not a cpr!');
       } else if (lastmiddlefirstname.test(query) || lastfirstname.test(query)) {
       	window.location = '/search/name/' + query.replace(/ *?(?=,)/g, '').replace(/, */g, '/') + '/page/1';
       } else if(lastname.test(query)) {
    	   if(query.length > 0) {
    		   window.location = '/search/name/' + query + '/page/1';
    	   }
       } else {
           alert('error');
       }
   }
});

