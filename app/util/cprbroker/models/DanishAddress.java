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

public class DanishAddress implements IDanishAddress {

	private final String municipalityCode;
	private final String streetBuildingIdentifier;
	private final String streetCode;
	
	private final String countryIdentificationCode;
	private final String districtName;
	private final String districtSubdivision;
	private final String floor;
	private final String mailSubLocaltion;
	private final String postCode;
	private final String postOfficeBox;
	private final String streetBuilding;
	private final String streetName;
	private final String streetNameForAdressing;
	private final String suite;
	private final String note;

	private final String danishNote;
	private final String politiDistrikt;
	private final String postDistrikt;
	private final String skoleDistrikt;
	private final String socialDistrikt;
	private final String sogneDistrikt;
	private final String valgkredsDistrikt;
	private final Boolean isSpecielVejkode;
	private final Boolean isUkendtAdresse;

	
	public static class Builder implements IBuilder<IDanishAddress> {

		private String countryIdentificationCode;
		private String districtName;
		private String districtSubdivision;
		private String floor;
		private String mailSubLocaltion;
		private String postCode;
		private String postOfficeBox;
		private String streetBuilding;
		private String streetName;
		private String streetNameForAdressing;
		private String suite;
		private String note;

		private String municipalityCode;
		private String streetBuildingIdentifier;
		private String streetCode;

		private String danishNote;
		private String politiDistrikt;
		private String postDistrikt;
		private String skoleDistrikt;
		private String socialDistrikt;
		private String sogneDistrikt;
		private String valgkredsDistrikt;
		private Boolean isSpecielVejkode;
		private Boolean isUkendtAdresse;
		
		// build method
		public IDanishAddress build() { return new DanishAddress(this); }
		
		// builder methods
		public Builder countryIdentificationCode(String newCountryIdentificationCode) { countryIdentificationCode = newCountryIdentificationCode; return this;}
		public Builder districtName(String newDistrictName) { districtName = newDistrictName; return this;}
		public Builder districtSubdivision(String newDistrictSubdivision) { districtSubdivision = newDistrictSubdivision; return this;}
		public Builder floor(String newFloor) { floor = newFloor; return this;}
		public Builder mailSubLocaltion(String newMailSubLocaltion) { mailSubLocaltion = newMailSubLocaltion; return this;}
		public Builder postCode(String newPostCode) { postCode = newPostCode; return this;}
		public Builder postOfficeBox(String newPostOfficeBox) { postOfficeBox = newPostOfficeBox; return this;}
		public Builder streetBuilding(String newStreetBuilding) { streetBuilding = newStreetBuilding; return this;}
		public Builder streetName(String newStreetName) { streetName = newStreetName; return this;}
		public Builder streetNameForAdressing(String newStreetNameForAdressing) { streetNameForAdressing = newStreetNameForAdressing; return this;}
		public Builder suite(String newSuite) { suite = newSuite; return this;}
		public Builder note(String newNote) { note = newNote; return this;}
		
		public Builder municipalityCode(String newCode) { municipalityCode = newCode; return this;}
		public Builder streetBuildingIdentifier(String newIdentifier) { streetBuildingIdentifier = newIdentifier; return this;}
		public Builder streetCode(String newCode) { streetCode = newCode; return this;}
		
		public Builder danishNote(String newNote) { danishNote = newNote; return this;}
		public Builder politiDistrikt(String newDistrikt) { politiDistrikt = newDistrikt; return this;}
		public Builder postDistrikt(String newDistrikt) { postDistrikt = newDistrikt; return this;}
		public Builder skoleDistrikt(String newDistrikt) { skoleDistrikt = newDistrikt; return this;}
		public Builder socialDistrikt(String newDistrikt) { socialDistrikt = newDistrikt; return this;}
		public Builder sogneDistrikt(String newDistrikt) { sogneDistrikt = newDistrikt; return this;}
		public Builder valgkredsDistrikt(String newDistrikt) { valgkredsDistrikt = newDistrikt; return this;}
		public Builder isSpecielVejkode(Boolean isSpecial) { isSpecielVejkode = isSpecial; return this;}
		public Builder isUkendtAdresse(Boolean isUkendt) { isUkendtAdresse = isUkendt; return this;}
		
	}
	
