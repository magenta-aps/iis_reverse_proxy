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
	 * Set the sourceUsageOrderHeader of the request should default to
	 * LocalOnly if not set
	 * @param sourceUsageOrderHeader LocalThenExternal, LocalOnly, ExternalOnly
	 */
	void setSourceUsageOrderHeader(final String sourceUsageOrderHeader);
	
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
	IUuids search(final String firstname, final String middlename, final String lastname, int maxResults);
	
	//TODO Add methods for list
	List<IPerson> list(final IUuids uuids);

}
