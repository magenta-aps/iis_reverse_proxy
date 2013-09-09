package util.cprbroker;

import java.util.List;

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

	/**
	 * Get a person from a UUID
	 * @param uuid
	 * @return An implementation of the IPersonReturnType
	 */
	IPerson read(final String uuid, final ESourceUsageOrder sourceUsageOrder, boolean isGettingRelations);
	
	//TODO Add methods for SEARCH
	IUuids search(final String firstname, final String middlename, final String lastname, int maxResults, int startIndex);
	
	//TODO Add methods for list
	List<IPerson> list(final IUuids uuids, final ESourceUsageOrder sourceUsageOrder);

}
