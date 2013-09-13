package util.cprbroker;

import org.joda.time.DateTime;

public interface IPersonAttributes {

	
	String firstname();
	
	String middelname();
	
	String lastname();
	
	String callname();
	
	String nameForAddressing();
	
	//TODO make enum of genders
	String gender();
	
	DateTime birthdate();
		
	String birthplace();
	
	String birthRegisteringAuthority();

}
