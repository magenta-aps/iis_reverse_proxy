
package oio.sagdok._2_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StandardReturType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardReturType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusKode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FejlbeskedTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardReturType", propOrder = {
    "statusKode",
    "fejlbeskedTekst"
})
public class StandardReturType {

    @XmlElement(name = "StatusKode")
    protected BigInteger statusKode;
    @XmlElement(name = "FejlbeskedTekst")
    protected String fejlbeskedTekst;

    /**
     * Gets the value of the statusKode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStatusKode() {
        return statusKode;
    }

    /**
     * Sets the value of the statusKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStatusKode(BigInteger value) {
        this.statusKode = value;
    }

    /**
     * Gets the value of the fejlbeskedTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFejlbeskedTekst() {
        return fejlbeskedTekst;
    }

    /**
     * Sets the value of the fejlbeskedTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFejlbeskedTekst(String value) {
        this.fejlbeskedTekst = value;
    }

}
