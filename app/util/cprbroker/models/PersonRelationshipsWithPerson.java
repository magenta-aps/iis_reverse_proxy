package util.cprbroker.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.cprbroker.IPersonRelationshipsWithIPerson;
import util.cprbroker.IRelationshipWithIPerson;

public class PersonRelationshipsWithPerson implements IPersonRelationshipsWithIPerson {

	private final List<IRelationshipWithIPerson> relations;
	
	public PersonRelationshipsWithPerson(
			List<IRelationshipWithIPerson> newRelations) {
		
		relations = defensiveCopyOfValues(newRelations);
	}
	
	@Override
	public List<IRelationshipWithIPerson> allRelations() { return relations; }

	
	/**
	 * helper method to make the class immutable
	 * @param newRelations IRelationshipWithIPerson representations
	 * @return Collections.unmodifiableList of a copy of the referencedValues
	 */
	private List<IRelationshipWithIPerson> defensiveCopyOfValues(List<IRelationshipWithIPerson> newRelations) {
		List<IRelationshipWithIPerson> copy = new LinkedList<IRelationshipWithIPerson>();
		
		for(IRelationshipWithIPerson relationWithPerson : newRelations) {
			copy.add(relationWithPerson);
		}
		
		return Collections.unmodifiableList(copy);
	}
}
