
package itst.dk;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for SourceUsageOrderHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceUsageOrderHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceUsageOrder" type="{http://dk.itst}SourceUsageOrder"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceUsageOrderHeader", propOrder = {
    "sourceUsageOrder"
})
public class SourceUsageOrderHeader {

    @XmlElement(name = "SourceUsageOrder", required = true, nillable = true)
    protected SourceUsageOrder sourceUsageOrder;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the sourceUsageOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SourceUsageOrder }
     *     
     */
    public SourceUsageOrder getSourceUsageOrder() {
        return sourceUsageOrder;
    }

    /**
     * Sets the value of the sourceUsageOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceUsageOrder }
     *     
     */
    public void setSourceUsageOrder(SourceUsageOrder value) {
        this.sourceUsageOrder = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
