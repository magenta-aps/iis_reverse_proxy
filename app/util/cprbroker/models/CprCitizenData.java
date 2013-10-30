/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

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
		//TODO This is a 4 digit number not a string..
		public Builder personNationalityCode(final String newNationalityCode) { personNationalityCode = newNationalityCode; return this; }
		//TODO This is a 10 digitnumber, where the 6 first digits are a valid date - not a string!
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
