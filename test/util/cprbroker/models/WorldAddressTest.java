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
import util.cprbroker.IWorldAddress;

public class WorldAddressTest {

	private IWorldAddress testWorldAddress;
	
	@Before
	public void setUp() throws Exception {
		WorldAddress.Builder builder = new WorldAddress.Builder();
		
		builder.countryIdentificationCode("newCode");
		builder.isUkendtAdresseIndikator(Boolean.TRUE);
		builder.locationDescriptionText("newText");
		builder.note("newNote");
		builder.postalAddressFirstLineText("new1stLine");
		builder.postalAddressSecondLineText("new2ndLine");
		builder.postalAddressThirdLineText("new3rdLine");
		builder.postalAddressFourthLineText("new4thLine");
		builder.postalAddressFifthLineText("new5thLine");
		
		testWorldAddress = builder.build();
	}
	
	@Test
	public void testAddressType() {
		assertEquals(EAddressType.World, testWorldAddress.addressType());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testDanishAddress() {
		testWorldAddress.danishAddress();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testGreenlandicAddress() {
		testWorldAddress.greenlandicAddress();
	}
	
	@Test
	public void testWorldAddress() {
		assertEquals(testWorldAddress, testWorldAddress.worldAddress());
	}
	
	@Test
	public void testCountryIdentificationCode() {
		assertEquals("newCode", testWorldAddress.countryIdentificationCode());
	}
	
	@Test
	public void testIsUkendtAdresseIndikator() {
		assertEquals(Boolean.TRUE, testWorldAddress.isUkendtAdresseIndikator());
	}
	
	@Test
	public void testLocationDescriptionText() {
		assertEquals("newText", testWorldAddress.locationDescriptionText());
	}
	
	@Test
	public void testNote() {
		assertEquals("newNote", testWorldAddress.note());
	}
	
	@Test
	public void testPostalAddressFirstLineText() {
		assertEquals("new1stLine", testWorldAddress.postalAddressFirstLineText());
	}
	
	@Test
	public void testPostalAddressSecondLineText() {
		assertEquals("new2ndLine", testWorldAddress.postalAddressSecondLineText());
	}
	
	@Test
	public void testPostalAddressThirdLineText() {
		assertEquals("new3rdLine", testWorldAddress.postalAddressThirdLineText());
	}
	
	@Test
	public void testPostalAddressFourthLineText() {
		assertEquals("new4thLine", testWorldAddress.postalAddressFourthLineText());
	}
	
	@Test
	public void testPostalAddressFifthLineText() {
		assertEquals("new5thLine", testWorldAddress.postalAddressFifthLineText());
	}

}
