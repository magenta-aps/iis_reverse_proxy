package util.cprbroker.models;

import util.cprbroker.IDanishAddress;
import util.cprbroker.IGreenlandicAddress;
import util.cprbroker.IWorldAddress;

public class DanishAddress implements IDanishAddress {

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
	
	public static class Builder {

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
	}
	
	// no-brainers - this is a danish address
	@Override public boolean isDanishAddress() { return true; }
	@Override public boolean isGreenlandicAddress() {	return false; }
	@Override public boolean isWorldAdress() { return false; }
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

}
