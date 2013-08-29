package util.cprbroker;

/**
 * A interface for wrapping a getUuid response from the
 * CPR Broker
 * @author srnkrkgrd
 *
 */
public interface IUuid extends IStandardResponse {

	/**
	 * 
	 * @return uuid for the person
	 */
	String uuid();
}
