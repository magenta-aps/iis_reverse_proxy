package util.cprbroker;

public interface IRelationship {
/*
		// PersonRelationType
		p1.get(0).getCommentText();
		p1.get(0).getReferenceID().getURNIdentifikator();
		p1.get(0).getReferenceID().getUUID();
		p1.get(0).getVirkning();
		
		// PersonFlerRelationType
		p2.get(0).getCommentText();
		p2.get(0).getReferenceID().getURNIdentifikator();
		p2.get(0).getReferenceID().getUUID();
		p2.get(0).getVirkning();
 */
	
	String comment();
	String referenceUrn();
	String referenceUuid();
	IVirkning effect();
	IPerson person();
	
}
