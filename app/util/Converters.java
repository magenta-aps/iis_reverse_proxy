package util;

import dk.oio.rep.itst_dk.xml.schemas._2006._01._17.PersonNameStructureType;
import dk.oio.rep.xkom_dk.xml.schemas._2005._03._15.AddressAccessType;
import dk.oio.rep.xkom_dk.xml.schemas._2006._01._06.AddressCompleteType;
import dk.oio.rep.xkom_dk.xml.schemas._2006._01._06.AddressPostalType;
import oio.sagdok.person._1_0.*;
import scala.util.parsing.combinator.testing.Str;

import java.util.List;

/**
 * Created by Beemen on 11/11/2014.
 */
public class Converters {
    public AdresseType ToAddressType(String addressString) {
        if(addressString!=null && !!addressString.trim().isEmpty()) {

            String streetName=null, houseNumber=null, floor=null, door=null, postCode=null, postDistrict=null;
            String[] lines = addressString.split("[\r\n]");

            // First line
            String streetAddress = lines[0];

            streetName = streetAddress.split("( +[0-9])?")[0];
            String[] afterStreetName = streetAddress.substring(streetName.length()).split(" ");

            if(afterStreetName.length > 0)
                houseNumber= afterStreetName[0];

            if(afterStreetName.length > 1)
                floor= afterStreetName[1];

            if(afterStreetName.length > 2)
                door= afterStreetName[2];

            // Second line
            if(lines.length > 1){
                String[] postParts = lines[1].trim().split(" ");
                postCode = postParts[0];
                postDistrict = postParts[1];
            }

            AdresseType ret = new AdresseType();
            DanskAdresseType danskAdresse = new DanskAdresseType();
            ret.setDanskAdresse(danskAdresse);

            AddressCompleteType addressComplete = new AddressCompleteType();
            danskAdresse.setAddressComplete(addressComplete);

            AddressAccessType addressAccess =new AddressAccessType();
            addressAccess.setStreetBuildingIdentifier(houseNumber);
            addressComplete.setAddressAccess(addressAccess);

            AddressPostalType addressPostal = new AddressPostalType();
            addressPostal.setStreetName(streetName);
            addressPostal.setFloorIdentifier(floor);
            addressPostal.setSuiteIdentifier(door);
            addressComplete.setAddressPostal(addressPostal);

            return ret;
        }
        return null;
    }

    public NavnStrukturType ToNavnStrukturType(String firstname, String middlename, String lastname) {
        // Set the name search criteria
        PersonNameStructureType nameStructure = new PersonNameStructureType();
        nameStructure.setPersonGivenName(firstname);
        nameStructure.setPersonMiddleName(middlename);
        nameStructure.setPersonSurnameName(lastname);

        // Playing the matryoshka doll game
        NavnStrukturType navnStrukturType = new NavnStrukturType();
        navnStrukturType.setPersonNameStructure(nameStructure);
        return navnStrukturType;
    }

    public SoegObjektType ToSoegObjektType(String firstname, String middlename, String lastname, String address){

        NavnStrukturType navnStrukturType = ToNavnStrukturType(firstname, middlename, lastname);
        AdresseType addressObject = ToAddressType(address);

        SoegAttributListeType soegAttributListeType = new SoegAttributListeType();

        // Now fill Egenskab & registerOplysning
        SoegEgenskabType soegEgenskabType = new SoegEgenskabType();
        soegEgenskabType.setNavnStruktur(navnStrukturType);
        soegAttributListeType.getSoegEgenskab().add(soegEgenskabType);

        if(addressObject != null){
            RegisterOplysningType registerOplysningType = new RegisterOplysningType();

            CprBorgerType cprBorgerType = new CprBorgerType();
            cprBorgerType.setFolkeregisterAdresse(addressObject);
            registerOplysningType.setCprBorger(cprBorgerType);

            soegAttributListeType.getSoegRegisterOplysning().add(registerOplysningType);
        }

        SoegObjektType soegObjekt = new SoegObjektType();
        soegObjekt.setSoegAttributListe(soegAttributListeType);

        return soegObjekt;
    }


}
