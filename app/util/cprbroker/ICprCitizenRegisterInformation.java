package util.cprbroker;

public interface ICprCitizenRegisterInformation extends IRegisterInformation{
/*
 * Make it from this
	citizenData.getAdresseNoteTekst();
	citizenData.getFolkeregisterAdresse();
	citizenData.getPersonCivilRegistrationIdentifier();
	citizenData.getPersonNationalityCode();
*/

	String personNationalityCode();
	String socialSecurityNumber();
	boolean isMemberOfTheChurch();
	boolean isResearcherProtected();
	boolean isSocialSecurityNumberValid();
	boolean isNameAddressProtected();
	boolean isPhoneNumberProtected();
}
