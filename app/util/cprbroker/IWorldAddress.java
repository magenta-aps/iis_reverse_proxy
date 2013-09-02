package util.cprbroker;

public interface IWorldAddress extends IAddress {
	
	String countryIdentificationCode();
	String locationDescriptionText();
	String postalAddressFirstLineText();
	String postalAddressSecondLineText();
	String postalAddressThirdLineText();
	String postalAddressFourthLineText();
	String postalAddressFifthLineText();
	Boolean isUkendtAdresseIndikator();

}
