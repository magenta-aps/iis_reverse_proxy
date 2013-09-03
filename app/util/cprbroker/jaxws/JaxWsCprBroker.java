package util.cprbroker.jaxws;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import itst.dk.PartSoap12;
import oio.sagdok._2_0.LaesInputType;
import oio.sagdok._2_0.PersonFlerRelationType;
import oio.sagdok._2_0.StandardReturType;
import oio.sagdok._2_0.TidspunktType;
import oio.sagdok._2_0.TilstandVirkningType;
import oio.sagdok._2_0.UnikIdType;
import oio.sagdok._2_0.VirkningType;
import oio.sagdok.person._1_0.AdresseType;
import oio.sagdok.person._1_0.AndenKontaktKanalType;
import oio.sagdok.person._1_0.CivilStatusType;
import oio.sagdok.person._1_0.CprBorgerType;
import oio.sagdok.person._1_0.DanskAdresseType;
import oio.sagdok.person._1_0.EgenskabType;
import oio.sagdok.person._1_0.GetUuidOutputType;
import oio.sagdok.person._1_0.GroenlandAdresseType;
import oio.sagdok.person._1_0.KontaktKanalType;
import oio.sagdok.person._1_0.LaesOutputType;
import oio.sagdok.person._1_0.LivStatusType;
import oio.sagdok.person._1_0.PersonRelationType;
import oio.sagdok.person._1_0.RegisterOplysningType;
import oio.sagdok.person._1_0.RegistreringType;
import oio.sagdok.person._1_0.RelationListeType;
import oio.sagdok.person._1_0.TilstandListeType;
import oio.sagdok.person._1_0.VerdenAdresseType;
import util.cprbroker.IAddress;
import util.cprbroker.IContact;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.IDanishAddress;
import util.cprbroker.IPersonRelationships;
import util.cprbroker.IRegisterInformation;
import util.cprbroker.ITidspunkt;
import util.cprbroker.ITilstand;
import util.cprbroker.IVirkning;
import util.cprbroker.IPerson;
import util.cprbroker.IRelationship;
import util.cprbroker.IUuid;
import util.cprbroker.models.Contact;
import util.cprbroker.models.CprCitizenData;
import util.cprbroker.models.DanishAddress;
import util.cprbroker.models.GreenlandicAddress;
import util.cprbroker.models.Person;
import util.cprbroker.models.PersonRelationships;
import util.cprbroker.models.Relationship;
import util.cprbroker.models.Tidspunkt;
import util.cprbroker.models.Tilstand;
import util.cprbroker.models.Uuid;
import util.cprbroker.models.Virkning;
import util.cprbroker.models.WorldAddress;
import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;
import dk.oio.rep.cpr_dk.xml.schemas._2008._05._01.AddressCompleteGreenlandType;
import dk.oio.rep.cpr_dk.xml.schemas._2008._05._01.ForeignAddressStructureType;
import dk.oio.rep.ebxml.xml.schemas.dkcc._2003._02._13.CountryIdentificationCodeType;
import dk.oio.rep.xkom_dk.xml.schemas._2005._03._15.AddressAccessType;
import dk.oio.rep.xkom_dk.xml.schemas._2006._01._06.AddressPostalType;

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

			// Assigning person tilstand
			ITilstand newTilstand = getTilstande(laesOutput);
			builder.tilstand(newTilstand);
			
			// Assigning person relations
			IPersonRelationships newRelations = getAllPersonRelations(laesOutput);
			builder.relations(newRelations);
			
			// Assigning person attributes
			List<EgenskabType> personAttributes =
					laesOutput.getLaesResultat().getRegistrering().getAttributListe().getEgenskab();

			// Get the first from the list
			EgenskabType attributes = personAttributes.get(0);
			
			// Make certain the person has a name (unborn doesn't!)
			if(attributes != null &&
					attributes.getNavnStruktur() != null) {	

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

			}			
			// Get the gender
			String gender = attributes.getPersonGenderCode().name();
			if(gender != null) { builder.gender(gender); }
			
			// Get the birthdate
			XMLGregorianCalendar birthdate = attributes.getBirthDate();
			if(birthdate != null) { builder.birthdate(birthdate); }
			
			// Get the birthplace
			String birthplace = attributes.getFoedestedNavn();
			if(birthplace != null) { builder.birthplace(birthplace); }
		
			// Get the birthRegisteringAutherity
			String birthreg = attributes.getFoedselsregistreringMyndighedNavn();
			if(birthreg != null) { builder.birthRegisteringAuthority(birthreg); }	
			
			// Add the contact information
			IContact newContact = getContact(attributes.getKontaktKanal());
			builder.contact(newContact);
			
			// Add the next of kin contact information
			IContact newNextOfKinContact = getContact(attributes.getNaermestePaaroerende());
			builder.nextOfKinContact(newNextOfKinContact);
			
			// Add effect to the person
			IVirkning newEffect = getEffect(attributes.getVirkning());
			builder.effect(newEffect);
			
			
			////////////////////////
			// Get the registration information
			
			RegistreringType registering = laesOutput.getLaesResultat().getRegistrering();
			
			ITidspunkt tidspunkt = getRegisteringsTidspunkt(registering);
			
			builder.tidspunkt(tidspunkt);
			
			IRegisterInformation newRegInfo = getRegisterOplysning(registering);
			builder.registerInformation(newRegInfo);
			
			// Get the address information and add it to the person
			IAddress newAddress = getAddress(registering);
			builder.address(newAddress);
			
		}

		return builder.build();
	}

	private IRegisterInformation getRegisterOplysning(RegistreringType registering) {
		
		List<RegisterOplysningType> registerList = 
				registering.getAttributListe().getRegisterOplysning();

		// TODO make a guard check if the list has values
		RegisterOplysningType register = registerList.get(0);

		//// Make a builder
		CprCitizenData.Builder regInfoBuilder = new CprCitizenData.Builder();

		// Adding virkning to IRegisterInformation
		IVirkning regVirkning = getEffect(register.getVirkning());
		regInfoBuilder.virkning(regVirkning);
		
		// TODO make a guard check if the register has a cprCitizen
		CprBorgerType citizenData = register.getCprBorger();

		// Get social security information
		String socialSecurityNumber = citizenData.getPersonCivilRegistrationIdentifier();
		if(socialSecurityNumber != null) { regInfoBuilder.socialSecurityNumber(socialSecurityNumber); }
		
		// Get nationality code
		CountryIdentificationCodeType nationalityCode = citizenData.getPersonNationalityCode();
		if(nationalityCode != null) { regInfoBuilder.personNationalityCode(nationalityCode.getValue()); }

		// Is member of the church?
		Boolean isChurchMember = citizenData.isFolkekirkeMedlemIndikator();
		if (isChurchMember != null) { regInfoBuilder.isMemberOfTheChurch(isChurchMember); }

		// Has researcher protection?
		Boolean isResearcherProtected = citizenData.isForskerBeskyttelseIndikator();
		if (isResearcherProtected != null) { regInfoBuilder.isResearcherProtected(isResearcherProtected); }

		// Valid social security number?
		Boolean isCprValid = citizenData.isPersonNummerGyldighedStatusIndikator();
		if (isCprValid != null) { regInfoBuilder.isSocialSecurityNumberValid(isCprValid); }

		// Name/Address protection?
		Boolean isNameAddressProtected = citizenData.isNavneAdresseBeskyttelseIndikator();
		if (isNameAddressProtected != null) { regInfoBuilder.isNameAdressProtected(isNameAddressProtected); }

		// Name/Address protection?
		Boolean isPhoneNumberProtected = citizenData.isTelefonNummerBeskyttelseIndikator();
		if (isPhoneNumberProtected != null) { regInfoBuilder.isPhoneNumberProtected(isPhoneNumberProtected); }		
					
		// Return the register information data to the person
		return regInfoBuilder.build();
	}

	private ITilstand getTilstande(LaesOutputType laesOutput) {
		// Assigning PersonTilstand
		TilstandListeType personTilstandsListe =
				laesOutput.getLaesResultat().getRegistrering().getTilstandListe();
		
		// null check
		if(personTilstandsListe != null) {
			
			// make a builder
			Tilstand.Builder tilstandBuilder = new Tilstand.Builder();
			
			CivilStatusType civilStatus = personTilstandsListe.getCivilStatus();
			if(civilStatus != null) {
				if(civilStatus.getCivilStatusKode() != null) {
					tilstandBuilder.civilStatusKode(civilStatus.getCivilStatusKode().name());
				}
				if(civilStatus.getTilstandVirkning() != null) {
					IVirkning virkning = getTilstandVirkning(civilStatus.getTilstandVirkning());
					tilstandBuilder.civilTilstandsVirkning(virkning);
				}
			}
			
			LivStatusType livStatus = personTilstandsListe.getLivStatus();
			if(livStatus != null) {
				if(livStatus.getLivStatusKode() != null) {
					tilstandBuilder.livStatusKode(livStatus.getLivStatusKode().name());
				}
				
				if(livStatus.getTilstandVirkning() != null) {
					IVirkning virkning = getTilstandVirkning(livStatus.getTilstandVirkning());
					tilstandBuilder.livTilstandsVirkning(virkning);
				}
			}
			//return tilstand to person
			return tilstandBuilder.build();
		}
		return null;
	}

	
	/**
	 * Helper method to figure out what kind of address is attached,
	 * call the appropriate helper method to extract that data
	 * and return an instance of the the specific IAddress or
	 * null if there wasn't any information to extract
	 * 
	 * CAVEAT! CPR Broker doesn't return anything other than 
	 * DanskAdresseType, so this type is the mostlikely used.. 
	 * 
	 * @param RegistreringType
	 * @return IDanishAddress, IGreenlandicAddress, IWorldAddress or null
	 * 	
	 */
	private IAddress getAddress(RegistreringType registering) {
		
		List<RegisterOplysningType> registerList = 
				registering.getAttributListe().getRegisterOplysning();

		// TODO make a guard check if the list has values
		RegisterOplysningType register = registerList.get(0);
		
		// TODO make a guard check if the register has a cprCitizen
		CprBorgerType citizenData = register.getCprBorger();

		AdresseType address = citizenData.getFolkeregisterAdresse();
		
		if(address != null) {
			DanskAdresseType danishAddress = address.getDanskAdresse();
			GroenlandAdresseType greenlandicAddress= address.getGroenlandAdresse();
			VerdenAdresseType worldAddress = address.getVerdenAdresse();
			
			IAddress newAddress = null;
			
			// Is there a danish address or maybe a Greenlandic or maybe a world?!?
			if(danishAddress != null) {
				newAddress = getDanishAddress(citizenData);
			} else if (greenlandicAddress != null) {
				newAddress = getGreenlandicAddress(citizenData);
			} else if (worldAddress != null) {
				newAddress = getWorldAddress(citizenData);
			}
			
			return newAddress;
		}
		return null;
	}
	

	/**
	 * Helper method for getAddress used to extract a WorldAddressType
	 * @param citizenData CprBorgerType with the address information 
	 * @return IWorldAddress
	 */
	private IAddress getWorldAddress(CprBorgerType citizenData) {
	
		// get the address
		VerdenAdresseType worldAddress = citizenData.getFolkeregisterAdresse().getVerdenAdresse();
		
		// null guard
		if(worldAddress.getForeignAddressStructure() != null) {

			// Let build a bear.. err greenlandic address!
			WorldAddress.Builder addressBuilder = new WorldAddress.Builder();

			// Add any adress notes
			addressBuilder.note(citizenData.getAdresseNoteTekst());
			
			// reference pointer for less spam
			ForeignAddressStructureType addressPostal = worldAddress.getForeignAddressStructure();

			// Get country id code
			CountryIdentificationCodeType idCode = addressPostal.getCountryIdentificationCode();
			if(idCode != null) {addressBuilder.countryIdentificationCode(idCode.getValue()); }
		
			// Just build the rest
			addressBuilder.locationDescriptionText(addressPostal.getLocationDescriptionText())
							.postalAddressFirstLineText(addressPostal.getPostalAddressFirstLineText())
							.postalAddressSecondLineText(addressPostal.getPostalAddressSecondLineText())
							.postalAddressThirdLineText(addressPostal.getPostalAddressThirdLineText())
							.postalAddressFourthLineText(addressPostal.getPostalAddressFourthLineText())
							.postalAddressFifthLineText(addressPostal.getPostalAddressFifthLineText())
							.isUkendtAdresseIndikator(worldAddress.isUkendtAdresseIndikator());
							
			// return the address to the person
			return addressBuilder.build();
		}

		return null;
	}

	
	/**
	 * Helper method for getAddress used to extract a GreenlandicAddressType
	 * @param citizenData CprBorgerType with the address information 
	 * @return IGreenladicAddress
	 */
	private IAddress getGreenlandicAddress(CprBorgerType citizenData) {
		
		GroenlandAdresseType greenlandicAddress= citizenData.getFolkeregisterAdresse().getGroenlandAdresse();

		// null guard
		if(greenlandicAddress.getAddressCompleteGreenland() != null) {

			// Let build a bear.. err greenlandic address!
			GreenlandicAddress.Builder addressBuilder = new GreenlandicAddress.Builder();

			// Add any adress notes
			addressBuilder.note(citizenData.getAdresseNoteTekst());
			
			// reference pointer for less spam
			AddressCompleteGreenlandType addressPostal = greenlandicAddress.getAddressCompleteGreenland();

			// Get country id code
			CountryIdentificationCodeType idCode = addressPostal.getCountryIdentificationCode();
			if(idCode != null) {addressBuilder.countryIdentificationCode(idCode.getValue()); }
		
			// Just build the rest
			addressBuilder.districtName(addressPostal.getDistrictName())
						.districtSubdivision(addressPostal.getDistrictSubdivisionIdentifier())
						.floor(addressPostal.getFloorIdentifier())
						.greenlandBuilding(addressPostal.getGreenlandBuildingIdentifier())
						.mailDeliverySublocation(addressPostal.getMailDeliverySublocationIdentifier())
						.municipalityCode(addressPostal.getMunicipalityCode())
						.postCode(addressPostal.getPostCodeIdentifier())
						.streetBuilding(addressPostal.getStreetBuildingIdentifier())
						.streetCode(addressPostal.getStreetCode())
						.streetName(addressPostal.getStreetName())
						.streetNameForAddressing(addressPostal.getStreetNameForAddressingName())
						.suite(addressPostal.getSuiteIdentifier())
						.isSpecielVejkode(greenlandicAddress.isSpecielVejkodeIndikator())
						.isUkendtAdresse(greenlandicAddress.isUkendtAdresseIndikator());

			// add the address to the person
			return addressBuilder.build();
		}

		return null;

	}

	/**
	 * Helper method for getAddress used to extract a DanishAddressType
	 * @param citizenData CprBorgerType with the address information 
	 * @return IDanishAddress
	 */
	private IDanishAddress getDanishAddress(CprBorgerType citizenData) {

		DanskAdresseType danishAddress = citizenData.getFolkeregisterAdresse().getDanskAdresse();
		// null guard
		if(danishAddress.getAddressComplete() != null &&
				danishAddress.getAddressComplete().getAddressPostal() != null) {

			// Let build a bear.. err danish address!
			DanishAddress.Builder addressBuilder = new DanishAddress.Builder();

			// Add any adress notes
			addressBuilder.note(citizenData.getAdresseNoteTekst());
			
			// reference pointer for less spam
			AddressAccessType addressAccess = danishAddress.getAddressComplete().getAddressAccess();
			AddressPostalType addressPostal = danishAddress.getAddressComplete().getAddressPostal();

			if(addressPostal != null) {
				// Get country id code
				CountryIdentificationCodeType idCode = addressPostal.getCountryIdentificationCode();
				if(idCode != null) {addressBuilder.countryIdentificationCode(idCode.getValue()); }

				// Get postofficebox
				BigInteger postOfficeBox = addressPostal.getPostOfficeBoxIdentifier();
				if(postOfficeBox != null) {addressBuilder.postOfficeBox(addressPostal.getPostOfficeBoxIdentifier().toString()); }
				
				// Just build the rest
				addressBuilder.districtName(addressPostal.getDistrictName())
							.districtSubdivision(addressPostal.getDistrictSubdivisionIdentifier())
							.floor(addressPostal.getFloorIdentifier())
							.mailSubLocaltion(addressPostal.getMailDeliverySublocationIdentifier())
							.postCode(addressPostal.getPostCodeIdentifier())
							.streetBuilding(addressPostal.getStreetBuildingIdentifier())
							.streetName(addressPostal.getStreetName())
							.streetNameForAdressing(addressPostal.getStreetNameForAddressingName())
							.suite(addressPostal.getSuiteIdentifier());			
			}

			if(addressAccess != null) {
				addressBuilder.municipalityCode(addressAccess.getMunicipalityCode())
								.streetBuildingIdentifier(addressAccess.getStreetBuildingIdentifier())
								.streetCode(addressAccess.getStreetCode());
			}
			
			addressBuilder.danishNote(danishAddress.getNoteTekst())
							.politiDistrikt(danishAddress.getPolitiDistriktTekst())
							.postDistrikt(danishAddress.getPostDistriktTekst())
							.skoleDistrikt(danishAddress.getSkoleDistriktTekst())
							.socialDistrikt(danishAddress.getSocialDistriktTekst())
							.sogneDistrikt(danishAddress.getSogneDistriktTekst())
							.isSpecielVejkode(danishAddress.isSpecielVejkodeIndikator())
							.isUkendtAdresse(danishAddress.isUkendtAdresseIndikator());
			
			// add the address to the person
			return addressBuilder.build();
		}
		return null;
	}

	/**
	 * Helper method to extract TidspunktType
	 * @param registering RegistreringType
	 * @return An instance of the type ITidspunkt
	 */
	private ITidspunkt getRegisteringsTidspunkt(RegistreringType registering) {
		if(registering != null) {
			
			Tidspunkt.Builder tidspunktBuilder = new Tidspunkt.Builder();
			if(registering.getAktoerRef() != null) {
				
				tidspunktBuilder.aktoerRefUrn(registering.getAktoerRef().getURNIdentifikator())
								.aktoerRefUuid(registering.getAktoerRef().getUUID());
			}
			if(registering.getTidspunkt() != null) {
				tidspunktBuilder.tidspunkt(registering.getTidspunkt().getTidsstempelDatoTid())
				.isTidspunktGraenseIndikator(registering.getTidspunkt().isGraenseIndikator());					
			}
			if(registering.getLivscyklusKode() != null) {
				tidspunktBuilder.livscyklusKode(registering.getLivscyklusKode().name());
			}
			tidspunktBuilder.kommentar(registering.getCommentText());
								
			return tidspunktBuilder.build();
		}
		
		return null;
	}
	
	
	private IPersonRelationships getAllPersonRelations(LaesOutputType laesOutput) {
		RelationListeType personRelations =
				laesOutput.getLaesResultat().getRegistrering().getRelationListe();
		
		// yet another null check
		if(personRelations != null) {
			// Get builder
			PersonRelationships.Builder relationsBuilder = new PersonRelationships.Builder();

			// tmpList for reuse
			List<IRelationship> tmpRelationship;
			
			// Add PersonRelation
			tmpRelationship = getPersonRelation(personRelations.getAegtefaelle());
			relationsBuilder.aegtefaelle(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getErstatningAf());
			relationsBuilder.erstatingAf(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getFader());
			relationsBuilder.fader(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getForaeldremyndighedsindehaver());
			relationsBuilder.foraeldremyndighedsindehaver(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getModer());
			relationsBuilder.moder(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getRegistreretPartner());
			relationsBuilder.registreretPartner(tmpRelationship);
			
			tmpRelationship = getPersonRelation(personRelations.getRetligHandleevneVaergeForPersonen());
			relationsBuilder.retligHandleevneVaergeForPersonen(tmpRelationship);
			
			// Add PersonFlerRelation
			tmpRelationship = getPersonFlerRelation(personRelations.getBoern());
			relationsBuilder.boern(tmpRelationship);
			
			tmpRelationship = getPersonFlerRelation(personRelations.getBopaelssamling());
			relationsBuilder.bopaelssamling(tmpRelationship);

			tmpRelationship = getPersonFlerRelation(personRelations.getErstatningFor());
			relationsBuilder.erstatingFor(tmpRelationship);

			tmpRelationship = getPersonFlerRelation(personRelations.getForaeldremyndighedsboern());
			relationsBuilder.foraeldremydighedsboern(tmpRelationship);

			tmpRelationship = getPersonFlerRelation(personRelations.getRetligHandleevneVaergemaalsindehaver());
			relationsBuilder.retligHandleevneVaergemaalsindehaver(tmpRelationship);
		
			// return the relations to the person
			return relationsBuilder.build();
			
		}
		return null;
	}
	
	private List<IRelationship> getPersonFlerRelation(List<PersonFlerRelationType> relations) {
		
		if(!relations.isEmpty()) {
			
			// Make a new list
			List<IRelationship> list = new LinkedList<IRelationship>();
			
			// iterate the relations
			for(PersonFlerRelationType relation : relations) {
				// get builder - NOTICE SINGULAR!
				Relationship.Builder relationBuilder = new Relationship.Builder();
			
				relationBuilder.comment(relation.getCommentText());
				
				if(relation.getReferenceID() != null) {
					relationBuilder.referenceUrn(relation.getReferenceID().getURNIdentifikator())
									.referenceUuid(relation.getReferenceID().getUUID());
				}
				// Add effect to the person
				IVirkning newEffect = getEffect(relation.getVirkning());
				relationBuilder.effect(newEffect);								
				
				// add the new relation to the list
				list.add(relationBuilder.build());
				
			}
			
			// return the results
			return list;
		}
		
		return null;
	}


	private List<IRelationship> getPersonRelation(List<PersonRelationType> relations) {
		
		if(!relations.isEmpty()) {
			
			// Make a new list
			List<IRelationship> list = new LinkedList<IRelationship>();
			
			// iterate the relations
			for(PersonRelationType relation : relations) {
				// get builder - NOTICE SINGULAR!
				Relationship.Builder relationBuilder = new Relationship.Builder();
			
				relationBuilder.comment(relation.getCommentText());
				
				if(relation.getReferenceID() != null) {
					relationBuilder.referenceUrn(relation.getReferenceID().getURNIdentifikator())
									.referenceUuid(relation.getReferenceID().getUUID());
				}
				// Add effect to the person
				IVirkning newEffect = getEffect(relation.getVirkning());
				relationBuilder.effect(newEffect);								
				
				// add the new relation to the list
				list.add(relationBuilder.build());
				
			}
			
			// return the results
			return list;
		}
		
		return null;
	}

	
	
	private IVirkning getTilstandVirkning(TilstandVirkningType virkningType) {

		if(virkningType != null) {
			// Lets build
			Virkning.Builder effectBuilder = new Virkning.Builder();
			
			UnikIdType actor = virkningType.getAktoerRef();
			
			if(actor != null) {
				effectBuilder.actorUrn(actor.getURNIdentifikator())
							 .actorUuid(actor.getUUID());
			}
			
			if(virkningType.getFraTidspunkt() != null) {
				effectBuilder.effectiveFromDate(virkningType.getFraTidspunkt().getTidsstempelDatoTid())
							 .isEffectiveFromLimit(virkningType.getFraTidspunkt().isGraenseIndikator());
			}
			
			effectBuilder.comment(virkningType.getCommentText());
			
			//Return IEffect
			return effectBuilder.build();
		}
		
		return null;
	}
	
	private IVirkning getEffect(VirkningType virkningType) {

		if(virkningType != null) {
			// Lets build
			Virkning.Builder effectBuilder = new Virkning.Builder();
			
			UnikIdType actor = virkningType.getAktoerRef();
			
			if(actor != null) {
				effectBuilder.actorUrn(actor.getURNIdentifikator())
							 .actorUuid(actor.getUUID());
			}
			
			if(virkningType.getFraTidspunkt() != null) {
				effectBuilder.effectiveFromDate(virkningType.getFraTidspunkt().getTidsstempelDatoTid())
							 .isEffectiveFromLimit(virkningType.getFraTidspunkt().isGraenseIndikator());
			}
			
			if(virkningType.getTilTidspunkt() != null) {
				effectBuilder.effectiveToDate(virkningType.getTilTidspunkt().getTidsstempelDatoTid())
							 .isEffectiveToLimit(virkningType.getTilTidspunkt().isGraenseIndikator());
			}
			
			effectBuilder.comment(virkningType.getCommentText());
			
			//Return IEffect
			return effectBuilder.build();
		}
		
		return null;
	}

	/**
	 * @param builder Instance of Person.Builder
	 * @param contact 
	 * @param isNextOfKin is it a next of kin contact or not?
	 * @return 
	 */
	private IContact getContact(KontaktKanalType contact) {
		
		if(contact != null) {
			//Lets build
			Contact.Builder contactBuilder = new Contact.Builder();
			
			contactBuilder.email(contact.getEmailAddressIdentifier())
										.limitedUsageText(contact.getBegraensetAnvendelseTekst())
										.noteText(contact.getNoteTekst());
			
			if(contact.getAndenKontaktKanal() != null) {
				AndenKontaktKanalType otherContact = contact.getAndenKontaktKanal();
				
				contactBuilder.otherContactNoteText(otherContact.getNoteTekst())
								.otherContactText(otherContact.getKontaktKanalTekst());
			}
							
			if(contact.getTelefon() != null) { 
				contactBuilder.phone(contact.getTelefon().getTelephoneNumberIdentifier())
							  .isPhoneAbleToRecieveSms(contact.getTelefon().isKanBrugesTilSmsIndikator());
			}

			return contactBuilder.build();
		}
		
		return null;
	}

}
