
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AndenKontaktKanalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AndenKontaktKanalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}NoteTekst" minOccurs="0"/>
 *         &lt;element name="KontaktKanalTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AndenKontaktKanalType", propOrder = {
    "noteTekst",
    "kontaktKanalTekst"
})
public class AndenKontaktKanalType {

    @XmlElement(name = "NoteTekst", namespace = "urn:oio:sagdok:2.0.0")
    protected String noteTekst;
    @XmlElement(name = "KontaktKanalTekst")
    protected String kontaktKanalTekst;

    /**
     * Gets the value of the noteTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteTekst() {
        return noteTekst;
    }

    /**
     * Sets the value of the noteTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteTekst(String value) {
        this.noteTekst = value;
    }

    /**
     * Gets the value of the kontaktKanalTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKontaktKanalTekst() {
        return kontaktKanalTekst;
    }

    /**
     * Sets the value of the kontaktKanalTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKontaktKanalTekst(String value) {
        this.kontaktKanalTekst = value;
    }

}
