package util.cprbroker;

public interface IAddress {

	EAddressType addressType();
	
	IDanishAddress danishAddress();
	IGreenlandicAddress greenlandicAddress();
	IWorldAddress worldAddress();
	
	String note();
}
