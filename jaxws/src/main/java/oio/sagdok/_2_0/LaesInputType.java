
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LaesInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaesInputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:dkal:1.0.0}UUID" minOccurs="0"/>
 *         &lt;element name="VirkningFraFilter" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *         &lt;element name="VirkningTilFilter" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *         &lt;element name="RegistreringFraFilter" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *         &lt;element name="RegistreringTilFilter" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaesInputType", propOrder = {
    "uuid",
    "virkningFraFilter",
    "virkningTilFilter",
    "registreringFraFilter",
    "registreringTilFilter"
})
public class LaesInputType {

    @XmlElement(name = "UUID", namespace = "urn:oio:dkal:1.0.0")
    protected String uuid;
    @XmlElement(name = "VirkningFraFilter")
    protected TidspunktType virkningFraFilter;
    @XmlElement(name = "VirkningTilFilter")
    protected TidspunktType virkningTilFilter;
    @XmlElement(name = "RegistreringFraFilter")
    protected TidspunktType registreringFraFilter;
    @XmlElement(name = "RegistreringTilFilter")
    protected TidspunktType registreringTilFilter;

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
     * Gets the value of the virkningFraFilter property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getVirkningFraFilter() {
        return virkningFraFilter;
    }

    /**
     * Sets the value of the virkningFraFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setVirkningFraFilter(TidspunktType value) {
        this.virkningFraFilter = value;
    }

    /**
     * Gets the value of the virkningTilFilter property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getVirkningTilFilter() {
        return virkningTilFilter;
    }

    /**
     * Sets the value of the virkningTilFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setVirkningTilFilter(TidspunktType value) {
        this.virkningTilFilter = value;
    }

    /**
     * Gets the value of the registreringFraFilter property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getRegistreringFraFilter() {
        return registreringFraFilter;
    }

    /**
     * Sets the value of the registreringFraFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setRegistreringFraFilter(TidspunktType value) {
        this.registreringFraFilter = value;
    }

    /**
     * Gets the value of the registreringTilFilter property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getRegistreringTilFilter() {
        return registreringTilFilter;
    }

    /**
     * Sets the value of the registreringTilFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setRegistreringTilFilter(TidspunktType value) {
        this.registreringTilFilter = value;
    }

}
