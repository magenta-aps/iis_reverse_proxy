
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LaesInputType;


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
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}LaesInput" minOccurs="0"/>
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
    "laesInput"
})
@XmlRootElement(name = "RefreshRead")
public class RefreshRead {

    @XmlElement(name = "LaesInput", namespace = "urn:oio:sagdok:2.0.0")
    protected LaesInputType laesInput;

    /**
     * Gets the value of the laesInput property.
     * 
     * @return
     *     possible object is
     *     {@link LaesInputType }
     *     
     */
    public LaesInputType getLaesInput() {
        return laesInput;
    }

    /**
     * Sets the value of the laesInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesInputType }
     *     
     */
    public void setLaesInput(LaesInputType value) {
        this.laesInput = value;
    }

}
