
package oio.sagdok._2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListInputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:dkal:1.0.0}UUID" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ListInputType", propOrder = {
    "uuid",
    "virkningFraFilter",
    "virkningTilFilter",
    "registreringFraFilter",
    "registreringTilFilter"
})
public class ListInputType {

    @XmlElement(name = "UUID", namespace = "urn:oio:dkal:1.0.0")
    protected List<String> uuid;
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUUID() {
        if (uuid == null) {
            uuid = new ArrayList<String>();
        }
        return this.uuid;
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
