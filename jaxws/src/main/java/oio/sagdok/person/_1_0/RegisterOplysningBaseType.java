
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterOplysningBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterOplysningBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="UdenlandskBorger" type="{urn:oio:sagdok:person:1.0.0}UdenlandskBorgerType" minOccurs="0"/>
 *           &lt;element name="UkendtBorger" type="{urn:oio:sagdok:person:1.0.0}UkendtBorgerType" minOccurs="0"/>
 *           &lt;element name="CprBorger" type="{urn:oio:sagdok:person:1.0.0}CprBorgerType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterOplysningBaseType", propOrder = {
    "udenlandskBorger",
    "ukendtBorger",
    "cprBorger"
})
@XmlSeeAlso({
    RegisterOplysningType.class
})
public class RegisterOplysningBaseType {

    @XmlElement(name = "UdenlandskBorger")
    protected UdenlandskBorgerType udenlandskBorger;
    @XmlElement(name = "UkendtBorger")
    protected UkendtBorgerType ukendtBorger;
    @XmlElement(name = "CprBorger")
    protected CprBorgerType cprBorger;

    /**
     * Gets the value of the udenlandskBorger property.
     * 
     * @return
     *     possible object is
     *     {@link UdenlandskBorgerType }
     *     
     */
    public UdenlandskBorgerType getUdenlandskBorger() {
        return udenlandskBorger;
    }

    /**
     * Sets the value of the udenlandskBorger property.
     * 
     * @param value
     *     allowed object is
     *     {@link UdenlandskBorgerType }
     *     
     */
    public void setUdenlandskBorger(UdenlandskBorgerType value) {
        this.udenlandskBorger = value;
    }

    /**
     * Gets the value of the ukendtBorger property.
     * 
     * @return
     *     possible object is
     *     {@link UkendtBorgerType }
     *     
     */
    public UkendtBorgerType getUkendtBorger() {
        return ukendtBorger;
    }

    /**
     * Sets the value of the ukendtBorger property.
     * 
     * @param value
     *     allowed object is
     *     {@link UkendtBorgerType }
     *     
     */
    public void setUkendtBorger(UkendtBorgerType value) {
        this.ukendtBorger = value;
    }

    /**
     * Gets the value of the cprBorger property.
     * 
     * @return
     *     possible object is
     *     {@link CprBorgerType }
     *     
     */
    public CprBorgerType getCprBorger() {
        return cprBorger;
    }

    /**
     * Sets the value of the cprBorger property.
     * 
     * @param value
     *     allowed object is
     *     {@link CprBorgerType }
     *     
     */
    public void setCprBorger(CprBorgerType value) {
        this.cprBorger = value;
    }

}
