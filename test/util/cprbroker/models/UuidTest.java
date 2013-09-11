package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IUuid;

public class UuidTest {

	private IUuid testUuid;
	
	@Before
	public void setUp() {
		testUuid = new Uuid("12345678-1234-1234-1234-123456789abc", 200, "OK");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testUuidCanNotBeConstructedWithNotValidUuid() {
		new Uuid("NOT VALID RANDOM STRING", 200, "OK");
	}
	
	@Test
	public void testUuidValue() {
		String expected = "12345678-1234-1234-1234-123456789abc";
		String actual = testUuid.value();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCodeValue() {
		int expected = 200;
		int actual = testUuid.code();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMessageValue() {
		String expected = "OK";
		String actual = testUuid.message();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testToString() {
		assertEquals(testUuid.value(), testUuid.toString());
	}
}
