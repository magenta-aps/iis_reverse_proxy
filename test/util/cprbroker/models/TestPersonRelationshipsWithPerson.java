package util.cprbroker.models;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IRelationshipWithIPerson;

import static org.mockito.Mockito.*;

public class TestPersonRelationshipsWithPerson {

	private PersonRelationshipsWithPerson testPersonRelationshipsWithPerson;
	
	private List<IRelationshipWithIPerson> mockedRelationsList;
	private IRelationshipWithIPerson mockedRelationshipWithIPerson;
	
	
	@Before
	public void setUp() throws Exception {
		mockedRelationsList = new LinkedList<IRelationshipWithIPerson>();
		mockedRelationshipWithIPerson = mock(IRelationshipWithIPerson.class);
		mockedRelationsList.add(mockedRelationshipWithIPerson);
		
		testPersonRelationshipsWithPerson = new PersonRelationshipsWithPerson(mockedRelationsList);
	}

	@Test
	public void testAllRelations() {
		IRelationshipWithIPerson expected = mockedRelationshipWithIPerson;
		assertEquals(expected, testPersonRelationshipsWithPerson.allRelations().get(0));
	}

	@Test
	public void testListCantBeChangedByAlteringListFromConstruction() {
		
		int expected = testPersonRelationshipsWithPerson.allRelations().size();
		
		mockedRelationsList.add(mockedRelationshipWithIPerson);
		
		assertEquals(expected, testPersonRelationshipsWithPerson.allRelations().size());
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testNewValuesCanNotBeAdded() {
		testPersonRelationshipsWithPerson.allRelations().add(mockedRelationshipWithIPerson);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUuidsValuesCanNotBeRemoved() {
		testPersonRelationshipsWithPerson.allRelations().remove(0);
	}
	
}
