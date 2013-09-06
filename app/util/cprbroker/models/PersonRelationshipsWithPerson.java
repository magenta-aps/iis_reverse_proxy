package util.cprbroker.models;

import java.util.List;

import util.cprbroker.IPersonRelationshipsWithIPerson;
import util.cprbroker.IRelationshipWithIPerson;

public class PersonRelationshipsWithPerson implements IPersonRelationshipsWithIPerson {

	private final List<IRelationshipWithIPerson> relations;
	
	public PersonRelationshipsWithPerson(
			List<IRelationshipWithIPerson> newRelations) {
		
		relations = newRelations;
	}
	
	@Override
	public List<IRelationshipWithIPerson> allRelations() { return relations; }

}
