package util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import oio.sagdok.person._1_0.AdresseType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scala.util.parsing.combinator.testing.Str;


import static org.junit.Assert.*;

/**
 * Created by Beemen on 12/11/2014.
 */
@RunWith(JUnitParamsRunner.class)
public class ConvertersTest {

    String streetName = "Studiestraede";
    String houseNumber = "14";
    String floor = "1";
    String door = "";
    String postCode = "1455";
    String postDist = "København K";

    public void AssertCorrectness(AdresseType adresseType){
        assertEquals("Street name", streetName, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getStreetName());

        assertEquals("House", houseNumber, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getStreetBuildingIdentifier());
        assertEquals("House", houseNumber, adresseType.getDanskAdresse().getAddressComplete().getAddressAccess().getStreetBuildingIdentifier());

        assertEquals("Floor", floor, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getFloorIdentifier());
        assertEquals("Door",door, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getSuiteIdentifier());
        assertEquals("Post code",postCode, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getPostCodeIdentifier());
        assertEquals("Post text",postDist, adresseType.getDanskAdresse().getAddressComplete().getAddressPostal().getDistrictName());
    }

    @Test
    @Parameters({
            // streetName house floor door postCode postTxt
            "{0} {1} {2} {3} {4} {5}",
            "{0} {1} {2} {3}\r\n{4} {5}"})
    public void ToAddress_NormalOneLine_Correct(String format){
        Converters conv = new Converters();
        String adr = String.format(format,streetName,houseNumber,floor,door,postCode,postDist);
        AdresseType adresseType = conv.ToAddressType(adr);
        this.AssertCorrectness(adresseType);
    }

    public static void main(){
        String[] formats = new String[]{"{0} {1} {2} {3} {4} {5}",
                "{0} {1} {2} {3}\r\n{4} {5}"};

    }

}
