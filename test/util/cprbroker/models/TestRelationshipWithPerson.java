package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.ERelationshipType;
import util.cprbroker.IPerson;
import util.cprbroker.IRelationship;
import util.cprbroker.IRelationshipWithIPerson;
import util.cprbroker.IVirkning;

import static org.mockito.Mockito.*;

public class TestRelationshipWithPerson {
	
	private IRelationshipWithIPerson testRelationshipWithPerson;
	private IPerson mockedPerson;
	private IVirkning mockedVirkning;
	
	@Before
	public void setUp() throws Exception {
		
		mockedPerson = mock(IPerson.class);
		mockedVirkning = mock(IVirkning.class);
		
		IRelationship mockedRelationship = mock(IRelationship.class);
		when(mockedRelationship.comment()).thenReturn("newComment");
		when(mockedRelationship.effect()).thenReturn(mockedVirkning);
		when(mockedRelationship.referenceUrn()).thenReturn("newUrn");
		when(mockedRelationship.referenceUuid()).thenReturn("newUuid");
		when(mockedRelationship.relationshipType()).thenReturn(ERelationshipType.fader);
				
		RelationshipWithPerson.Builder builder = new RelationshipWithPerson.Builder();
		
		builder.person(mockedPerson);
		builder.relationship(mockedRelationship);
		
		testRelationshipWithPerson = builder.build();
	}

	@Test
	public void testComment() {
		assertEquals("newComment", testRelationshipWithPerson.comment());
	}

	@Test
	public void testVirkning() {
		assertEquals(mockedVirkning, testRelationshipWithPerson.effect());
	}

	@Test
	public void testPerson() {
		assertEquals(mockedPerson, testRelationshipWithPerson.person());
	}

	@Test
	public void testReferenceUrn() {
		assertEquals("newUrn", testRelationshipWithPerson.referenceUrn());
	}

	@Test
	public void testReferenceUuid() {
		assertEquals("newUuid", testRelationshipWithPerson.referenceUuid());
	}

	@Test
	public void testRelationshipType() {
		assertEquals(ERelationshipType.fader, testRelationshipWithPerson.relationshipType());
	}
}
