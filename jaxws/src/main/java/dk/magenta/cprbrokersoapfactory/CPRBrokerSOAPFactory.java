package dk.magenta.cprbrokersoapfactory;

import itst.dk.Part;
import itst.dk.PartSoap12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CPRBrokerSOAPFactory implements ICPRBrokerSOAPFactory {

	private static String endpointUrl;
	private static String appToken;
	private static String userToken;
	private static String source;
	
	private static String keystore;
	private static String keystorepassword;
	
	private static boolean usingSsl;

	public PartSoap12 getInstance() throws InstantiationException,
											NoSuchAlgorithmException,
											KeyStoreException,
											CertificateException,
											FileNotFoundException,
											IOException,
											UnrecoverableKeyException,
											KeyManagementException {
		
		//check
		checkIfRequiredVarablesArePresent();
		// Make certain that Part.java points to the WDSL
		Part service = new Part();

		//This sets the soap envelope headers
		service.setHandlerResolver(new HandlerResolver() {
            @Override
		    public List<Handler> getHandlerChain(PortInfo portInfo) {
		        List<Handler> handlerList = new ArrayList<Handler>();
		        handlerList.add(new CPRBrokerSOAPHandler(appToken, userToken, source));
		        return handlerList;
		    }
		});

		PartSoap12 port = service.getPartSoap12();
		if(usingSsl) {
			SSLContext sc = null;
			KeyManagerFactory kmf = null;

			sc = SSLContext.getInstance("SSLv3");
			kmf = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm() );
				
			KeyStore ks = null;
			ks = KeyStore.getInstance( KeyStore.getDefaultType() );
			ks.load(new FileInputStream( keystore ), keystorepassword.toCharArray() );
			kmf.init( ks, keystorepassword.toCharArray() );
			sc.init( kmf.getKeyManagers(), null, null );
		
			BindingProvider bp = (BindingProvider) port;
			// set the endpoint of the service
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);		
			// make use of ssl
			bp.getRequestContext().put("com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory", sc.getSocketFactory());			
		} else {
			BindingProvider bp = (BindingProvider) port;
	 		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);			
		}
		
		return port;
	}
	
	/**
	 * helper method to check that the setup variables are present
	 * @throws InstantiationException 
	 */
	private void checkIfRequiredVarablesArePresent() throws InstantiationException {
		// if the length of any of the variables are 0
		// then they havn't been set..
		if(endpointUrl.length() == 0) {
			throw new InstantiationException("endpointUrl needs to be set");
		} else if(appToken.length() == 0) {
			throw new InstantiationException("appToken needs to be set");
		} else if(userToken.length() == 0) {
			throw new InstantiationException("userToken needs to be set");
		} else if(source.length() == 0) {
			throw new InstantiationException("source needs to be set");
		} else if(keystore.length() == 0) {
			throw new InstantiationException("keystore needs to be set");
		} else if(keystorepassword.length() == 0) {
			throw new InstantiationException("keystorepassword needs to be set");
		} 
		
	}
	
	@Override
	public void setUsingSsl(final boolean usingSsl) {
		CPRBrokerSOAPFactory.usingSsl = usingSsl;
	}
	
	@Override
	public void setEndpoint(final String endpointUrl) {
		CPRBrokerSOAPFactory.endpointUrl = endpointUrl;
		
	}

	@Override
	public void setApplicationToken(final String appToken) {
		CPRBrokerSOAPFactory.appToken = appToken;
		
	}

	@Override
	public void setUserToken(final String userToken) {
		CPRBrokerSOAPFactory.userToken = userToken;
		
	}
	
	@Override
	public void setSourceUsageOrderHeader(final String source) {
		CPRBrokerSOAPFactory.source = source;
		
	}
	@Override
	public void setKeyStore(final String newKeyStore) {
		CPRBrokerSOAPFactory.keystore = newKeyStore;
	}

	@Override
	public void setKeyStorePassword(String newKeyStorePassword) {
		CPRBrokerSOAPFactory.keystorepassword = newKeyStorePassword;
		
	}
	
	/**
	 * Inner helper class that handles setting up the SOAP header
	 * in the SOAP envelope with the application- and usertoken.
	 * @author Søren Kirkegård
	 *
	 */
	private class CPRBrokerSOAPHandler implements SOAPHandler<SOAPMessageContext> {
		private final String appToken;
		private final String userToken;
		private final String source;
				
	    public CPRBrokerSOAPHandler(String appToken, String userToken, String source) {
	    	//call the super constructor
	    	super();
	    	
	    	//set the tokens
	    	this.appToken = appToken;
	    	this.userToken = userToken;
	    	this.source = source;
	    	
		}


		@Override
	    public boolean handleMessage(SOAPMessageContext context) {
	        String uri = "http://dk.itst";

	        Boolean outboundProperty =
	            (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	        if (outboundProperty.booleanValue()) {
	            try {
	                SOAPEnvelope envelope = context.getMessage()
	                        .getSOAPPart().getEnvelope();
	                SOAPFactory factory = SOAPFactory.newInstance();

	                String prefix = "";

	                // make the sourceUsageOrderHeader
	                SOAPElement sourceHeaderElem =
	                        factory.createElement("SourceUsageOrderHeader",prefix,uri);
	                
	                // make the source
	                SOAPElement sourceElem =
	                        factory.createElement("SourceUsageOrder",prefix,uri);
	                sourceElem.addTextNode(source);
	                sourceHeaderElem.addChildElement(sourceElem);
	                
	                // make the ApplicationHeader
	                SOAPElement appHeaderElem =
	                        factory.createElement("ApplicationHeader",prefix,uri);
	                
	                // make the ApplicationToken
	                SOAPElement appTokenElem =
	                        factory.createElement("ApplicationToken",prefix,uri);
	                appTokenElem.addTextNode(appToken);
	                appHeaderElem.addChildElement(appTokenElem);

	                // make the UserToken
	                SOAPElement usrTokenElem =
	                        factory.createElement("UserToken",prefix,uri);
	                usrTokenElem.addTextNode(userToken);
	                appHeaderElem.addChildElement(usrTokenElem);
	                
	                
	                // add the headers
	                SOAPHeader header = envelope.addHeader();
	                header.addChildElement(sourceHeaderElem);
	                header.addChildElement(appHeaderElem);

	            } catch (Exception e) {
	                System.out.println("Exception in handler: " + e);
	            }
	        }
	        
	        return true;
	    }

		@Override
		public boolean handleFault(SOAPMessageContext context) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void close(MessageContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Set<QName> getHeaders() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