	private DanishAddress(Builder builder) {
		countryIdentificationCode = builder.countryIdentificationCode;
		districtName = builder.districtName;
		districtSubdivision = builder.districtSubdivision;
		floor = StringUtils.TrimZerosOnLeft(builder.floor);
		mailSubLocaltion = builder.mailSubLocaltion;
		postCode = builder.postCode;
		postOfficeBox = builder.postOfficeBox;
		streetBuilding = StringUtils.TrimZerosOnLeft(builder.streetBuilding);
		streetName = builder.streetName;
		streetNameForAdressing = builder.streetNameForAdressing;
		suite = StringUtils.TrimZerosOnLeft(builder.suite);
		note = builder.note;

		municipalityCode = StringUtils.TrimZerosOnLeft(builder.municipalityCode);
		streetBuildingIdentifier = StringUtils.TrimZerosOnLeft(builder.streetBuildingIdentifier);
		streetCode = StringUtils.TrimZerosOnLeft(builder.streetCode);

		danishNote = builder.danishNote;
		politiDistrikt = builder.politiDistrikt;
		postDistrikt = builder.postDistrikt;
		skoleDistrikt = builder.skoleDistrikt;
		socialDistrikt = builder.socialDistrikt;
		sogneDistrikt = builder.sogneDistrikt;
		valgkredsDistrikt = builder.valgkredsDistrikt;
		isSpecielVejkode = builder.isSpecielVejkode;
		isUkendtAdresse = builder.isUkendtAdresse;

	}
	
	// no-brainers - this is a danish address
	@Override
	public EAddressType addressType() {	return EAddressType.Danish; }
	@Override public IDanishAddress danishAddress() { return this; }
	@Override public IGreenlandicAddress greenlandicAddress() { throw new UnsupportedOperationException(); }
	@Override public IWorldAddress worldAddress() { throw new UnsupportedOperationException(); }

	@Override
	public String countryIdentificationCode() {	return countryIdentificationCode; }

	@Override
	public String districtName() { return districtName;	}

	@Override
	public String districtSubdivision() { return districtSubdivision;}

	@Override
	public String floor() {	return floor;}

	@Override
	public String mailSublocation() { return mailSubLocaltion;	}

	@Override
	public String postCode() { return postCode;	}

	@Override
	public String postOfficeBox() {	return postOfficeBox; }

	@Override
	public String streetBuilding() { return streetBuilding; }

	@Override
	public String streetName() { return streetName;}

	@Override
	public String streetNameForAddressing() { return streetNameForAdressing; }

	@Override
	public String suite() {	return suite;}

	@Override
	public String note() { return note; }

	@Override
	public String municipalityCode() { return municipalityCode; }

	@Override
	public String streetBuildingIdentifier() { return streetBuildingIdentifier;	}

	@Override
	public String streetCode() { return streetCode; }

	@Override
	public String danishNote() { return danishNote; }

	@Override
	public String politiDistrikt() { return politiDistrikt; }

	@Override
	public String postDistrikt() { return postDistrikt;	}

	@Override
	public String skoleDistrikt() {	return skoleDistrikt; }

	@Override
	public String socialDistrikt() { return socialDistrikt; }

	@Override
	public String sogneDistrikt() { return sogneDistrikt; }

	@Override
	public String valgkredsDistrikt() { return valgkredsDistrikt; }

	@Override
	public Boolean isSpecielVejkode() {	return isSpecielVejkode; }

	@Override
	public Boolean isUkendtAdresse() { return isUkendtAdresse;	}

}
