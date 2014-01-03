
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdresseBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdresseBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}NoteTekst" minOccurs="0"/>
 *         &lt;element name="UkendtAdresseIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdresseBaseType", propOrder = {
    "noteTekst",
    "ukendtAdresseIndikator"
})
@XmlSeeAlso({
    DanskAdresseType.class,
    VerdenAdresseType.class,
    GroenlandAdresseType.class
})
public class AdresseBaseType {

    @XmlElement(name = "NoteTekst", namespace = "urn:oio:sagdok:2.0.0")
    protected String noteTekst;
    @XmlElement(name = "UkendtAdresseIndikator")
    protected boolean ukendtAdresseIndikator;

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
     * Gets the value of the ukendtAdresseIndikator property.
     * 
     */
    public boolean isUkendtAdresseIndikator() {
        return ukendtAdresseIndikator;
    }

    /**
     * Sets the value of the ukendtAdresseIndikator property.
     * 
     */
    public void setUkendtAdresseIndikator(boolean value) {
        this.ukendtAdresseIndikator = value;
    }

}
