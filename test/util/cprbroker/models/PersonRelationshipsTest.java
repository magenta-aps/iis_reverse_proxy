/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package util.cprbroker.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.ERelationshipType;
import util.cprbroker.IPersonRelationships;
import util.cprbroker.IRelationship;



public class PersonRelationshipsTest {
	
	private IPersonRelationships testPersonRelationships;
		
	@Before
	public void setUp() {

		// make builder
		PersonRelationships.Builder builder = new PersonRelationships.Builder();
		
		// mock aegtefaelle, add the mock in a list and put it in the builder
		List<IRelationship> newAegtefaelleList = getRelationshipList(ERelationshipType.aegtefaelle);		
		builder.selectTheRightRelationship(newAegtefaelleList);
		
		
		// mock boern, add the mock in a list and put it in the builder
		List<IRelationship> newBoernList = getRelationshipList(ERelationshipType.boern);
		builder.selectTheRightRelationship(newBoernList);
		
		
		// mock bopaelssamling, add the mock in a list and put it in the builder
		List<IRelationship> newBopaelssamlingList = getRelationshipList(ERelationshipType.bopaelssamling);			
		builder.selectTheRightRelationship(newBopaelssamlingList);

		
		// mock erstatningAf, add the mock in a list and put it in the builder
		List<IRelationship> newErstatningAfList = getRelationshipList(ERelationshipType.erstatingAf);
		builder.selectTheRightRelationship(newErstatningAfList);

		// mock erstatningFor, add the mock in a list and put it in the builder
		List<IRelationship> newErstatningForList = getRelationshipList(ERelationshipType.erstatingFor);;
		builder.selectTheRightRelationship(newErstatningForList);
		
		
		// mock fader, add the mock in a list and put it in the builder
		List<IRelationship> newFaderList = getRelationshipList(ERelationshipType.fader);			
		builder.selectTheRightRelationship(newFaderList);
		
		
		// mock foraeldremyndighedsboern, add the mock in a list and put it in the builder
		List<IRelationship> newForaeldremyndighedsboernList = getRelationshipList(ERelationshipType.foraeldremydighedsboern);			
		builder.selectTheRightRelationship(newForaeldremyndighedsboernList);
		
		
		// mock foraeldremyndighedsindehaver, add the mock in a list and put it in the builder
		List<IRelationship> newForaeldremyndighedsindehaverList = getRelationshipList(ERelationshipType.foraeldremyndighedsindehaver);
		builder.selectTheRightRelationship(newForaeldremyndighedsindehaverList);

		
		// mock moder, add the mock in a list and put it in the builder
		List<IRelationship> newModerList = getRelationshipList(ERelationshipType.moder);
		builder.selectTheRightRelationship(newModerList);
		
		
		// mock registreretPartner, add the mock in a list and put it in the builder
		List<IRelationship> newRegistreretPartnerList = getRelationshipList(ERelationshipType.registreretPartner);
		builder.selectTheRightRelationship(newRegistreretPartnerList);
		
		
		// mock retligHandleevneVaergeForPersonen, add the mock in a list and put it in the builder
		List<IRelationship> newrRetligHandleevneVaergeForPersonenList = getRelationshipList(ERelationshipType.retligHandleevneVaergeForPersonen);
		builder.selectTheRightRelationship(newrRetligHandleevneVaergeForPersonenList);
		

		// mock retligHandleevneVaergemaalsindehaver, add the mock in a list and put it in the builder
		List<IRelationship> newRetligHandleevneVaergemaalsindehaverList = getRelationshipList(ERelationshipType.retligHandleevneVaergemaalsindehaver);
		builder.selectTheRightRelationship(newRetligHandleevneVaergemaalsindehaverList);

		// build the testPersonRelationships
		testPersonRelationships = builder.build();
		
	}
	
	/**
	 * Helper method to make lists of IRelationships from a ERelationshipType
	 * @param relationshipType
	 * @return
	 */
	private static List<IRelationship> getRelationshipList(ERelationshipType relationshipType) {

		IRelationship mockedRelationship = mock(IRelationship.class);
		when(mockedRelationship.relationshipType()).thenReturn(relationshipType);
				
		List<IRelationship> newRelationshipList = new ArrayList<IRelationship>();
		newRelationshipList.add(mockedRelationship);
		
		return newRelationshipList;
	}

	/**
	 * helper method
	 * @param relationshipType
	 * @return
	 */
	private ERelationshipType getRelationshipType (ERelationshipType relationshipType) {
		IRelationship relationship = testPersonRelationships.getRelationshipsOfType(relationshipType).get(0);
		return relationship.relationshipType();
	}

