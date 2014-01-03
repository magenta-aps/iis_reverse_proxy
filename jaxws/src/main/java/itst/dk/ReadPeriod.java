
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.LaesPeriodInputType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}LaesPeriodInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "laesPeriodInput"
})
@XmlRootElement(name = "ReadPeriod")
public class ReadPeriod {

    @XmlElement(name = "LaesPeriodInput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected LaesPeriodInputType laesPeriodInput;

    /**
     * Gets the value of the laesPeriodInput property.
     * 
     * @return
     *     possible object is
     *     {@link LaesPeriodInputType }
     *     
     */
    public LaesPeriodInputType getLaesPeriodInput() {
        return laesPeriodInput;
    }

    /**
     * Sets the value of the laesPeriodInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesPeriodInputType }
     *     
     */
    public void setLaesPeriodInput(LaesPeriodInputType value) {
        this.laesPeriodInput = value;
    }

}
