
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.TilstandVirkningType;


/**
 * <p>Java class for LivStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LivStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LivStatusKode" type="{urn:oio:sagdok:person:1.0.0}LivStatusKodeType"/>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}TilstandVirkning" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivStatusType", propOrder = {
    "livStatusKode",
    "tilstandVirkning"
})
public class LivStatusType {

    @XmlElement(name = "LivStatusKode", required = true)
    @XmlSchemaType(name = "string")
    protected LivStatusKodeType livStatusKode;
    @XmlElement(name = "TilstandVirkning", namespace = "urn:oio:sagdok:2.0.0")
    protected TilstandVirkningType tilstandVirkning;

    /**
     * Gets the value of the livStatusKode property.
     * 
     * @return
     *     possible object is
     *     {@link LivStatusKodeType }
     *     
     */
    public LivStatusKodeType getLivStatusKode() {
        return livStatusKode;
    }

    /**
     * Sets the value of the livStatusKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LivStatusKodeType }
     *     
     */
    public void setLivStatusKode(LivStatusKodeType value) {
        this.livStatusKode = value;
    }

    /**
     * Gets the value of the tilstandVirkning property.
     * 
     * @return
     *     possible object is
     *     {@link TilstandVirkningType }
     *     
     */
    public TilstandVirkningType getTilstandVirkning() {
        return tilstandVirkning;
    }

    /**
     * Sets the value of the tilstandVirkning property.
     * 
     * @param value
     *     allowed object is
     *     {@link TilstandVirkningType }
     *     
     */
    public void setTilstandVirkning(TilstandVirkningType value) {
        this.tilstandVirkning = value;
    }

}
