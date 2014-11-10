
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.GetUuidArrayOutputType;
import oio.sagdok.person._1_0.GetUuidOutputType;
import oio.sagdok.person._1_0.LaesOutputType;
import oio.sagdok.person._1_0.OpretOutputType;
import oio.sagdok.person._1_0.RegistreringOutputType;


/**
 * <p>Java class for BasicOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasicOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StandardRetur" type="{urn:oio:sagdok:2.0.0}StandardReturType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicOutputType", propOrder = {
    "standardRetur"
})
@XmlSeeAlso({
    LaesOutputType.class,
    GetUuidOutputType.class,
    RegistreringOutputType.class,
    OpretOutputType.class,
    GetUuidArrayOutputType.class
})
public class BasicOutputType {

    @XmlElement(name = "StandardRetur")
    protected StandardReturType standardRetur;

    /**
     * Gets the value of the standardRetur property.
     * 
     * @return
     *     possible object is
     *     {@link StandardReturType }
     *     
     */
    public StandardReturType getStandardRetur() {
        return standardRetur;
    }

    /**
     * Sets the value of the standardRetur property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardReturType }
     *     
     */
    public void setStandardRetur(StandardReturType value) {
        this.standardRetur = value;
    }

}
