
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UkendtBorgerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UkendtBorgerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://rep.oio.dk/cpr.dk/xml/schemas/2007/01/02/}PersonCivilRegistrationReplacementIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UkendtBorgerType", propOrder = {
    "personCivilRegistrationReplacementIdentifier"
})
public class UkendtBorgerType {

    @XmlElement(name = "PersonCivilRegistrationReplacementIdentifier", namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/2007/01/02/")
    protected String personCivilRegistrationReplacementIdentifier;

    /**
     * Gets the value of the personCivilRegistrationReplacementIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonCivilRegistrationReplacementIdentifier() {
        return personCivilRegistrationReplacementIdentifier;
    }

    /**
     * Sets the value of the personCivilRegistrationReplacementIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonCivilRegistrationReplacementIdentifier(String value) {
        this.personCivilRegistrationReplacementIdentifier = value;
    }

}
