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

import util.cprbroker.ICprCitizenRegisterInformation;
import util.cprbroker.IVirkning;

import static org.mockito.Mockito.*;

public class CprCitizenDataTest {

	private ICprCitizenRegisterInformation testCprCitizenData;
	private IVirkning mockedVirkning;
	
	@Before
	public void setUp() throws Exception {
		
		mockedVirkning = mock(IVirkning.class);
		
		CprCitizenData.Builder builder = new CprCitizenData.Builder();
		
		builder.isMemberOfTheChurch(Boolean.TRUE);
		builder.isNameAdressProtected(Boolean.FALSE);
		builder.isPhoneNumberProtected(Boolean.TRUE);
		builder.isResearcherProtected(Boolean.FALSE);
		builder.isSocialSecurityNumberValid(Boolean.TRUE);
		builder.personNationalityCode("newNationalityCode");
		builder.socialSecurityNumber("newSocialSecurity");
		builder.virkning(mockedVirkning);
		
		
		testCprCitizenData = builder.build();
	}

	@Test
	public void testIsMemberOfTheChruch() {
		assertEquals(Boolean.TRUE, testCprCitizenData.isMemberOfTheChurch());
	}
	
	@Test
	public void testIsNameAddressProtected() {
		assertEquals(Boolean.FALSE, testCprCitizenData.isNameAddressProtected());
	}
	
	@Test
	public void testIsPhoneNumberProtected() {
		assertEquals(Boolean.TRUE, testCprCitizenData.isPhoneNumberProtected());
	}
	
	@Test
	public void testIsResearcherProtected() {
		assertEquals(Boolean.FALSE, testCprCitizenData.isResearcherProtected());
	}
	
	@Test
	public void testIsSocialSecurityNumberValid() {
		assertEquals(Boolean.TRUE, testCprCitizenData.isSocialSecurityNumberValid());
	}
	
	@Test
	public void testPersonNationalityCode() {
		assertEquals("newNationalityCode", testCprCitizenData.personNationalityCode());
	}
	
	@Test
	public void testSocialSecurityNumber() {
		assertEquals("newSocialSecurity", testCprCitizenData.socialSecurityNumber());
	}
	
	@Test
	public void testVirkning() {
		assertEquals(mockedVirkning, testCprCitizenData.virkning());
	}
	
	@Test
	public void testCprCitizen() {
		assertEquals(testCprCitizenData, testCprCitizenData.cprCitizen());
	}

}
