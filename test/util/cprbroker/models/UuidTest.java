package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IUuid;

public class UuidTest {

	private IUuid testUuid;
	
	@Before
	public void setUp() {
		testUuid = new Uuid("12345678901234567890123456789012345678", 200, "OK");
	}
		
	@Test
	public void testUuidValue() {
		String expected = "12345678901234567890123456789012345678";
		String actual = testUuid.value();
		
		assertEquals("Uuid value of " + expected + ", but was " + actual ,
					expected, actual);
	}
	
	@Test
	public void testCodeValue() {
		int expected = 200;
		int actual = testUuid.code();
		
		assertEquals("Code value of " + expected + ", but was " + actual,
				expected, actual);
	}
	
	@Test
	public void testMessageValue() {
		String expected = "OK";
		String actual = testUuid.message();
		
		assertEquals(expected, actual);
	}
}
