
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KontaktKanalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KontaktKanalType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:person:1.0.0}KontaktKanalBaseType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Telefon" type="{urn:oio:sagdok:person:1.0.0}TelefonType" minOccurs="0"/>
 *           &lt;element ref="{http://rep.oio.dk/xkom.dk/xml/schemas/2005/03/15/}EmailAddressIdentifier" minOccurs="0"/>
 *           &lt;element name="AndenKontaktKanal" type="{urn:oio:sagdok:person:1.0.0}AndenKontaktKanalType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KontaktKanalType", propOrder = {
    "telefon",
    "emailAddressIdentifier",
    "andenKontaktKanal"
})
public class KontaktKanalType
    extends KontaktKanalBaseType
{

    @XmlElement(name = "Telefon")
    protected TelefonType telefon;
    @XmlElement(name = "EmailAddressIdentifier", namespace = "http://rep.oio.dk/xkom.dk/xml/schemas/2005/03/15/")
    protected String emailAddressIdentifier;
    @XmlElement(name = "AndenKontaktKanal")
    protected AndenKontaktKanalType andenKontaktKanal;

    /**
     * Gets the value of the telefon property.
     * 
     * @return
     *     possible object is
     *     {@link TelefonType }
     *     
     */
    public TelefonType getTelefon() {
        return telefon;
    }

    /**
     * Sets the value of the telefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelefonType }
     *     
     */
    public void setTelefon(TelefonType value) {
        this.telefon = value;
    }

    /**
     * Gets the value of the emailAddressIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddressIdentifier() {
        return emailAddressIdentifier;
    }

    /**
     * Sets the value of the emailAddressIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddressIdentifier(String value) {
        this.emailAddressIdentifier = value;
    }

    /**
     * Gets the value of the andenKontaktKanal property.
     * 
     * @return
     *     possible object is
     *     {@link AndenKontaktKanalType }
     *     
     */
    public AndenKontaktKanalType getAndenKontaktKanal() {
        return andenKontaktKanal;
    }

    /**
     * Sets the value of the andenKontaktKanal property.
     * 
     * @param value
     *     allowed object is
     *     {@link AndenKontaktKanalType }
     *     
     */
    public void setAndenKontaktKanal(AndenKontaktKanalType value) {
        this.andenKontaktKanal = value;
    }

}
