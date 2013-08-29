package util.cprbroker;

import javax.xml.datatype.XMLGregorianCalendar;

public interface IPersonAttributes {

	
	String firstname();
	
	String middelname();
	
	String lastname();
	
	String callname();
	
	String nameForAdressing();
	
	//TODO make enum of genders
	String gender();
	
	XMLGregorianCalendar birthdate();
		
	String birthplace();
	
	String birthRegisteringAuthority();

}
