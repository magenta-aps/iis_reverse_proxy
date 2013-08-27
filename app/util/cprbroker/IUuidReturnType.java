package util.cprbroker;

/**
 * A interface for wrapping a getUuid response from the
 * CPR Broker
 * @author srnkrkgrd
 *
 */
public interface IUuidReturnType extends IStandardResponse {

	String uuid();
}
