package util.cprbroker.models;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IUuids;

public class UuidsTest {

	private IUuids testUuids;
	private List<String> values;
	
	@Before
	public void setUp() {
		List<String> newUuids = new LinkedList<String>();
		newUuids.add("A1234567890123456789012345678901234567");
		newUuids.add("B1234567890123456789012345678901234567");
		values = newUuids;
		
		testUuids = new Uuids(200, "OK", newUuids);
	}
	
	@Test
	public void testCode() {
		int expected = 200;
		
		assertEquals(expected, testUuids.code());
	}
	
	@Test
	public void testMessage() {
		String expected = "OK";
		
		assertEquals(expected, testUuids.message());
	}
	
	@Test
	public void testUuidsCantBeChangedByAlteringListFromConstruction() {
		
		int expected = testUuids.values().size();
		
		values.add("C1234567890123456789012345678901234567");
		
		assertEquals(expected, testUuids.values().size());
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUuidsNewValuesCanNotBeAdded() {
		testUuids.values().add("C1234567890123456789012345678901234567");
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUuidsValuesCanNotBeRemoved() {
		testUuids.values().remove(0);
	}

	
}
