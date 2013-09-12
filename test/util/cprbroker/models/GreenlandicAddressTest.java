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
