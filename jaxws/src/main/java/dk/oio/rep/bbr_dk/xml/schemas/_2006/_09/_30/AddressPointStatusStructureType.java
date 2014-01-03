
package dk.oio.rep.bbr_dk.xml.schemas._2006._09._30;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AddressPointStatusStructureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressPointStatusStructureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressPointRevisionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AddressPointValidStartDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AddressPointValidEndDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AddressCoordinateQualityClassCode" type="{http://rep.oio.dk/bbr.dk/xml/schemas/2006/09/30/}AddressCoordinateQualityClassCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressPointStatusStructureType", propOrder = {
    "addressPointRevisionDateTime",
    "addressPointValidStartDateTime",
    "addressPointValidEndDateTime",
    "addressCoordinateQualityClassCode"
})
public class AddressPointStatusStructureType {

    @XmlElement(name = "AddressPointRevisionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addressPointRevisionDateTime;
    @XmlElement(name = "AddressPointValidStartDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addressPointValidStartDateTime;
    @XmlElement(name = "AddressPointValidEndDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addressPointValidEndDateTime;
    @XmlElement(name = "AddressCoordinateQualityClassCode")
    protected AddressCoordinateQualityClassCodeType addressCoordinateQualityClassCode;

    /**
     * Gets the value of the addressPointRevisionDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddressPointRevisionDateTime() {
        return addressPointRevisionDateTime;
    }

    /**
     * Sets the value of the addressPointRevisionDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddressPointRevisionDateTime(XMLGregorianCalendar value) {
        this.addressPointRevisionDateTime = value;
    }

    /**
     * Gets the value of the addressPointValidStartDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddressPointValidStartDateTime() {
        return addressPointValidStartDateTime;
    }

    /**
     * Sets the value of the addressPointValidStartDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddressPointValidStartDateTime(XMLGregorianCalendar value) {
        this.addressPointValidStartDateTime = value;
    }

    /**
     * Gets the value of the addressPointValidEndDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddressPointValidEndDateTime() {
        return addressPointValidEndDateTime;
    }

    /**
     * Sets the value of the addressPointValidEndDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddressPointValidEndDateTime(XMLGregorianCalendar value) {
        this.addressPointValidEndDateTime = value;
    }

    /**
     * Gets the value of the addressCoordinateQualityClassCode property.
     * 
     * @return
     *     possible object is
     *     {@link AddressCoordinateQualityClassCodeType }
     *     
     */
    public AddressCoordinateQualityClassCodeType getAddressCoordinateQualityClassCode() {
        return addressCoordinateQualityClassCode;
    }

    /**
     * Sets the value of the addressCoordinateQualityClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressCoordinateQualityClassCodeType }
     *     
     */
    public void setAddressCoordinateQualityClassCode(AddressCoordinateQualityClassCodeType value) {
        this.addressCoordinateQualityClassCode = value;
    }

}
