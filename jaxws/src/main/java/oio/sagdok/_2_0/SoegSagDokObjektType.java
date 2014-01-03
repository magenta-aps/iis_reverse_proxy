
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.SoegObjektType;


/**
 * <p>Java class for SoegSagDokObjektType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegSagDokObjektType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:dkal:1.0.0}UUID" minOccurs="0"/>
 *         &lt;element ref="{urn:oio:sagdok:1.0.0}BrugervendtNoegleTekst" minOccurs="0"/>
 *         &lt;element name="SoegRegistrering" type="{urn:oio:sagdok:2.0.0}SoegRegistreringType" minOccurs="0"/>
 *         &lt;element name="SoegVirkning" type="{urn:oio:sagdok:2.0.0}SoegVirkningType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegSagDokObjektType", propOrder = {
    "uuid",
    "brugervendtNoegleTekst",
    "soegRegistrering",
    "soegVirkning"
})
@XmlSeeAlso({
    SoegObjektType.class
})
public class SoegSagDokObjektType {

    @XmlElement(name = "UUID", namespace = "urn:oio:dkal:1.0.0")
    protected String uuid;
    @XmlElement(name = "BrugervendtNoegleTekst", namespace = "urn:oio:sagdok:1.0.0")
    protected String brugervendtNoegleTekst;
    @XmlElement(name = "SoegRegistrering")
    protected SoegRegistreringType soegRegistrering;
    @XmlElement(name = "SoegVirkning")
    protected SoegVirkningType soegVirkning;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the brugervendtNoegleTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrugervendtNoegleTekst() {
        return brugervendtNoegleTekst;
    }

    /**
     * Sets the value of the brugervendtNoegleTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrugervendtNoegleTekst(String value) {
        this.brugervendtNoegleTekst = value;
    }

    /**
     * Gets the value of the soegRegistrering property.
     * 
     * @return
     *     possible object is
     *     {@link SoegRegistreringType }
     *     
     */
    public SoegRegistreringType getSoegRegistrering() {
        return soegRegistrering;
    }

    /**
     * Sets the value of the soegRegistrering property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegRegistreringType }
     *     
     */
    public void setSoegRegistrering(SoegRegistreringType value) {
        this.soegRegistrering = value;
    }

    /**
     * Gets the value of the soegVirkning property.
     * 
     * @return
     *     possible object is
     *     {@link SoegVirkningType }
     *     
     */
    public SoegVirkningType getSoegVirkning() {
        return soegVirkning;
    }

    /**
     * Sets the value of the soegVirkning property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegVirkningType }
     *     
     */
    public void setSoegVirkning(SoegVirkningType value) {
        this.soegVirkning = value;
    }

}
