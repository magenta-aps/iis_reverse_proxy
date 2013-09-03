package util.cprbroker;

public interface IGreenlandicAddress extends IAddress {

	/*
		greenlandicAddress.getAddressCompleteGreenland().getCountryIdentificationCode().getValue();
		greenlandicAddress.getAddressCompleteGreenland().getDistrictName();
		greenlandicAddress.getAddressCompleteGreenland().getDistrictSubdivisionIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getFloorIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getGreenlandBuildingIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getMailDeliverySublocationIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getMunicipalityCode();
		greenlandicAddress.getAddressCompleteGreenland().getPostCodeIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getStreetBuildingIdentifier();
		greenlandicAddress.getAddressCompleteGreenland().getStreetCode();
		greenlandicAddress.getAddressCompleteGreenland().getStreetName();
		greenlandicAddress.getAddressCompleteGreenland().getStreetNameForAddressingName();
		greenlandicAddress.getAddressCompleteGreenland().getSuiteIdentifier();
		greenlandicAddress.isSpecielVejkodeIndikator();
		greenlandicAddress.isUkendtAdresseIndikator();
	 */

	String countryIdentificationCode();
	String districtName();
	String districtSubdivision();
	String floor();
	String greenlandBuilding();
	String mailDeliverySublocation();
	String municipalityCode();
	String postCode();
	String streetBuilding();
	String streetCode();
	String streetName();
	String streetNameForAddressing();
	String suite();
	Boolean isSpecielVejkode();
	Boolean isUkendtAdresse();

}
