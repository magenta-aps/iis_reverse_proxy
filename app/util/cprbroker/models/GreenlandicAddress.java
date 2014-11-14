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

import util.StringUtils;
import util.cprbroker.*;

public class GreenlandicAddress implements IGreenlandicAddress {

	private final String countryIdentificationCode;
	private final String districtName;
	private final String districtSubdivisionIdentifier;
	private final String floorIdentifier;
	private final String greenlandBuildingIdentifier;
	private final String mailDeliverySublocationIdentifier;
	private final String municipalityCode;
	private final String postCodeIdentifier;
	private final String streetBuildingIdentifier;
	private final String streetCode;
	private final String streetName;
	private final String streetNameForAddressingName;
	private final String suiteIdentifier;
	private final Boolean isSpecielVejkodeIndikator;
	private final Boolean isUkendtAdresseIndikator;
	private final String note;


	public static class Builder implements IBuilder<IGreenlandicAddress> {
		
		private String countryIdentificationCode;
		private String districtName;
		private String districtSubdivisionIdentifier;
		private String floorIdentifier;
		private String greenlandBuildingIdentifier;
		private String mailDeliverySublocationIdentifier;
		private String municipalityCode;
		private String postCodeIdentifier;
		private String streetBuildingIdentifier;
		private String streetCode;
		private String streetName;
		private String streetNameForAddressingName;
		private String suiteIdentifier;
		private Boolean isSpecielVejkodeIndikator;
		private Boolean isUkendtAdresseIndikator;
		private String note;
		
		public IGreenlandicAddress build() { return new GreenlandicAddress(this); }
		
		public Builder countryIdentificationCode(String newCode) { countryIdentificationCode = newCode; return this; }
		public Builder districtName(String newName) { districtName = newName; return this; }
		public Builder districtSubdivision(String newIdentifier) { districtSubdivisionIdentifier = newIdentifier; return this; }
		public Builder floor(String newIdentifier) { floorIdentifier = newIdentifier; return this; }
		public Builder greenlandBuilding(String newIdentifier) { greenlandBuildingIdentifier = newIdentifier; return this; }
		public Builder mailDeliverySublocation(String newIdentifier) { mailDeliverySublocationIdentifier = newIdentifier; return this; }
		public Builder municipalityCode(String newCode) { municipalityCode = newCode; return this; }
		public Builder postCode(String newIdentifier) { postCodeIdentifier = newIdentifier; return this; }
		public Builder streetBuilding(String newIdentifier) { streetBuildingIdentifier = newIdentifier; return this; }
		public Builder streetCode(String newCode) { streetCode = newCode; return this; }
		public Builder streetName(String newName) { streetName = newName; return this; }
		public Builder streetNameForAddressing(String newName) { streetNameForAddressingName = newName; return this; }
		public Builder suite(String newIdentifier) { suiteIdentifier = newIdentifier; return this; }
		public Builder isSpecielVejkode(Boolean isSpecial) { isSpecielVejkodeIndikator = isSpecial; return this; }
		public Builder isUkendtAdresse(Boolean isUkendt) { isUkendtAdresseIndikator = isUkendt; return this; }
		public Builder note(String newNote) { note = newNote; return this; }
		
	}
	
	private GreenlandicAddress(Builder builder) {
		
		countryIdentificationCode = builder.countryIdentificationCode;
		districtName = builder.districtName;
		districtSubdivisionIdentifier = builder.districtSubdivisionIdentifier;
		floorIdentifier = StringUtils.TrimZerosOnLeft(builder.floorIdentifier);
		greenlandBuildingIdentifier = StringUtils.TrimZerosOnLeft(builder.greenlandBuildingIdentifier);
		mailDeliverySublocationIdentifier = builder.mailDeliverySublocationIdentifier;
		municipalityCode = StringUtils.TrimZerosOnLeft(builder.municipalityCode);
		postCodeIdentifier = builder.postCodeIdentifier;
		streetBuildingIdentifier = StringUtils.TrimZerosOnLeft(builder.streetBuildingIdentifier);
		streetCode = StringUtils.TrimZerosOnLeft(builder.streetCode);
		streetName = builder.streetName;
		streetNameForAddressingName = builder.streetNameForAddressingName;
		suiteIdentifier = StringUtils.TrimZerosOnLeft(builder.suiteIdentifier);
		isSpecielVejkodeIndikator = builder.isSpecielVejkodeIndikator;
		isUkendtAdresseIndikator = builder.isUkendtAdresseIndikator;
		note = builder.note;
	}
	
	@Override
	public EAddressType addressType() {	return EAddressType.Greenlandic;}

	@Override
	public IDanishAddress danishAddress() { throw new UnsupportedOperationException(); }

	@Override
	public IGreenlandicAddress greenlandicAddress() { return this; }

	@Override
	public IWorldAddress worldAddress() { throw new UnsupportedOperationException(); }

	@Override
	public String note() { return note;	}

	@Override
	public String countryIdentificationCode() { return countryIdentificationCode; }

	@Override
	public String districtName() { return districtName;	}

	@Override
	public String districtSubdivision() {	return districtSubdivisionIdentifier; }

	@Override
	public String floor() { return floorIdentifier; }

	@Override
	public String greenlandBuilding() { return greenlandBuildingIdentifier; }

	@Override
	public String mailDeliverySublocation() {	return mailDeliverySublocationIdentifier; }

	@Override
	public String municipalityCode() { return municipalityCode; }

	@Override
	public String postCode() { return postCodeIdentifier; }

	@Override
	public String streetBuilding() { return streetBuildingIdentifier; }

	@Override
	public String streetCode() { return streetCode; }

	@Override
	public String streetName() { return streetName; }

	@Override
	public String streetNameForAddressing() { return streetNameForAddressingName; }

	@Override
	public String suite() { return suiteIdentifier; }

	@Override
	public Boolean isSpecielVejkode() { return isSpecielVejkodeIndikator; }

	@Override
	public Boolean isUkendtAdresse() { return isUkendtAdresseIndikator; }

}
