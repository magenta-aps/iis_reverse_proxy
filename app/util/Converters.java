package util;

import dk.oio.rep.itst_dk.xml.schemas._2006._01._17.PersonNameStructureType;
import dk.oio.rep.xkom_dk.xml.schemas._2005._03._15.AddressAccessType;
import dk.oio.rep.xkom_dk.xml.schemas._2006._01._06.AddressCompleteType;
import dk.oio.rep.xkom_dk.xml.schemas._2006._01._06.AddressPostalType;
import oio.sagdok.person._1_0.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Beemen on 11/11/2014.
 */
public class Converters {
    public AdresseType ToAddressType(String addressString) {
        if (addressString != null && !addressString.trim().isEmpty()) {

            String comma = "((\\s+)|(\\s*[,;\\.]{1}\\s*))";
            String pat = "(?<streetName>[^0-9]+)" + comma
                    + "(?<houseNumber>[0-9]+[a-zA-Z]*)" + comma
                    + "(" + "(?<floor>[0-9]{1,2})?(\\.)?(sal)?" + comma + ")?"
                    + "(" + "(?<door>[a-zA-Z]+)" + comma + ")?"
                    + "(?<postCode>[0-9]{4})" + comma
                    + "(?<postDistrict>\\p{L}+(\\s+\\p{L}+)*)\\Z";


            Pattern p = Pattern.compile(pat);
            Matcher m = p.matcher(addressString);
            if (m.matches()) {

                String streetName = null, houseNumber = null, floor = null, door = null, postCode = null, postDistrict = null;

                streetName = m.group("streetName");
                houseNumber = m.group("houseNumber");
                floor = m.group("floor");
                door = m.group("door");
                postCode = m.group("postCode");
                postDistrict = m.group("postDistrict");

                AdresseType ret = new AdresseType();
                DanskAdresseType danskAdresse = new DanskAdresseType();
                ret.setDanskAdresse(danskAdresse);

                AddressCompleteType addressComplete = new AddressCompleteType();
                danskAdresse.setAddressComplete(addressComplete);

                AddressAccessType addressAccess = new AddressAccessType();
                addressAccess.setStreetBuildingIdentifier(houseNumber);
                addressComplete.setAddressAccess(addressAccess);

                AddressPostalType addressPostal = new AddressPostalType();
                addressPostal.setStreetName(streetName);
                addressPostal.setFloorIdentifier(floor);
                addressPostal.setSuiteIdentifier(door);
                addressPostal.setPostCodeIdentifier(postCode);
                addressComplete.setAddressPostal(addressPostal);

                return ret;
            }
        }
        return null;
    }

    public NavnStrukturType ToNavnStrukturType(String name) {

        if (name == null || name.isEmpty())
            return null;

        while (name.contains(",")) {
            int i = name.lastIndexOf(",");
            name = name.substring(i + 1) + " " + name.substring(0, i - 1);
        }

        String firstName = null, middleName = null, lastName = null;
        String[] arr = name.split(" ");
        if (arr.length >= 1)
            firstName = arr[0];
        if (arr.length > 1)
            lastName = arr[arr.length - 1];
        if (arr.length > 2) {
            middleName = "";
            ArrayList<String> middleNames = new ArrayList<String>();
            for (int i = 1; i < arr.length - 1; i++) {
                middleNames.add(arr[i]);
            }
            middleName = String.join(" ", middleNames);
        }
        return ToNavnStrukturType(firstName, middleName, lastName);
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

    public SoegObjektType ToSoegObjektType(String name, String address) {

        NavnStrukturType navnStrukturType = ToNavnStrukturType(name);
        AdresseType addressObject = ToAddressType(address);

        SoegAttributListeType soegAttributListeType = new SoegAttributListeType();

        // Now fill Egenskab & registerOplysning
        SoegEgenskabType soegEgenskabType = new SoegEgenskabType();
        soegEgenskabType.setNavnStruktur(navnStrukturType);
        soegAttributListeType.getSoegEgenskab().add(soegEgenskabType);

        if (addressObject != null) {
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
