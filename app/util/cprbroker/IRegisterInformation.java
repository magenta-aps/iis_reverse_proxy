package util.cprbroker;

/**
 * Type interface
 * @author Søren Kirkegård
 *
 */
public interface IRegisterInformation {	
	ICprCitizenRegisterInformation cprCitizen();
	
	IVirkning virkning();
	
	//TODO implement isCprCitizen, isUnknownCitizen, isForeignCitizen
	//	   implement unknownCitizen, foreignCitizen
}
