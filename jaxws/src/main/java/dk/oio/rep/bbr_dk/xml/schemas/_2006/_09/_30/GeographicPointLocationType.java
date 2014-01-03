
package dk.oio.rep.bbr_dk.xml.schemas._2006._09._30;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeographicPointLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeographicPointLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GeographicCoordinateTuple" type="{http://rep.oio.dk/bbr.dk/xml/schemas/2006/09/30/}GeographicCoordinateTupleType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="crsIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicPointLocationType", propOrder = {
    "geographicCoordinateTuple"
})
public class GeographicPointLocationType {

    @XmlElement(name = "GeographicCoordinateTuple")
    protected GeographicCoordinateTupleType geographicCoordinateTuple;
    @XmlAttribute(name = "crsIdentifier")
    protected String crsIdentifier;

    /**
     * Gets the value of the geographicCoordinateTuple property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicCoordinateTupleType }
     *     
     */
    public GeographicCoordinateTupleType getGeographicCoordinateTuple() {
        return geographicCoordinateTuple;
    }

    /**
     * Sets the value of the geographicCoordinateTuple property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicCoordinateTupleType }
     *     
     */
    public void setGeographicCoordinateTuple(GeographicCoordinateTupleType value) {
        this.geographicCoordinateTuple = value;
    }

    /**
     * Gets the value of the crsIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrsIdentifier() {
        return crsIdentifier;
    }

    /**
     * Sets the value of the crsIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrsIdentifier(String value) {
        this.crsIdentifier = value;
    }

}
