package util.cprbroker;

/**
 * Interface for accessing the CPR Broker
 * 
 * @author Søren Kirkegård
 *
 */
public interface ICprBrokerAccessor {

	/**
	 * Get UUID from a CPR number
	 * @param cprNumber
	 * @return Uuid for the cprNumber
	 */
	IUuid getUuid(final String cprNumber);

	//TODO Ask Beemen/Dennis what parameters this takes
	/**
	 * Get a person from a UUID
	 * @param uuid
	 * @return An implementation of the IPersonReturnType
	 */
	IPerson read(final String uuid);
	
	//TODO Add methods for SEARCH

}
