package dk.magenta.cprbrokersoapfactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import itst.dk.PartSoap12;
/**
 * Methods that a CPRBrokerSOAPFactory needs to implement
 * @author Søren Kirkegård
 *
 */
public interface ICPRBrokerSOAPFactory {
	/**
	 * Get an instance of the service interface to CPR broker using
	 * the endpointUrl, application- and usertoken can must be provided
	 * using the setter methods
	 * @return an instance of the Part Service interface
	 * @throws InstantiationException if factory hasn't been provided with endpoint, appToken or userToken
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws CertificateException 
	 * @throws UnrecoverableKeyException 
	 */
	public PartSoap12 getInstance() throws InstantiationException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException;
	
	/**
	 * Set if SSL is being used for the CPR Broker
	 * @param boolean value representing the usage of ssl
	 */
	public void setUsingSsl(boolean usingSsl);
	
	
	/**
	 * Set the endpoint for the CPR Broker
	 * @param endpoint a valid URL for endpoint
	 */
	public void setEndpoint(String endpointUrl);
	
	/**
	 * The application token that identifies the using application
	 * to the CPR broker
	 * @param appToken
	 */
	public void setApplicationToken(String appToken);
	
	/**
	 * The user token that identifies the using application to the
	 * CPR Broker
	 * @param userToken
	 */
	public void setUserToken(String userToken);
	
	/**
	 * 
	 * @param source
	 */
	public void setSourceUsageOrderHeader(String source);
	
	/**
	 * 
	 * @param newKeyStore
	 */
	public void setKeyStore(String newKeyStore);
	
	/**
	 * 
	 * @param newKeyStorePassword
	 */
	public void setKeyStorePassword (String newKeyStorePassword);
}
