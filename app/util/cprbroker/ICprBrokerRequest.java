package util.cprbroker;

import java.util.List;

/**
 * Interface for accessing the CPR Broker trying to simplify
 * access and returntypes
 * 
 * @author Søren Kirkegård
 *
 */
public interface ICprBrokerRequest {

	/**
	 * 
	 * @param cprNumber
	 * @return Uuid for the cprNumber
	 */
	IUuidReturnType getUuid(final String cprNumber);

	//TODO Add methods for READ and SEARCH
}
