package util.cprbroker.models;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IAddress;
import util.cprbroker.IContact;
import util.cprbroker.IPerson;
import util.cprbroker.IPersonRelationships;
import util.cprbroker.IPersonRelationshipsWithIPerson;
import util.cprbroker.IRegisterInformation;
import util.cprbroker.ITidspunkt;
import util.cprbroker.ITilstand;
import util.cprbroker.IVirkning;

import static org.mockito.Mockito.*;

public class PersonTest {

	// subject under test
	IPerson testPerson;
	
	// mocks
	IAddress newAddress;
	IContact newContact;
	IVirkning newEffect;
	IContact newNextOfKinContact;
	IAddress newOtherAddress;
	IRegisterInformation newRegInfo;
	IPersonRelationships newRelations;
	IPersonRelationshipsWithIPerson newRelationsWithPerson;
	ITidspunkt newTidspunkt;
	ITilstand newTilstand;
	
	// implementations
	DateTime expectedBirthdate;
	
	@Before
	public void setUp() throws Exception {
		
		Person.Builder builder = new Person.Builder(200, "OK", "12345678-1234-1234-1234-123456789abc");
		
		newAddress = mock(IAddress.class);
		builder.address(newAddress);
		
		GregorianCalendar newBirthdate = new GregorianCalendar(1978, 11, 26, 13, 37, 00);
		expectedBirthdate = new DateTime(1978, 12, 26, 13, 37, 00);
		builder.birthdate(newBirthdate);
		
		builder.birthplace("newBirthplace");
		builder.birthRegisteringAuthority("newBirthRegisteringAuthority");
		builder.callname("newCallname");
		
		newContact = mock(IContact.class);
		builder.contact(newContact);
		
		newEffect = mock(IVirkning.class);
		builder.effect(newEffect);
		
		builder.firstname("newFirstname");
		builder.gender("newGender");
		builder.lastname("newLastname");
		builder.middelname("newMiddelname");
		builder.nameForAdressing("newNameForAddressing");
		
		newNextOfKinContact = mock(IContact.class);
		builder.nextOfKinContact(newNextOfKinContact);
		
		newOtherAddress = mock(IAddress.class);
		builder.otherAddress(newOtherAddress);
		
		newRegInfo = mock(IRegisterInformation.class);
		builder.registerInformation(newRegInfo);
		
		newRelations = mock(IPersonRelationships.class);
		builder.relations(newRelations);
		
		newRelationsWithPerson = mock(IPersonRelationshipsWithIPerson.class);
		builder.relationsWithPerson(newRelationsWithPerson);
		
		newTidspunkt = mock(ITidspunkt.class);
		builder.tidspunkt(newTidspunkt);
		
		newTilstand = mock(ITilstand.class);
		builder.tilstand(newTilstand);
		
		testPerson = builder.build();
		
	}

	@Test
	public void testAddress() {
		assertEquals(newAddress, testPerson.address());
	}
	
	@Test
	public void testBirthdate() {
		assertEquals(expectedBirthdate.getMillis(), testPerson.birthdate().getMillis());
	}
	
	@Test
	public void testBirthplace() {
		assertEquals("newBirthplace", testPerson.birthplace());
	}

	@Test
	public void testBirthRegisteringAuthority() {
		assertEquals("newBirthRegisteringAuthority", testPerson.birthRegisteringAuthority());
	}
	
	@Test
	public void testCallname() {
		assertEquals("newCallname", testPerson.callname());
	}
	
	@Test
	public void testCode() {
		assertEquals(200, testPerson.code());
	}
	
	@Test
	public void testContact() {
		assertEquals(newContact, testPerson.contact());
	}
	
	@Test
	public void testEffect() {
		assertEquals(newEffect, testPerson.effect());
	}
	
	@Test
	public void testFirstname() {
		assertEquals("newFirstname", testPerson.firstname());
	}
	
	@Test
	public void testGender() {
		assertEquals("newGender", testPerson.gender());
	}
	
	@Test
	public void testLastname() {
		assertEquals("newLastname", testPerson.lastname());
	}
	
	@Test
	public void testMessage() {
		assertEquals("OK", testPerson.message());
	}
	
	@Test
	public void testMiddelname() {
		assertEquals("newMiddelname", testPerson.middelname());
	}
	
	@Test
	public void testNameForAddressing() {
		assertEquals("newNameForAddressing", testPerson.nameForAddressing());
	}
	
	@Test
	public void testNextOfKinContact() {
		assertEquals(newNextOfKinContact, testPerson.nextOfKinContact());
	}
	
	@Test
	public void testOtherAddress() {
		assertEquals(newOtherAddress, testPerson.otherAddress());
	}
	
	@Test
	public void testRegisterInformation() {
		assertEquals(newRegInfo, testPerson.registerInformation());
	}
	
	@Test
	public void testRelations() {
		assertEquals(newRelations, testPerson.relations());
	}
	
	@Test
	public void testRelationsWithPerson() {
		assertEquals(newRelationsWithPerson, testPerson.relationsWithPerson());
	}
	
	@Test
	public void testTidspunkt() {
		assertEquals(newTidspunkt, testPerson.tidspunkt());
	}
	
	@Test
	public void testTilstand() {
		assertEquals(newTilstand, testPerson.tilstand());
	}
	
	@Test
	public void testUuid() {
		assertEquals("12345678-1234-1234-1234-123456789abc", testPerson.uuid());
	}
}
