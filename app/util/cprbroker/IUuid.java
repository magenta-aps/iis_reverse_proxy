package util.cprbroker;

/**
 * A interface for wrapping a getUuid response from the
 * CPR Broker
 * 
 * A valid UUID is a String with an exact length of XXX
 * and trying to construct a Uuid with a non-valid uuid
 * value should throw an IllegalArgumentException
 * 
 * @throws IllegalArgumentException
 * @author Søren Kirkegård
 *
 */
public interface IUuid extends IStandardResponse {

	/**
	 * A simple getter for a UUID. A uuid must be immutable and
	 * it must not be possible to contruct a IUuid that has a
	 * non-valid uuid
	 * 
	 * @return String representation of a uuid
	 */
	String value();
}