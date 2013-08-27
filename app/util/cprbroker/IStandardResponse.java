package util.cprbroker;

/**
 * Interface to mimic the IStandartReturType of CPR Broker
 * @author Søren Kirkegård
 *
 */
public interface IStandardResponse {
	String message();
	int code();
}
