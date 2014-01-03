
package itst.dk;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QualityLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QualityLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cpr"/>
 *     &lt;enumeration value="DataProvider"/>
 *     &lt;enumeration value="LocalCache"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QualityLevel")
@XmlEnum
public enum QualityLevel {

    @XmlEnumValue("Cpr")
    CPR("Cpr"),
    @XmlEnumValue("DataProvider")
    DATA_PROVIDER("DataProvider"),
    @XmlEnumValue("LocalCache")
    LOCAL_CACHE("LocalCache");
    private final String value;

    QualityLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QualityLevel fromValue(String v) {
        for (QualityLevel c: QualityLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
