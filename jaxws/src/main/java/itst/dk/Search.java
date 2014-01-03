
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.SoegInputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}SoegInput" minOccurs="0"/>
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
    "soegInput"
})
@XmlRootElement(name = "Search")
public class Search {

    @XmlElement(name = "SoegInput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected SoegInputType soegInput;

    /**
     * Gets the value of the soegInput property.
     * 
     * @return
     *     possible object is
     *     {@link SoegInputType }
     *     
     */
    public SoegInputType getSoegInput() {
        return soegInput;
    }

    /**
     * Sets the value of the soegInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegInputType }
     *     
     */
    public void setSoegInput(SoegInputType value) {
        this.soegInput = value;
    }

}
