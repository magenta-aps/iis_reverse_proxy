
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelefonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelefonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://rep.oio.dk/itst.dk/xml/schemas/2005/01/10/}TelephoneNumberIdentifier" minOccurs="0"/>
 *         &lt;element name="KanBrugesTilSmsIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelefonType", propOrder = {
    "telephoneNumberIdentifier",
    "kanBrugesTilSmsIndikator"
})
public class TelefonType {

    @XmlElement(name = "TelephoneNumberIdentifier", namespace = "http://rep.oio.dk/itst.dk/xml/schemas/2005/01/10/")
    protected String telephoneNumberIdentifier;
    @XmlElement(name = "KanBrugesTilSmsIndikator")
    protected boolean kanBrugesTilSmsIndikator;

    /**
     * Gets the value of the telephoneNumberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephoneNumberIdentifier() {
        return telephoneNumberIdentifier;
    }

    /**
     * Sets the value of the telephoneNumberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephoneNumberIdentifier(String value) {
        this.telephoneNumberIdentifier = value;
    }

    /**
     * Gets the value of the kanBrugesTilSmsIndikator property.
     * 
     */
    public boolean isKanBrugesTilSmsIndikator() {
        return kanBrugesTilSmsIndikator;
    }

    /**
     * Sets the value of the kanBrugesTilSmsIndikator property.
     * 
     */
    public void setKanBrugesTilSmsIndikator(boolean value) {
        this.kanBrugesTilSmsIndikator = value;
    }

}
