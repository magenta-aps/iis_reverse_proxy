package util.cprbroker;

public interface IPerson extends IStandardResponse, IPersonAttributes {
	
	/**
	 * 
	 * @return uuid for the person
	 */
	String uuid();
	
	ITidspunkt tidspunkt();
	
	IRegisterInformation registerInformation();
	
	IAddress address();
	
	IContact contact();
	
	IContact nextOfKinContact();
	
	IVirkning effect();
	
	IPersonRelationships relations();
	
	IPersonRelationshipsWithIPerson relationsWithPerson();
	
	ITilstand tilstand();
}
