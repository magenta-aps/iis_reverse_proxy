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

