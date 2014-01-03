
package dk.oio.rep.ebxml.xml.schemas.dkcc._2003._02._13;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for _CountryIdentificationSchemeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="_CountryIdentificationSchemeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="iso3166-alpha2"/>
 *     &lt;enumeration value="iso3166-alpha3"/>
 *     &lt;enumeration value="un-numeric3"/>
 *     &lt;enumeration value="imk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "_CountryIdentificationSchemeType")
@XmlEnum
public enum CountryIdentificationSchemeType {

    @XmlEnumValue("iso3166-alpha2")
    ISO_3166_ALPHA_2("iso3166-alpha2"),
    @XmlEnumValue("iso3166-alpha3")
    ISO_3166_ALPHA_3("iso3166-alpha3"),
    @XmlEnumValue("un-numeric3")
    UN_NUMERIC_3("un-numeric3"),
    @XmlEnumValue("imk")
    IMK("imk");
    private final String value;

    CountryIdentificationSchemeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CountryIdentificationSchemeType fromValue(String v) {
        for (CountryIdentificationSchemeType c: CountryIdentificationSchemeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
