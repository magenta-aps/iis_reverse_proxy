package util.cprbroker.models;

import javax.xml.datatype.XMLGregorianCalendar;

import util.cprbroker.IAddress;
import util.cprbroker.IContact;
import util.cprbroker.IPersonRelationshipsWithIPerson;
import util.cprbroker.ITidspunkt;
import util.cprbroker.IVirkning;
import util.cprbroker.IPerson;
import util.cprbroker.IPersonRelationships;
import util.cprbroker.IRegisterInformation;
import util.cprbroker.ITilstand;

public class Person implements IPerson{

	// basic attributes
	private final int code;
	private final String message;
	private final String uuid;

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
	
	// contact
	private final IContact contact;
	private final IContact nextOfKinContact;
	
	// effect
	private final IVirkning effect;
	
	// relationships
	private final IPersonRelationships relations;
	private final IPersonRelationshipsWithIPerson relationsWithPerson;
	
	// tilstand
	private final ITilstand tilstand;
	
	private final ITidspunkt tidspunkt;
	
	/**
	 * Builder for a Person
	 * @author Søren Kirkegård
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
		
		private IContact contact = null;
		private IContact nextOfKinContact = null;
	
		private IVirkning effect = null;
		
		private IPersonRelationships relations = null;
		private IPersonRelationshipsWithIPerson relationsWithPerson = null;
		
		private ITilstand tilstand = null;
		
		private ITidspunkt tidspunkt = null;
		
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
		public Builder contact(final IContact newContact) {contact = newContact; return this;}
		public Builder nextOfKinContact(final IContact newContact) {nextOfKinContact = newContact; return this;}
		public Builder effect(final IVirkning newEffect) {effect = newEffect; return this; }
		public Builder relations(final IPersonRelationships newRelations) {relations = newRelations; return this; }
		public Builder tilstand(final ITilstand newTilstand) {tilstand = newTilstand; return this; }
		public Builder tidspunkt(final ITidspunkt newTidspunkt) {tidspunkt = newTidspunkt; return this; }
		public Builder relationsWithPerson(final IPersonRelationshipsWithIPerson newRelationsWithPerson) { relationsWithPerson = newRelationsWithPerson; return this;}
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
		
		contact = builder.contact;
		nextOfKinContact = builder.nextOfKinContact;
		effect = builder.effect;
		relations = builder.relations;
		tilstand = builder.tilstand;
		tidspunkt = builder.tidspunkt;
		relationsWithPerson = builder.relationsWithPerson;
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
	
	@Override
	public IContact contact() { return contact; }

	@Override
	public IContact nextOfKinContact() { return nextOfKinContact; }

	@Override
	public IVirkning effect() { return effect; }

	@Override
	public IPersonRelationships relations() { return relations; }


	@Override
	public ITilstand tilstand() { return tilstand; }

	@Override
	public ITidspunkt tidspunkt() {	return tidspunkt; }

	@Override
	public IPersonRelationshipsWithIPerson relationsWithPerson() { return relationsWithPerson;	}



}
