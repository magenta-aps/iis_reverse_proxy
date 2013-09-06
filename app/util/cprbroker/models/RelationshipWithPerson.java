package util.cprbroker.models;

import util.cprbroker.ERelationshipType;
import util.cprbroker.IPerson;
import util.cprbroker.IRelationship;
import util.cprbroker.IRelationshipWithIPerson;
import util.cprbroker.IVirkning;

public class RelationshipWithPerson implements IRelationshipWithIPerson {

	private final IRelationship relationship;
	private final IPerson person;
	
	public static class Builder{
		private IRelationship relationship;
		private IPerson person;
		
		public IRelationshipWithIPerson build() { return new RelationshipWithPerson(this); }
		
		public Builder person(IPerson newPerson) { person = newPerson; return this;}
		public Builder relationship(IRelationship newRelationship) { relationship = newRelationship; return this; }
	}
	
	private RelationshipWithPerson(Builder builder) {
		relationship = builder.relationship;
		person = builder.person;
	}
	
	@Override
	public String comment() { return relationship.comment(); }

	@Override
	public String referenceUrn() { return relationship.referenceUrn(); }

	@Override
	public String referenceUuid() { return relationship.referenceUuid(); }

	@Override
	public IVirkning effect() {	return relationship.effect(); }

	@Override
	public ERelationshipType relationshipType() { return relationship.relationshipType(); }

	@Override
	public IPerson person() { return person; }

}
