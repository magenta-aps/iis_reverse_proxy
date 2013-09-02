package util.cprbroker.models;

import util.cprbroker.ICprCitizenRegisterInformation;
import util.cprbroker.IVirkning;

public class CprCitizenData implements ICprCitizenRegisterInformation {

	private final Boolean isMemberOfTheChurch;
	private final Boolean isResearcherProtected;
	private final Boolean isSocialSecurityNumberValid;
	private final Boolean isNameAdressProtected;
	private final Boolean isPhoneNumberProtected;
	private final String personNationalityCode;
	private final String socialSecurityNumber;
	private final IVirkning virkning;
	
	public static class Builder {

		//Optional parameters - initialized to default values
		private Boolean isMemberOfTheChurch = null;
		private Boolean isResearcherProtected = null;
		private Boolean isSocialSecurityNumberValid = null;
		private Boolean isNameAdressProtected = null;
		private Boolean isPhoneNumberProtected = null;
		
		private String personNationalityCode;
		private String socialSecurityNumber;
		private IVirkning virkning;
		
		// build method
		public ICprCitizenRegisterInformation build() { return new CprCitizenData(this); }
		
		// builder methods
		public Builder isMemberOfTheChurch(final boolean newBoolean) { isMemberOfTheChurch = newBoolean; return this; }
		public Builder isResearcherProtected(final boolean newBoolean) { isResearcherProtected = newBoolean; return this; }
		public Builder isSocialSecurityNumberValid(final boolean newBoolean) { isSocialSecurityNumberValid = newBoolean; return this; }
		public Builder isNameAdressProtected(final boolean newBoolean) { isNameAdressProtected = newBoolean; return this; }
		public Builder isPhoneNumberProtected(final boolean newBoolean) { isPhoneNumberProtected = newBoolean; return this; }
		public Builder personNationalityCode(final String newNationalityCode) { personNationalityCode = newNationalityCode; return this; }
		public Builder socialSecurityNumber(final String newSocialSecurity) { socialSecurityNumber = newSocialSecurity; return this; }
		public Builder virkning(final IVirkning newVirkning) { virkning = newVirkning; return this; }

	}
	
	private CprCitizenData(Builder builder) {
		isMemberOfTheChurch = builder.isMemberOfTheChurch;
		isResearcherProtected = builder.isResearcherProtected;
		isSocialSecurityNumberValid = builder.isSocialSecurityNumberValid;
		isNameAdressProtected = builder.isNameAdressProtected;
		isPhoneNumberProtected = builder.isPhoneNumberProtected;
		personNationalityCode = builder.personNationalityCode;
		socialSecurityNumber = builder.socialSecurityNumber;
		virkning = builder.virkning;
	}
	
	@Override
	public Boolean isMemberOfTheChurch() { return isMemberOfTheChurch; }

	@Override
	public Boolean isResearcherProtected() { return isResearcherProtected; }

	@Override
	public Boolean isSocialSecurityNumberValid() { return isSocialSecurityNumberValid; }

	@Override
	public Boolean isNameAddressProtected() { return isNameAdressProtected; }

	@Override
	public Boolean isPhoneNumberProtected() { return isPhoneNumberProtected;	}

	@Override
	public String personNationalityCode() {	return personNationalityCode; }

	@Override
	public String socialSecurityNumber() { return socialSecurityNumber;	}

	@Override
	public ICprCitizenRegisterInformation cprCitizen() {
		return this;
	}

	@Override
	public IVirkning virkning() { return virkning; }

}
