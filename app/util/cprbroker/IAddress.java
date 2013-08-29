package util.cprbroker;

public interface IAddress {
	boolean isDanishAddress();
	boolean isGreenlandicAddress();
	boolean isWorldAdress();
	
	IDanishAddress danishAddress();
	IGreenlandicAddress greenlandicAddress();
	IWorldAddress worldAddress();
}
