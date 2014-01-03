
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LivscyklusKodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LivscyklusKodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Opstaaet"/>
 *     &lt;enumeration value="Importeret"/>
 *     &lt;enumeration value="Passiveret"/>
 *     &lt;enumeration value="Slettet"/>
 *     &lt;enumeration value="Rettet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LivscyklusKodeType")
@XmlEnum
public enum LivscyklusKodeType {

    @XmlEnumValue("Opstaaet")
    OPSTAAET("Opstaaet"),
    @XmlEnumValue("Importeret")
    IMPORTERET("Importeret"),
    @XmlEnumValue("Passiveret")
    PASSIVERET("Passiveret"),
    @XmlEnumValue("Slettet")
    SLETTET("Slettet"),
    @XmlEnumValue("Rettet")
    RETTET("Rettet");
    private final String value;

    LivscyklusKodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LivscyklusKodeType fromValue(String v) {
        for (LivscyklusKodeType c: LivscyklusKodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
