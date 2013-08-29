package util.cprbroker;

public interface IDanishAddress extends IAddress {

	String countryIdentificationCode();
	String districtName();
	String districtSubdivision();
	String floor();
	String mailSubLocaltion();
	String postCode();
	String postOfficeBox();
	String streetBuilding();
	String streetName();
	String streetNameForAddressing();
	String suite();
	
}
