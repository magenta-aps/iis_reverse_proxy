package util.cprbroker;
/**
 * Enum used to select the datasource usage from the
 * CPR Broker on the calls that can take that parameter
 * @author Søren Kirkegård
 *
 */
public enum ESourceUsageOrder {
	LocalOnly ,
	LocalThenExternal,
	ExternalOnly
}
