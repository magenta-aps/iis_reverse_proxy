package util.cprbroker;

public interface IDanishAddress extends IAddress {

	
	/*
	danishAddress.getAddressComplete().getAddressAccess().getMunicipalityCode()
	danishAddress.getAddressComplete().getAddressAccess().getStreetBuildingIdentifier()
	danishAddress.getAddressComplete().getAddressAccess().getStreetCode()
	
	danishAddress.getAddressComplete().getAddressPostal().getCountryIdentificationCode()
	danishAddress.getAddressComplete().getAddressPostal().getDistrictName()
	danishAddress.getAddressComplete().getAddressPostal().getDistrictSubdivisionIdentifier()
	danishAddress.getAddressComplete().getAddressPostal().getFloorIdentifier()
	danishAddress.getAddressComplete().getAddressPostal().getMailDeliverySublocationIdentifier()
	danishAddress.getAddressComplete().getAddressPostal().getPostCodeIdentifier()
	danishAddress.getAddressComplete().getAddressPostal().getPostOfficeBoxIdentifier()
	danishAddress.getAddressComplete().getAddressPostal().getStreetBuildingIdentifier()	
	danishAddress.getAddressComplete().getAddressPostal().getStreetName()
	danishAddress.getAddressComplete().getAddressPostal().getStreetNameForAddressingName()
	danishAddress.getAddressComplete().getAddressPostal().getSuiteIdentifier()
	
	danishAddress.getNoteTekst()
	danishAddress.getPolitiDistriktTekst()
	danishAddress.getPostDistriktTekst()
	danishAddress.getSkoleDistriktTekst()
	danishAddress.getSocialDistriktTekst()
	danishAddress.getSogneDistriktTekst()
	danishAddress.getValgkredsDistriktTekst()
	danishAddress.isSpecielVejkodeIndikator()
	danishAddress.isUkendtAdresseIndikator()

	//TODO Implement these!
	danishAddress.getAddressPoint().getAddressPointIdentifier()
	danishAddress.getAddressPoint().getAddressPointStatusStructure().getAddressCoordinateQualityClassCode().name()
	danishAddress.getAddressPoint().getAddressPointStatusStructure().getAddressPointRevisionDateTime()
	danishAddress.getAddressPoint().getAddressPointStatusStructure().getAddressPointValidEndDateTime()
	danishAddress.getAddressPoint().getAddressPointStatusStructure().getAddressPointValidStartDateTime()
	danishAddress.getAddressPoint().getGeographicPointLocation().getCrsIdentifier()
	danishAddress.getAddressPoint().getGeographicPointLocation().getGeographicCoordinateTuple().getGeographicEastingMeasure()
	danishAddress.getAddressPoint().getGeographicPointLocation().getGeographicCoordinateTuple().getGeographicHeightMeasure()
	danishAddress.getAddressPoint().getGeographicPointLocation().getGeographicCoordinateTuple().getGeographicNorthingMeasure()

	 */

	String municipalityCode();
	String streetBuildingIdentifier();
	String streetCode();

	
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
	
	String danishNote();
	String politiDistrikt();
	String postDistrikt();
	String skoleDistrikt();
	String socialDistrikt();
	String sogneDistrikt();
	String valgkredsDistrikt();
	Boolean isSpecielVejkode();
	Boolean isUkendtAdresse();

	
}
