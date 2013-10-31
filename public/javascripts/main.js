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

   $('#query').keyup(function(event) {
      validate();
   });

  /*
   * function to validate a cpr number
   */
  var modolus11 = function(numbers) {
    var num = 4*numbers.charAt(0) +
              3*numbers.charAt(1) +
              2*numbers.charAt(2) +
              7*numbers.charAt(3) +
              6*numbers.charAt(4) +
              5*numbers.charAt(5) +
              4*numbers.charAt(6) +
              3*numbers.charAt(7) +
              2*numbers.charAt(8) +
              1*numbers.charAt(9);

    if(num%11 == 0) {
      return true;
    }
    return false;
  }

  var validate = function() {
    var queryfield = $('#query'); // the query input field
    var query = queryfield.val(); // value of the input field
    var querygroup = $('#querygroup'); // form-group wrapping input
    var submit = $('#quicksearchbutton');
    var containsspecialcharacters = /\½|\§|\!|\"|\@|\#|\£|\¤|\$|\%|\&|\/|\{|\(|\[|\)|\]|\=|\}|\?|\+|\'|\`|\||\^|\~|\*|\_|\;|\:|\.|\+/;
    var containsnumbers = /[0-9]/;
    var containsletters = /[a-zA-Z]/;
    var cprpattern = /[0-9]{6}-[0-9]/;

    //reset the color
    querygroup.removeClass('has-success');
    querygroup.removeClass('has-error');
    querygroup.removeClass('has-warning');

    queryfield.popover('destroy');

    //if the query has special characters
    if(containsspecialcharacters.test(query)) {
      querygroup.addClass('has-warning');
      queryfield.attr('data-original-title', 'Bemærk');
      queryfield.attr('data-content', 'Din søgning indeholder et eller flere specialtegn.')
      queryfield.popover('show');
    }

    //if the query contains numbers and letters
    else if(containsnumbers.test(query) & containsletters.test(query)) {
      querygroup.addClass('has-warning');
      queryfield.attr('data-original-title', 'Bemærk');
      queryfield.attr('data-content', 'Din søgning indeholder en kombination af tal og bogstaver')
      queryfield.popover('show');

    }

    //if the query has only numbers
    else if(containsnumbers.test(query) & !containsletters.test(query) & !containsspecialcharacters.test(query)) {
      //if there is less than 6 numbers
      if(query.length < 6) {
        querygroup.addClass('has-warning');   
      }

      //if there is more than 5 numbers, but less than 10
      else if(query.length > 5 & query.length < 10) {
        // validate that the first 6 numbers is a valid date
        querygroup.addClass('has-warning');
      }
      
      else if(query.length > 5 & query.length < 11 & cprpattern.test(query)) {
        // validate that the first 6 numbers is a valid date    	  
        querygroup.addClass('has-warning');
      }

      //if there is more than 10 numbers
      else if((query.length > 10 & !cprpattern.test(query)) |
    		  (query.length > 11 & cprpattern.test(query))) {
        querygroup.addClass('has-error');
        queryfield.attr('data-original-title', 'Bemærk');
        queryfield.attr('data-content', 'Din søgning indeholder over 10 tal. Et CPR nummer indeholder kun 10.')
        queryfield.popover('show');

      }

      //if there is 10 numbers
      else if((query.length == 10 & !cprpattern.test(query)) |
    		  (query.length == 11 & cprpattern.test(query))) {
        // is the date 010165 or 010166
        if(query.substring(0,6) == '010165' | query.substring(0,6) == '010166') {
          querygroup.addClass('has-success');  
        } 
        else if(!cprpattern.test(query) & modolus11(query)) {
          querygroup.addClass('has-success');
        }
        else if(cprpattern.test(query) & modolus11(query.replace("-", ""))) {
            querygroup.addClass('has-success');
        }
        else {
          querygroup.addClass('has-error');
          queryfield.attr('data-original-title', 'Bemærk');
          queryfield.attr('data-content', 'Dette er ikke et gyldigt CPR nummer.')
          queryfield.popover('show');
        }
      } 
    }
    // everything else is considered valid, 
    else if (query.length > 0){
        querygroup.addClass('has-success');
    }
   }

   var processform = function() {

       var query = $('#query').val(); //get the content of the input field
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
});

