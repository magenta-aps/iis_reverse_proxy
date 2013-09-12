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
