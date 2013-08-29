package util.cprbroker;

import java.util.Date;

public interface IPerson extends IStandardResponse, IPersonAttributes {
	
	/**
	 * 
	 * @return uuid for the person
	 */
	String uuid();	
}
