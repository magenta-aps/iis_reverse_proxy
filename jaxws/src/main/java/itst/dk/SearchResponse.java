
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.SoegOutputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}SoegOutput" minOccurs="0"/>
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
    "soegOutput"
})
@XmlRootElement(name = "SearchResponse")
public class SearchResponse {

    @XmlElement(name = "SoegOutput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected SoegOutputType soegOutput;

    /**
     * Gets the value of the soegOutput property.
     * 
     * @return
     *     possible object is
     *     {@link SoegOutputType }
     *     
     */
    public SoegOutputType getSoegOutput() {
        return soegOutput;
    }

    /**
     * Sets the value of the soegOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegOutputType }
     *     
     */
    public void setSoegOutput(SoegOutputType value) {
        this.soegOutput = value;
    }

}
