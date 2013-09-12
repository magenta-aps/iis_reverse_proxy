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
