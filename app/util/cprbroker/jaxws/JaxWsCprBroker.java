package util.cprbroker.jaxws;

import oio.sagdok.person._1_0.GetUuidOutputType;
import itst.dk.PartSoap12;
import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;
import util.cprbroker.ICprBrokerRequest;
import util.cprbroker.IUuidReturnType;

public class JaxWsCprBroker implements ICprBrokerRequest {

	PartSoap12 port;
	
	public JaxWsCprBroker(final String endpoint,
							final String applicationToken,
							final String userToken) {

		CPRBrokerSOAPFactory factory = new CPRBrokerSOAPFactory();
		factory.setEndpoint(endpoint);
		factory.setApplicationToken(applicationToken);
		factory.setUserToken(userToken);
		
		try {
			port = factory.getInstance();
		} catch (InstantiationException e) {
			play.Logger.error(e.getMessage());
		}

	}
	
	@Override
	public IUuidReturnType getUuid(String cprNumber) {
		GetUuidOutputType uuid = port.getUuid(cprNumber);
		
		return new Uuid(uuid.getUUID(),
						uuid.getStandardRetur().getStatusKode().intValue(),
						uuid.getStandardRetur().getFejlbeskedTekst()); 
	}

}
