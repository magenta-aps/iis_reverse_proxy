package util.cprbroker.jaxws;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import itst.dk.PartSoap12;
import oio.sagdok._2_0.LaesInputType;
import oio.sagdok._2_0.StandardReturType;
import oio.sagdok._2_0.VirkningType;
import oio.sagdok.person._1_0.CprBorgerType;
import oio.sagdok.person._1_0.DanskAdresseType;
import oio.sagdok.person._1_0.EgenskabType;
import oio.sagdok.person._1_0.GetUuidOutputType;
import oio.sagdok.person._1_0.GroenlandAdresseType;
import oio.sagdok.person._1_0.LaesOutputType;
import oio.sagdok.person._1_0.RegisterOplysningType;
import oio.sagdok.person._1_0.VerdenAdresseType;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.IPerson;
import util.cprbroker.IUuid;
import util.cprbroker.models.Person;
import util.cprbroker.models.Uuid;
import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;

public class JaxWsCprBroker implements ICprBrokerAccessor {

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
	public IUuid getUuid(final String cprNumber) {
		GetUuidOutputType uuid = port.getUuid(cprNumber);
		
		return new Uuid(uuid.getUUID(),
						uuid.getStandardRetur().getStatusKode().intValue(),
						uuid.getStandardRetur().getFejlbeskedTekst()); 
	}

	@Override
	public IPerson read(final String uuid) {
		
		// Setup the input parameters
		LaesInputType laesInput = new LaesInputType();
		laesInput.setUUID(uuid);

		// TODO Make it so you can call read with these parameters
		// laesInput.setRegistreringFraFilter(value) Registrations reported after this date
		// laesInput.setRegistreringTilFilter(value) Registrations reported before this date
		
		// Access CPR broker
		LaesOutputType laesOutput =  port.read(laesInput);
		
		// Building a person from the result
		//// Getting the standardReturType 
		StandardReturType standardReturType = laesOutput.getStandardRetur();

		//// Start building with the required parameters
		Person.Builder builder =
				new Person.Builder(standardReturType.getStatusKode().intValue(),
									standardReturType.getFejlbeskedTekst(),
				  					uuid);
		
		//// Did the read return anything? 
		//TODO Magic number removal (What status codes can it return?)
		if(standardReturType.getStatusKode().intValue() == 200) {
			// Assigning person attributes
			List<EgenskabType> personAttributes =
					laesOutput.getLaesResultat().getRegistrering().getAttributListe().getEgenskab();

			// Get the first from the list
			EgenskabType attributes = personAttributes.get(0);
			
			// Get the givenname
			String firstname = attributes.getNavnStruktur().getPersonNameStructure().getPersonGivenName();
			if(firstname != null) { builder.firstname(firstname); }
			
			// Get the middlename
			String middelName = attributes.getNavnStruktur().getPersonNameStructure().getPersonMiddleName();
			if(middelName != null) { builder.middelname(middelName); }

			// Get the surname
			String lastname = attributes.getNavnStruktur().getPersonNameStructure().getPersonSurnameName();
			if(lastname != null) { builder.lastname(lastname); }
			
			// Get the callname
			String callname = attributes.getNavnStruktur().getKaldenavnTekst();
			if(callname != null) { builder.lastname(callname); }

			// Get a name for addressing
			String addressingName = attributes.getNavnStruktur().getPersonNameForAddressingName();
			if(addressingName != null) { builder.nameForAdressing(addressingName); }
			
			// Get the gender
			// TODO Convert to enum?
			String gender = attributes.getPersonGenderCode().name();
			if(gender != null) { builder.gender(gender); }
			
			// Get the birthdate
			// TODO This date type? Maybe just convert to String? pro/con?
			XMLGregorianCalendar birthdate = attributes.getBirthDate();
			if(birthdate != null) { builder.birthdate(birthdate); }
			
			// Get the birthplace
			String birthplace = attributes.getFoedestedNavn();
			if(birthplace != null) { builder.birthplace(birthplace); }
		
			// Get the birthRegisteringAutherity
			String birthreg = attributes.getFoedselsregistreringMyndighedNavn();
			if(birthreg != null) { builder.birthRegisteringAuthority(birthreg); }
			
			// Get the address
			// TODO Figure out wtf this is..
			DanskAdresseType danskAdresse = attributes.getAndreAdresser().getDanskAdresse();
			GroenlandAdresseType groenlandskAdresse = attributes.getAndreAdresser().getGroenlandAdresse();
			VerdenAdresseType verdensAdresse = attributes.getAndreAdresser().getVerdenAdresse();
		
			// TODO implement these
			attributes.getKontaktKanal();
			attributes.getNaermestePaaroerende();
			attributes.getVirkning();
		
			// Get the registration information
			List<RegisterOplysningType> registerList = 
					laesOutput.getLaesResultat().getRegistrering().getAttributListe().getRegisterOplysning();
			RegisterOplysningType register = registerList.get(0);
			CprBorgerType citizenData = register.getCprBorger();
			citizenData.getFolkeregisterAdresse().getDanskAdresse().getAddressComplete();
			
		}

		return builder.build();
	}

}
