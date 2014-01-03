
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.dkal._1_0.ArrayOfString;


/**
 * <p>Java class for SoegOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StandardRetur" type="{urn:oio:sagdok:2.0.0}StandardReturType" minOccurs="0"/>
 *         &lt;element ref="{urn:oio:sagdok:1.0.0}Idliste" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegOutputType", propOrder = {
    "standardRetur",
    "idliste"
})
public class SoegOutputType {

    @XmlElement(name = "StandardRetur")
    protected StandardReturType standardRetur;
    @XmlElement(name = "Idliste", namespace = "urn:oio:sagdok:1.0.0")
    protected ArrayOfString idliste;

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

    /**
     * Gets the value of the idliste property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getIdliste() {
        return idliste;
    }

    /**
     * Sets the value of the idliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setIdliste(ArrayOfString value) {
        this.idliste = value;
    }

}
