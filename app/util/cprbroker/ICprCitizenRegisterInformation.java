package util.cprbroker;

public interface ICprCitizenRegisterInformation extends IRegisterInformation{

	String personNationalityCode();
	String socialSecurityNumber();
	Boolean isMemberOfTheChurch();
	Boolean isResearcherProtected();
	Boolean isSocialSecurityNumberValid();
	Boolean isNameAddressProtected();
	Boolean isPhoneNumberProtected();

}
