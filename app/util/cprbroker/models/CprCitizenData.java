package util.cprbroker.models;

import util.cprbroker.ICprCitizenRegisterInformation;

public class CprCitizenData implements ICprCitizenRegisterInformation {

	private final boolean isMemberOfTheChurch;
	private final boolean isResearcherProtected;
	private final boolean isSocialSecurityNumberValid;
	private final boolean isNameAdressProtected;
	private final boolean isPhoneNumberProtected;
	private final String personNationalityCode;
	private final String socialSecurityNumber;
	
	public static class Builder {

		//Optional parameters - initialized to default values
		private boolean isMemberOfTheChurch = true;
		private boolean isResearcherProtected = false;
		private boolean isSocialSecurityNumberValid = true;
		private boolean isNameAdressProtected = false;
		private boolean isPhoneNumberProtected = false;
		
		private String personNationalityCode;
		private String socialSecurityNumber;
		
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

	}
	
	private CprCitizenData(Builder builder) {
		isMemberOfTheChurch = builder.isMemberOfTheChurch;
		isResearcherProtected = builder.isResearcherProtected;
		isSocialSecurityNumberValid = builder.isSocialSecurityNumberValid;
		isNameAdressProtected = builder.isNameAdressProtected;
		isPhoneNumberProtected = builder.isPhoneNumberProtected;
		personNationalityCode = builder.personNationalityCode;
		socialSecurityNumber = builder.socialSecurityNumber;
	}
	
	@Override
	public boolean isMemberOfTheChurch() { return isMemberOfTheChurch; }

	@Override
	public boolean isResearcherProtected() { return isResearcherProtected; }

	@Override
	public boolean isSocialSecurityNumberValid() { return isSocialSecurityNumberValid; }

	@Override
	public boolean isNameAddressProtected() { return isNameAdressProtected; }

	@Override
	public boolean isPhoneNumberProtected() { return isPhoneNumberProtected;	}

	@Override
	public String personNationalityCode() {	return personNationalityCode; }

	@Override
	public String socialSecurityNumber() { return socialSecurityNumber;	}

	@Override
	public ICprCitizenRegisterInformation cprCitizen() {
		return this;
	}

}
