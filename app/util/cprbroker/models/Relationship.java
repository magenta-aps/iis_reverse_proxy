package util.cprbroker.models;

import util.cprbroker.IVirkning;
import util.cprbroker.IRelationship;

public class Relationship implements IRelationship {

	private final String comment;
	private final String referenceUrn;
	private final String referenceUuid;
	private final IVirkning effect;
	
	public static class Builder{
		
		private String comment;
		private String referenceUrn;
		private String referenceUuid;
		private IVirkning effect;
		
		public IRelationship build() { return new Relationship(this); }
		
		public Builder comment(String newComment) { comment = newComment; return this; }
		public Builder referenceUrn(String newUrn) { referenceUrn = newUrn; return this; }
		public Builder referenceUuid(String newUuid) { referenceUuid = newUuid; return this; }
		public Builder effect(IVirkning newEffect) { effect = newEffect; return this; }
		
	}
	
	private Relationship(Builder builder) {
		comment = builder.comment;
		referenceUrn = builder.referenceUrn;
		referenceUuid = builder.referenceUuid;
		effect = builder.effect;
	}
	
	@Override
	public String comment() { return comment; }

	@Override
	public String referenceUrn() { return referenceUrn; }

	@Override
	public String referenceUuid() {	return referenceUuid; }

	@Override
	public IVirkning effect() { return effect; }

}
