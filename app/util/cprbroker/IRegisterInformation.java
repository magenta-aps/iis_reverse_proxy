package util.cprbroker;

/**
 * Type interface
 * @author Søren Kirkegård
 *
 */
public interface IRegisterInformation {	
	ICprCitizenRegisterInformation cprCitizen();
	
	//TODO implement isCprCitizen, isUnknownCitizen, isForeignCitizen
	//	   implement unknownCitizen, foreignCitizen
}
