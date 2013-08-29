package util.cprbroker.models;

import javax.xml.datatype.XMLGregorianCalendar;

import util.cprbroker.IAddress;
import util.cprbroker.IPerson;
import util.cprbroker.IRegisterInformation;

public class Person implements IPerson{

	// basic attributes
	private final int code;
	private final String message;
	private final String uuid;

	// newest person attributes
	private final String firstname;
	private final String middelname;
	private final String lastname;
	private final String callname;
	private final String nameForAdressing;
	private final String gender;
	private final XMLGregorianCalendar birthdate;
	private final String birthplace;
	private final String birthRegisteringAuthority;
	
	// register information
	private final IRegisterInformation registerInformation;
	
	// address
	private final IAddress address;
	
	/**
	 * Builder for a Person
	 * @author srnkrkgrd
	 *
	 */
	public static class Builder {
		//Required parameters
		private final int code;
		private final String message;
		private final String uuid;
		
		//Optional parameters - initialized to default values
		////IPersonAttributes
		private String firstname;
		private String middelname = null;
		private String lastname = null;
		private String callname = null;
		private String nameForAdressing = null;
		private String gender = null;
		private XMLGregorianCalendar birthdate = null;
		private String birthplace = null;
		private String birthRegisteringAuthority = null;
		
		private IRegisterInformation registerInformation = null;
		
		private IAddress address = null;
		
		// Builder constructor
		public Builder(final int newCode, final String newMessage, final String newUuid) {
			code = newCode;
			message = newMessage;
			uuid = newUuid;
		}
		
		// build method
		public IPerson build() { return new Person(this); }
		
		// builder methods
		public Builder firstname(final String newName) { firstname = newName; return this; }
		public Builder middelname(final String newName) { middelname = newName; return this; }
		public Builder lastname(final String newName) { lastname = newName; return this; }
		public Builder callname(final String newName) { callname = newName; return this; }
		public Builder nameForAdressing(final String newName) { nameForAdressing = newName; return this; }
		public Builder gender(final String newGender) {gender = newGender; return this;}
		public Builder birthdate(final XMLGregorianCalendar newBirthdate) {birthdate = newBirthdate; return this;}
		public Builder birthplace(final String newBirthplace) {birthplace = newBirthplace; return this;}
		public Builder birthRegisteringAuthority(final String newBirthRegisteringAuthority) {birthRegisteringAuthority = newBirthRegisteringAuthority; return this;}
		public Builder registerInformation(final IRegisterInformation newRegInfo) { registerInformation = newRegInfo; return this; }
		public Builder address(final IAddress newAddress) {address = newAddress; return this;}
	}

	/**
	 * Immutable person
	 * @param builder
	 */
	private Person(Builder builder) {
		code = builder.code;
		message = builder.message;
		uuid = builder.uuid;
		
		firstname = builder.firstname;
		middelname = builder.middelname;
		lastname = builder.lastname;
		callname = builder.callname;
		nameForAdressing = builder.nameForAdressing;
		
		gender = builder.gender;
		birthdate = builder.birthdate;
		birthplace = builder.birthplace;
		birthRegisteringAuthority = builder.birthRegisteringAuthority;
		
		registerInformation = builder.registerInformation;

		address = builder.address;
	}
	
	
	// Person attribute accessors
	
	@Override
	public String message() { return message; }

	@Override
	public int code() { return code; }

	@Override
	public String uuid() { return uuid;	}

	@Override
	public String firstname() {	return firstname;}

	@Override
	public String middelname() { return middelname;	}

	@Override
	public String lastname() { return lastname;	}

	@Override
	public String callname() { return callname;	}
	
	@Override
	public String nameForAdressing() { return nameForAdressing; }
	
	@Override
	public String gender() { return gender;	}

	@Override
	public XMLGregorianCalendar birthdate() { return birthdate;	}

	@Override
	public String birthplace() { return birthplace;	}
	
	@Override
	public String birthRegisteringAuthority() { return birthRegisteringAuthority; }

	@Override
	public IRegisterInformation registerInformation() {	return registerInformation; }

	@Override
	public IAddress address() {	return address;}



}
