
package dk.oio.rep.ebxml.xml.schemas.dkcc._2006._01._23;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonGenderCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PersonGenderCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="male"/>
 *     &lt;enumeration value="female"/>
 *     &lt;enumeration value="unspecified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PersonGenderCodeType", namespace = "http://rep.oio.dk/ebxml/xml/schemas/dkcc/2006/01/23/")
@XmlEnum
public enum PersonGenderCodeType {

    @XmlEnumValue("male")
    MALE("male"),
    @XmlEnumValue("female")
    FEMALE("female"),
    @XmlEnumValue("unspecified")
    UNSPECIFIED("unspecified");
    private final String value;

    PersonGenderCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonGenderCodeType fromValue(String v) {
        for (PersonGenderCodeType c: PersonGenderCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
