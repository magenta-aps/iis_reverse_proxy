package util.cprbroker;

public interface IPerson extends IStandardResponse, IPersonAttributes {
	
	/**
	 * 
	 * @return uuid for the person
	 */
	String uuid();	
	
	IRegisterInformation registerInformation();
	
	IAddress address();
}
