
package itst.dk;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SourceUsageOrder.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SourceUsageOrder">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LocalOnly"/>
 *     &lt;enumeration value="LocalThenExternal"/>
 *     &lt;enumeration value="ExternalOnly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SourceUsageOrder")
@XmlEnum
public enum SourceUsageOrder {

    @XmlEnumValue("LocalOnly")
    LOCAL_ONLY("LocalOnly"),
    @XmlEnumValue("LocalThenExternal")
    LOCAL_THEN_EXTERNAL("LocalThenExternal"),
    @XmlEnumValue("ExternalOnly")
    EXTERNAL_ONLY("ExternalOnly");
    private final String value;

    SourceUsageOrder(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceUsageOrder fromValue(String v) {
        for (SourceUsageOrder c: SourceUsageOrder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
