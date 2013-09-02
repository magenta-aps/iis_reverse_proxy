package util.cprbroker.jaxws;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import itst.dk.PartSoap12;
import oio.sagdok._2_0.LaesInputType;
import oio.sagdok._2_0.LokalUdvidelseType;
import oio.sagdok._2_0.PersonFlerRelationType;
import oio.sagdok._2_0.StandardReturType;
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
import oio.sagdok.person._1_0.RelationListeType;
import oio.sagdok.person._1_0.TilstandListeType;
import oio.sagdok.person._1_0.VerdenAdresseType;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.IVirkning;
import util.cprbroker.IPerson;
import util.cprbroker.IRelationship;
import util.cprbroker.IUuid;
import util.cprbroker.models.Contact;
import util.cprbroker.models.CprCitizenData;
import util.cprbroker.models.DanishAddress;
import util.cprbroker.models.Person;
import util.cprbroker.models.PersonRelationships;
import util.cprbroker.models.Relationship;
import util.cprbroker.models.Tilstand;
import util.cprbroker.models.Uuid;
import util.cprbroker.models.Virkning;
import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;
import dk.oio.rep.ebxml.xml.schemas.dkcc._2003._02._13.CountryIdentificationCodeType;
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
		
		/*		
		laesOutput.getLaesResultat().getRegistrering().getAktoerRef().getURNIdentifikator();
		laesOutput.getLaesResultat().getRegistrering().getAktoerRef().getUUID();
		laesOutput.getLaesResultat().getRegistrering().getCommentText();
		laesOutput.getLaesResultat().getRegistrering().getTidspunkt().getTidsstempelDatoTid();
		laesOutput.getLaesResultat().getRegistrering().getTidspunkt().isGraenseIndikator();
		
		
		laesOutput.getLaesResultat().getRegistrering().getAttributListe().getEgenskab();
		laesOutput.getLaesResultat().getRegistrering().getAttributListe().getLokalUdvidelse();
		laesOutput.getLaesResultat().getRegistrering().getAttributListe().getRegisterOplysning();
		laesOutput.getLaesResultat().getRegistrering().getAttributListe().getSundhedOplysning();

		List<VirkningType> effect = laesOutput.getLaesResultat().getRegistrering().getVirkning();
		*/
		
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
				//Add tilstand to person
				builder.tilstand(tilstandBuilder.build());
			}
			
			// Assigning person relations
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
			
				// add the relations to the person
				builder.relations(relationsBuilder.build());
				
			}
			
			
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
			//DanskAdresseType danskAdresse = attributes.getAndreAdresser().getDanskAdresse();
			//GroenlandAdresseType groenlandskAdresse = attributes.getAndreAdresser().getGroenlandAdresse();
			//VerdenAdresseType verdensAdresse = attributes.getAndreAdresser().getVerdenAdresse();
			
			// Add the contact information
			addContact(builder, attributes.getKontaktKanal(), false);
			
			// Add the next of kin contact information
			addContact(builder, attributes.getNaermestePaaroerende(), true);

			// Add effect to the person
			IVirkning newEffect = getEffect(attributes.getVirkning());
			builder.effect(newEffect);
			
			
			////////////////////////
			// Get the registration information
			List<RegisterOplysningType> registerList = 
					laesOutput.getLaesResultat().getRegistrering().getAttributListe().getRegisterOplysning();

			// TODO make a guard check if the list has values
			RegisterOplysningType register = registerList.get(0);

			// TODO add IEffect (virkning) to the IRegisterInformation
			// register.getVirkning();
			
			// TODO make a guard check if the register has a cprCitizen
			CprBorgerType citizenData = register.getCprBorger();
			// Make a builder
			CprCitizenData.Builder regInfoBuilder = new CprCitizenData.Builder();

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
			
			AdresseType address = citizenData.getFolkeregisterAdresse();
			if(address != null) {
				DanskAdresseType danishAddress = address.getDanskAdresse();
				// TODO Add world, greenlandic address
				GroenlandAdresseType greenlandicAddress= address.getGroenlandAdresse();
				VerdenAdresseType worldAddress = address.getVerdenAdresse();
				
				// Is there a danish address?
				if(danishAddress != null) {
					
					// null guard
					if(danishAddress.getAddressComplete() != null &&
							danishAddress.getAddressComplete().getAddressPostal() != null) {

						// Let build a bear.. err danish address!
						DanishAddress.Builder addressBuilder = new DanishAddress.Builder();

						// reference pointer for less spam
						AddressPostalType addressPostal = danishAddress.getAddressComplete().getAddressPostal();

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

						// add the address to the person
						builder.address(addressBuilder.build());
					}
					
				}
				
			}
			// Add the register information data to the person
			builder.registerInformation(regInfoBuilder.build());
						
			//TODO Get rid of this mess
			citizenData.getAdresseNoteTekst();
						
		}

		return builder.build();
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
	 * Not actually a part of the CPR standard, so a lot of nothings
	 * @param builder Instance of Person.Builder
	 * @param contact 
	 * @param isNextOfKin is it a next of kin contact or not?
	 */
	private void addContact(Person.Builder builder, KontaktKanalType contact, boolean isNextOfKin) {
		
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

			// Add the contact information to the person
			if(isNextOfKin) {
				builder.nextOfKinContact(contactBuilder.build());
			} else {
				builder.contact(contactBuilder.build());	
			}
		}
	}

}
