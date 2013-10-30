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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.EAddressType;
import util.cprbroker.IDanishAddress;

public class DanishAddressTest {

	private IDanishAddress testDanishAddress;
	
	@Before
	public void setUp() {
		DanishAddress.Builder builder = new DanishAddress.Builder();
		
		builder.countryIdentificationCode("newCountryIdentificationCode");
		builder.danishNote("newDanishNote");
		builder.districtName("newDistrictName");
		builder.districtSubdivision("newDistrictSubdivision");
		builder.floor("newFloor");
		builder.isSpecielVejkode(Boolean.TRUE);
		builder.isUkendtAdresse(Boolean.FALSE);
		builder.mailSubLocaltion("newMailSublocation");
		builder.municipalityCode("newMunicipalityCode");
		builder.note("newNote");
		builder.politiDistrikt("newPolitiDistrikt");
		builder.postCode("newPostCode");
		builder.postDistrikt("newPostDistrikt");
		builder.postOfficeBox("newPostOfficeBox");
		builder.skoleDistrikt("newSkoleDistrikt");
		builder.socialDistrikt("newSocialDistrikt");
		builder.sogneDistrikt("newSogneDistrikt");
		builder.streetBuilding("newStreetBuilding");
		builder.streetBuildingIdentifier("newIdentifier");
		builder.streetCode("newCode");
		builder.streetName("newStreetName");
		builder.streetNameForAdressing("newStreetNameForAddressing");
		builder.suite("newSuite");
		builder.valgkredsDistrikt("newValgkredsDistrikt");

		
		testDanishAddress = builder.build();
	}
	
	
	@Test
	public void testAddressType() {
		assertEquals(EAddressType.Danish, testDanishAddress.addressType());
	}
	
	@Test
	public void testDanishAddress() {
		assertEquals(testDanishAddress, testDanishAddress.danishAddress());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testGreenlandicAddress() {
		testDanishAddress.greenlandicAddress();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testWorldAddress() {
		testDanishAddress.worldAddress();
	}
	
	@Test
	public void testCountryIdentificationCode() {
		assertEquals("newCountryIdentificationCode", testDanishAddress.countryIdentificationCode());
	}
		
	@Test
	public void testDanishNote() {
		assertEquals("newDanishNote", testDanishAddress.danishNote());
	}

	@Test
	public void testDistrictName() {
		assertEquals("newDistrictName", testDanishAddress.districtName());
	}

	@Test
	public void testDistrictSubdivision() {
		assertEquals("newDistrictSubdivision", testDanishAddress.districtSubdivision());
	}

	@Test
	public void testFloor() {
		assertEquals("newFloor", testDanishAddress.floor());
	}

	@Test
	public void testIsSpecialVejkode() {
		assertEquals(Boolean.TRUE, testDanishAddress.isSpecielVejkode());
	}
	
	@Test
	public void testIsUkendtAdresse() {
		assertEquals(Boolean.FALSE, testDanishAddress.isUkendtAdresse());
	}
	
	@Test
	public void testMailSubLocation() {
		assertEquals("newMailSublocation", testDanishAddress.mailSublocation());
	}
	
	@Test
	public void testMunicipalityCode() {
		assertEquals("newMunicipalityCode", testDanishAddress.municipalityCode());
	}
	
	@Test
	public void testNote() {
		assertEquals("newNote", testDanishAddress.note());
	}
	
	@Test
	public void testPolitiDistrikt() {
		assertEquals("newPolitiDistrikt", testDanishAddress.politiDistrikt());
	}
	
	@Test
	public void testPostCode() {
		assertEquals("newPostCode", testDanishAddress.postCode());
	}
	
	@Test
	public void testPostDistrikt() {
		assertEquals("newPostDistrikt", testDanishAddress.postDistrikt());
	}
	
	@Test
	public void testPostOfficeBox() {
		assertEquals("newPostOfficeBox", testDanishAddress.postOfficeBox());
	}
	
	@Test
	public void testSkoleDistrikt() {
		assertEquals("newSkoleDistrikt", testDanishAddress.skoleDistrikt());
	}
	
	@Test
	public void testSocialDistrikt() {
		assertEquals("newSocialDistrikt", testDanishAddress.socialDistrikt());
	}
	
	@Test
	public void testSogneDistrikt() {
		assertEquals("newSogneDistrikt", testDanishAddress.sogneDistrikt());
	}
	
	@Test
	public void testStreetBuilding() {
		assertEquals("newStreetBuilding", testDanishAddress.streetBuilding());
	}
	
	@Test
	public void testStreetBuildingIdentifier() {
		assertEquals("newIdentifier", testDanishAddress.streetBuildingIdentifier());
	}
	
	@Test
	public void testStreetCode() {
		assertEquals("newCode", testDanishAddress.streetCode());
	}
	
	@Test
	public void testStreetName() {
		assertEquals("newStreetName", testDanishAddress.streetName());
	}
	
	@Test
	public void testStreetNameForAddressing() {
		assertEquals("newStreetNameForAddressing", testDanishAddress.streetNameForAddressing());
	}
	
	@Test
	public void testSuite() {
		assertEquals("newSuite", testDanishAddress.suite());
	}
	
	@Test
	public void testValgkredsDistrikt() {
		assertEquals("newValgkredsDistrikt", testDanishAddress.valgkredsDistrikt());
	}

}

