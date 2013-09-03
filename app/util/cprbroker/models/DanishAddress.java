package util.cprbroker.models;

import util.cprbroker.EAddressType;
import util.cprbroker.IBuilder;
import util.cprbroker.IDanishAddress;
import util.cprbroker.IGreenlandicAddress;
import util.cprbroker.IWorldAddress;

public class DanishAddress implements IDanishAddress {

	private final String municipalityCode;
	private final String streetBuildingIdentifier;
	private final String streetCode;
	
	private final String countryIdentificationCode;
	private final String districtName;
	private final String districtSubdivision;
	private final String floor;
	private final String mailSubLocaltion;
	private final String postCode;
	private final String postOfficeBox;
	private final String streetBuilding;
	private final String streetName;
	private final String streetNameForAdressing;
	private final String suite;
	private final String note;

	private final String danishNote;
	private final String politiDistrikt;
	private final String postDistrikt;
	private final String skoleDistrikt;
	private final String socialDistrikt;
	private final String sogneDistrikt;
	private final String valgkredsDistrikt;
	private final Boolean isSpecielVejkode;
	private final Boolean isUkendtAdresse;

	
	public static class Builder implements IBuilder<IDanishAddress> {

		private String countryIdentificationCode;
		private String districtName;
		private String districtSubdivision;
		private String floor;
		private String mailSubLocaltion;
		private String postCode;
		private String postOfficeBox;
		private String streetBuilding;
		private String streetName;
		private String streetNameForAdressing;
		private String suite;
		private String note;

		private String municipalityCode;
		private String streetBuildingIdentifier;
		private String streetCode;

		private String danishNote;
		private String politiDistrikt;
		private String postDistrikt;
		private String skoleDistrikt;
		private String socialDistrikt;
		private String sogneDistrikt;
		private String valgkredsDistrikt;
		private Boolean isSpecielVejkode;
		private Boolean isUkendtAdresse;
		
		// build method
		public IDanishAddress build() { return new DanishAddress(this); }
		
		// builder methods
		public Builder countryIdentificationCode(String newCountryIdentificationCode) { countryIdentificationCode = newCountryIdentificationCode; return this;}
		public Builder districtName(String newDistrictName) { districtName = newDistrictName; return this;}
		public Builder districtSubdivision(String newDistrictSubdivision) { districtSubdivision = newDistrictSubdivision; return this;}
		public Builder floor(String newFloor) { floor = newFloor; return this;}
		public Builder mailSubLocaltion(String newMailSubLocaltion) { mailSubLocaltion = newMailSubLocaltion; return this;}
		public Builder postCode(String newPostCode) { postCode = newPostCode; return this;}
		public Builder postOfficeBox(String newPostOfficeBox) { postOfficeBox = newPostOfficeBox; return this;}
		public Builder streetBuilding(String newStreetBuilding) { streetBuilding = newStreetBuilding; return this;}
		public Builder streetName(String newStreetName) { streetName = newStreetName; return this;}
		public Builder streetNameForAdressing(String newStreetNameForAdressing) { streetNameForAdressing = newStreetNameForAdressing; return this;}
		public Builder suite(String newSuite) { suite = newSuite; return this;}
		public Builder note(String newNote) { note = newNote; return this;}
		
		public Builder municipalityCode(String newCode) { municipalityCode = newCode; return this;}
		public Builder streetBuildingIdentifier(String newIdentifier) { streetBuildingIdentifier = newIdentifier; return this;}
		public Builder streetCode(String newCode) { streetCode = newCode; return this;}
		
		public Builder danishNote(String newNote) { danishNote = newNote; return this;}
		public Builder politiDistrikt(String newDistrikt) { politiDistrikt = newDistrikt; return this;}
		public Builder postDistrikt(String newDistrikt) { postDistrikt = newDistrikt; return this;}
		public Builder skoleDistrikt(String newDistrikt) { skoleDistrikt = newDistrikt; return this;}
		public Builder socialDistrikt(String newDistrikt) { socialDistrikt = newDistrikt; return this;}
		public Builder sogneDistrikt(String newDistrikt) { sogneDistrikt = newDistrikt; return this;}
		public Builder valgkredsDistrikt(String newDistrikt) { valgkredsDistrikt = newDistrikt; return this;}
		public Builder isSpecielVejkode(Boolean isSpecial) { isSpecielVejkode = isSpecial; return this;}
		public Builder isUkendtAdresse(Boolean isUkendt) { isUkendtAdresse = isUkendt; return this;}
		
	}
	
	private DanishAddress(Builder builder) {
		countryIdentificationCode = builder.countryIdentificationCode;
		districtName = builder.districtName;
		districtSubdivision = builder.districtSubdivision;
		floor = builder.floor;
		mailSubLocaltion = builder.mailSubLocaltion;
		postCode = builder.postCode;
		postOfficeBox = builder.postOfficeBox;
		streetBuilding = builder.streetBuilding;
		streetName = builder.streetName;
		streetNameForAdressing = builder.streetNameForAdressing;
		suite = builder.suite;
		note = builder.note;
		
		municipalityCode = builder.municipalityCode;
		streetBuildingIdentifier = builder.streetBuildingIdentifier;
		streetCode = builder.streetCode;

		danishNote = builder.danishNote;
		politiDistrikt = builder.politiDistrikt;
		postDistrikt = builder.postDistrikt;
		skoleDistrikt = builder.skoleDistrikt;
		socialDistrikt = builder.socialDistrikt;
		sogneDistrikt = builder.sogneDistrikt;
		valgkredsDistrikt = builder.valgkredsDistrikt;
		isSpecielVejkode = builder.isSpecielVejkode;
		isUkendtAdresse = builder.isUkendtAdresse;

	}
	
	// no-brainers - this is a danish address
	@Override
	public EAddressType addressType() {	return EAddressType.Danish; }
	@Override public IDanishAddress danishAddress() { return this; }
	@Override public IGreenlandicAddress greenlandicAddress() { return null; }
	@Override public IWorldAddress worldAddress() { return null; }

	@Override
	public String countryIdentificationCode() {	return countryIdentificationCode; }

	@Override
	public String districtName() { return districtName;	}

	@Override
	public String districtSubdivision() { return districtSubdivision;}

	@Override
	public String floor() {	return floor;}

	@Override
	public String mailSubLocaltion() { return mailSubLocaltion;	}

	@Override
	public String postCode() { return postCode;	}

	@Override
	public String postOfficeBox() {	return postOfficeBox; }

	@Override
	public String streetBuilding() { return streetBuilding; }

	@Override
	public String streetName() { return streetName;}

	@Override
	public String streetNameForAddressing() { return streetNameForAdressing; }

	@Override
	public String suite() {	return suite;}

	@Override
	public String note() { return note; }

	@Override
	public String municipalityCode() { return municipalityCode; }

	@Override
	public String streetBuildingIdentifier() { return streetBuildingIdentifier;	}

	@Override
	public String streetCode() { return streetCode; }

	@Override
	public String danishNote() { return danishNote; }

	@Override
	public String politiDistrikt() { return politiDistrikt; }

	@Override
	public String postDistrikt() { return postDistrikt;	}

	@Override
	public String skoleDistrikt() {	return skoleDistrikt; }

	@Override
	public String socialDistrikt() { return socialDistrikt; }

	@Override
	public String sogneDistrikt() { return sogneDistrikt; }

	@Override
	public String valgkredsDistrikt() { return valgkredsDistrikt; }

	@Override
	public Boolean isSpecielVejkode() {	return isSpecielVejkode; }

	@Override
	public Boolean isUkendtAdresse() { return isUkendtAdresse;	}

}
