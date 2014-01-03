
package dk.oio.rep.bbr_dk.xml.schemas._2006._09._30;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressCoordinateQualityClassCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressCoordinateQualityClassCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="U"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressCoordinateQualityClassCodeType")
@XmlEnum
public enum AddressCoordinateQualityClassCodeType {

    A,
    B,
    U;

    public String value() {
        return name();
    }

    public static AddressCoordinateQualityClassCodeType fromValue(String v) {
        return valueOf(v);
    }

}
