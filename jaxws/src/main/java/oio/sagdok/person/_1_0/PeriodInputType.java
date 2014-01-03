
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PeriodInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodInputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirkningFraDato" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="VirkningTilDato" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodInputType", propOrder = {
    "virkningFraDato",
    "virkningTilDato"
})
@XmlSeeAlso({
    LaesPeriodInputType.class,
    ListPeriodInputType.class
})
public class PeriodInputType {

    @XmlElement(name = "VirkningFraDato", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar virkningFraDato;
    @XmlElement(name = "VirkningTilDato", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar virkningTilDato;

    /**
     * Gets the value of the virkningFraDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVirkningFraDato() {
        return virkningFraDato;
    }

    /**
     * Sets the value of the virkningFraDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVirkningFraDato(XMLGregorianCalendar value) {
        this.virkningFraDato = value;
    }

    /**
     * Gets the value of the virkningTilDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVirkningTilDato() {
        return virkningTilDato;
    }

    /**
     * Sets the value of the virkningTilDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVirkningTilDato(XMLGregorianCalendar value) {
        this.virkningTilDato = value;
    }

}
