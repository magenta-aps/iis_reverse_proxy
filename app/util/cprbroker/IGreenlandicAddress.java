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
	String districtSubdivisionIdentifier();
	String floorIdentifier();
	String greenlandBuildingIdentifier();
	String mailDeliverySublocationIdentifier();
	String municipalityCode();
	String postCodeIdentifier();
	String streetBuildingIdentifier();
	String streetCode();
	String streetName();
	String streetNameForAddressingName();
	String suiteIdentifier();
	Boolean isSpecielVejkodeIndikator();
	Boolean isUkendtAdresseIndikator();

}