	@Test
	public void testAegtefaelle() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.aegtefaelle);
		assertEquals(ERelationshipType.aegtefaelle, actual);
	}
	
	@Test
	public void testBoern() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.boern);
		assertEquals(ERelationshipType.boern, actual);
	}

	
	@Test
	public void testBopaelssamling() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.bopaelssamling);
		assertEquals(ERelationshipType.bopaelssamling, actual);
	}

	@Test
	public void testErstatningAf() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.erstatingAf);
		assertEquals(ERelationshipType.erstatingAf, actual);
	}

	@Test
	public void testErstatningFor() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.erstatingFor);
		assertEquals(ERelationshipType.erstatingFor, actual);
	}
	
	@Test
	public void testFader() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.fader);
		assertEquals(ERelationshipType.fader, actual);
	}

	@Test
	public void testForaeldremyndighedsboern() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.foraeldremydighedsboern);
		assertEquals(ERelationshipType.foraeldremydighedsboern, actual);
	}

	@Test
	public void testForaeldremyndighedsindehaver() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.foraeldremyndighedsindehaver);
		assertEquals(ERelationshipType.foraeldremyndighedsindehaver, actual);
	}
	
	@Test
	public void testModer() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.moder);
		assertEquals(ERelationshipType.moder, actual);
	}

	@Test
	public void testRegisteretPartner() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.registreretPartner);
		assertEquals(ERelationshipType.registreretPartner, actual);
	}

	@Test
	public void testRetligHandleevneVaergeForPersonen() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.retligHandleevneVaergeForPersonen);
		assertEquals(ERelationshipType.retligHandleevneVaergeForPersonen, actual);
	}
	
	@Test
	public void testRetligHandleevneVaergemaalsindehaver() {
		ERelationshipType actual = getRelationshipType(ERelationshipType.retligHandleevneVaergemaalsindehaver);
		assertEquals(ERelationshipType.retligHandleevneVaergemaalsindehaver, actual);
	}
	
	@Test
	public void testSelectTheRightRelationshipWithNull() {
		// make builder
		PersonRelationships.Builder builder = new PersonRelationships.Builder();
		
		// play pretend that we put a null AegtefalleList in the builder
		List<IRelationship> newAegtefaelleList = null;		
		builder.selectTheRightRelationship(newAegtefaelleList);
		
		IPersonRelationships testPersonRelationship = builder.build();
		
		assertEquals(null, testPersonRelationship.aegtefaelle());
	}
	
	@Test
	public void testSelectTheRightRelationshipWithEmptyList() {
		// make builder
		PersonRelationships.Builder builder = new PersonRelationships.Builder();
		
		// play pretend that we put a empty AegtefalleList in the builder
		List<IRelationship> newAegtefaelleList = new ArrayList<IRelationship>();		
		builder.selectTheRightRelationship(newAegtefaelleList);
		
		IPersonRelationships testPersonRelationship = builder.build();
		
		assertEquals(null, testPersonRelationship.aegtefaelle());
	}

	@Test
	public void selectTheRightRelationshipWithUnsupportedEnumType() {
		//TODO Hack enum class : http://www.javaspecialists.eu/archive/Issue161.html
	}


	@Test
	public void testNumberOfRelationships() {
		// added one of each relationshiptype in the setUp
		int expected = 12;
		assertEquals(expected, testPersonRelationships.numberOfRelations());

	}
	
	@Test(expected=UnsupportedOperationException.class) 
	public void testAegtefaelleIsImmutableAdd() {
		List<IRelationship> immutableRelationshipList =	testPersonRelationships.aegtefaelle();
		IRelationship mockedRelationship = mock(IRelationship.class);
		
		immutableRelationshipList.add(mockedRelationship);
	}

	@Test(expected=UnsupportedOperationException.class) 
	public void testAegtefaelleIsImmutableRemove() {
		List<IRelationship> immutableRelationshipList =	testPersonRelationships.aegtefaelle();
		
		immutableRelationshipList.remove(0);
	}

	//TODO Add for the rest of the Immutable tests or is it enough to test that one is?
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testIsCorrectRelationshipType() {
		
		// make builder
		PersonRelationships.Builder builder = new PersonRelationships.Builder();
		
		// mock aegtefaelle, add the mock in a list and put it in the builder
		IRelationship mockedAegtefaelle = mock(IRelationship.class);
		
		// add WRONG ERelationshipType
		when(mockedAegtefaelle.relationshipType()).thenReturn(ERelationshipType.boern);
				
		List<IRelationship> newAegtefaelleList = new ArrayList<IRelationship>();
		newAegtefaelleList.add(mockedAegtefaelle);
		
		builder.aegtefaelle(newAegtefaelleList);
	}
	
	@Test
	public void testDefensiveCopyOfValuesWithNull() {
		IPersonRelationships localPersonRelationships;
		// make builder
		PersonRelationships.Builder builder = new PersonRelationships.Builder();
		// adding NULL
		builder.aegtefaelle(null);
		
		// build the testPersonRelationships
		localPersonRelationships = builder.build();
		
		assertEquals(null, localPersonRelationships.aegtefaelle());

	}
	
	
}
