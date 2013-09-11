package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IContact;

public class ContactTest {

	IContact testContact;
	
	@Before
	public void setUp() {
		Contact.Builder builder = new Contact.Builder();
		
		builder.email("newEmail");
		builder.isPhoneAbleToRecieveSms(true);
		builder.limitedUsageText("newText");
		builder.noteText("newNote");
		builder.otherContactNoteText("newContactNote");
		builder.otherContactText("newContactText");
		builder.phone("12345678");
		
		testContact = builder.build();
	}
	
	@Test
	public void testEmail() {
		assertEquals("newEmail", testContact.email());
	}

	@Test
	public void testISPhoneAbleToRecieveSms() {
		assertEquals(Boolean.TRUE, testContact.isPhoneAbleToRecieveSms());
	}
	
	@Test
	public void testLimitedUsageText() {
		assertEquals("newText", testContact.limitedUsageText());
	}

	@Test
	public void testNoteText() {
		assertEquals("newNote", testContact.noteText());
	}
	
	@Test
	public void testOtherContactNoteText() {
		assertEquals("newContactNote", testContact.otherContactNoteText());
	}
	
	@Test
	public void testOtherContactText() {
		assertEquals("newContactText", testContact.otherContactText());
	}
	
	@Test
	public void testPhone() {
		assertEquals("12345678", testContact.phone());
	}
}
