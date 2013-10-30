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
import util.cprbroker.IGreenlandicAddress;

public class GreenlandicAddressTest {
	
	private IGreenlandicAddress testGreenlandicAddress;

	@Before
	public void setUp() throws Exception {
		GreenlandicAddress.Builder builder = new GreenlandicAddress.Builder();
		
		builder.countryIdentificationCode("newCode");
		builder.districtName("newDistrictName");
		builder.districtSubdivision("newSubdivision");
		builder.floor("newFloor");
		builder.greenlandBuilding("newGreenlandBuilding");
		builder.isSpecielVejkode(Boolean.TRUE);
		builder.isUkendtAdresse(Boolean.FALSE);
		builder.mailDeliverySublocation("newMailDelivery");
		builder.municipalityCode("newMuncipality");
		builder.note("newNote");
		builder.postCode("newPostCode");
		builder.streetBuilding("newStreetBuilding");
		builder.streetCode("newStreetCode");
		builder.streetName("newStreetName");
		builder.streetNameForAddressing("newNameForAddy");
		builder.suite("newSuite");
		
		testGreenlandicAddress = builder.build();
	}

	@Test
	public void testAddressType() {
		assertEquals(EAddressType.Greenlandic, testGreenlandicAddress.addressType());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testDanishAddress() {
		testGreenlandicAddress.danishAddress();
	}
	
	@Test
	public void testGreenlandicAddress() {
		assertEquals(testGreenlandicAddress, testGreenlandicAddress.greenlandicAddress());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testWorldAddress() {
		testGreenlandicAddress.worldAddress();
	}
	
	@Test
	public void testCounttryIdentificationCode() {
		assertEquals("newCode", testGreenlandicAddress.countryIdentificationCode());
	}

	@Test
	public void testDistrictName() {
		assertEquals("newDistrictName", testGreenlandicAddress.districtName());
	}

	@Test
	public void testDistrictSubdivision() {
		assertEquals("newSubdivision", testGreenlandicAddress.districtSubdivision());
	}
	
	@Test
	public void testFloor() {
		assertEquals("newFloor", testGreenlandicAddress.floor());
	}

	@Test
	public void testGreenlandicBuilding() {
		assertEquals("newGreenlandBuilding", testGreenlandicAddress.greenlandBuilding());
	}

	@Test
	public void testIsSpecialVejkode() {
		assertEquals(Boolean.TRUE, testGreenlandicAddress.isSpecielVejkode());
	}
	
	@Test
	public void testisUkendtAdresse() {
		assertEquals(Boolean.FALSE, testGreenlandicAddress.isUkendtAdresse());
	}

	@Test
	public void testMailDeliverySublocation() {
		assertEquals("newMailDelivery", testGreenlandicAddress.mailDeliverySublocation());
	}

	@Test
	public void testMunicipalityCode() {
		assertEquals("newMuncipality", testGreenlandicAddress.municipalityCode());
	}

	@Test
	public void testNote() {
		assertEquals("newNote", testGreenlandicAddress.note());
	}

	@Test
	public void testPostCode() {
		assertEquals("newPostCode", testGreenlandicAddress.postCode());
	}

	@Test
	public void testStreetBuilding() {
		assertEquals("newStreetBuilding", testGreenlandicAddress.streetBuilding());
	}

	@Test
	public void testStreetCode() {
		assertEquals("newStreetCode", testGreenlandicAddress.streetCode());
	}

	@Test
	public void testStreetName() {
		assertEquals("newStreetName", testGreenlandicAddress.streetName());
	}

	@Test
	public void testStreetNameForAddressing() {
		assertEquals("newNameForAddy", testGreenlandicAddress.streetNameForAddressing());
	}
	
	@Test
	public void testSuite() {
		assertEquals("newSuite", testGreenlandicAddress.suite());
	}
	
}
