
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdresseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdresseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="VerdenAdresse" type="{urn:oio:sagdok:person:1.0.0}VerdenAdresseType" minOccurs="0"/>
 *           &lt;element name="DanskAdresse" type="{urn:oio:sagdok:person:1.0.0}DanskAdresseType" minOccurs="0"/>
 *           &lt;element name="GroenlandAdresse" type="{urn:oio:sagdok:person:1.0.0}GroenlandAdresseType" minOccurs="0"/>
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
@XmlType(name = "AdresseType", propOrder = {
    "verdenAdresse",
    "danskAdresse",
    "groenlandAdresse"
})
public class AdresseType {

    @XmlElement(name = "VerdenAdresse")
    protected VerdenAdresseType verdenAdresse;
    @XmlElement(name = "DanskAdresse")
    protected DanskAdresseType danskAdresse;
    @XmlElement(name = "GroenlandAdresse")
    protected GroenlandAdresseType groenlandAdresse;

    /**
     * Gets the value of the verdenAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link VerdenAdresseType }
     *     
     */
    public VerdenAdresseType getVerdenAdresse() {
        return verdenAdresse;
    }

    /**
     * Sets the value of the verdenAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerdenAdresseType }
     *     
     */
    public void setVerdenAdresse(VerdenAdresseType value) {
        this.verdenAdresse = value;
    }

    /**
     * Gets the value of the danskAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link DanskAdresseType }
     *     
     */
    public DanskAdresseType getDanskAdresse() {
        return danskAdresse;
    }

    /**
     * Sets the value of the danskAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DanskAdresseType }
     *     
     */
    public void setDanskAdresse(DanskAdresseType value) {
        this.danskAdresse = value;
    }

    /**
     * Gets the value of the groenlandAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link GroenlandAdresseType }
     *     
     */
    public GroenlandAdresseType getGroenlandAdresse() {
        return groenlandAdresse;
    }

    /**
     * Sets the value of the groenlandAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroenlandAdresseType }
     *     
     */
    public void setGroenlandAdresse(GroenlandAdresseType value) {
        this.groenlandAdresse = value;
    }

}
