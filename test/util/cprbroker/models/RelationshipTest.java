package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.ERelationshipType;
import util.cprbroker.IRelationship;
import util.cprbroker.IVirkning;

import static org.mockito.Mockito.*;

public class RelationshipTest {

	private IRelationship testRelationship;
	private IVirkning mockedVirkning;
	
	@Before
	public void setUp() {
		
		mockedVirkning = mock(IVirkning.class);
		
		Relationship.Builder builder = new Relationship.Builder();
		
		builder.comment("newComment");
		builder.effect(mockedVirkning);
		builder.referenceUrn("newUrn");
		builder.referenceUuid("newUuid");
		builder.type(ERelationshipType.erstatingAf);
		
		testRelationship = builder.build();
	}
	
	@Test
	public void testComment() {
		assertEquals("newComment", testRelationship.comment());
	}
	
	@Test
	public void testEffect() {
		assertEquals(mockedVirkning, testRelationship.effect());
	}

	@Test
	public void testReferenceUrn() {
		assertEquals("newUrn", testRelationship.referenceUrn());
	}

	@Test
	public void testReferenceUuid() {
		assertEquals("newUuid", testRelationship.referenceUuid());
	}

	@Test
	public void testRelationshipType() {
		assertEquals(ERelationshipType.erstatingAf, testRelationship.relationshipType());
	}

}
