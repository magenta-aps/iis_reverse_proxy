package util.cprbroker;

import java.util.List;

/**
 * An immutable wrapper for a list of uuid values
 * @author Søren Kirkegård
 *
 */
public interface IUuids extends IStandardResponse {
	/**
	 * A simple wrapper around a list of uuid values.
	 * Altering the returned list must not reflect back
	 * into an instance of IUuids.
	 * @return List of Strings representing uuid values
	 */
	List<String> values();
}
