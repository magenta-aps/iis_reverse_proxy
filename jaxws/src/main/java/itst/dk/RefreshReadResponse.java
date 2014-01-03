
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.LaesOutputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}LaesOutput" minOccurs="0"/>
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
    "laesOutput"
})
@XmlRootElement(name = "RefreshReadResponse")
public class RefreshReadResponse {

    @XmlElement(name = "LaesOutput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected LaesOutputType laesOutput;

    /**
     * Gets the value of the laesOutput property.
     * 
     * @return
     *     possible object is
     *     {@link LaesOutputType }
     *     
     */
    public LaesOutputType getLaesOutput() {
        return laesOutput;
    }

    /**
     * Sets the value of the laesOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesOutputType }
     *     
     */
    public void setLaesOutput(LaesOutputType value) {
        this.laesOutput = value;
    }

}
