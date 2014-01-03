
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.GetUuidOutputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}GetUuidOutput" minOccurs="0"/>
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
    "getUuidOutput"
})
@XmlRootElement(name = "GetUuidResponse")
public class GetUuidResponse {

    @XmlElement(name = "GetUuidOutput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected GetUuidOutputType getUuidOutput;

    /**
     * Gets the value of the getUuidOutput property.
     * 
     * @return
     *     possible object is
     *     {@link GetUuidOutputType }
     *     
     */
    public GetUuidOutputType getGetUuidOutput() {
        return getUuidOutput;
    }

    /**
     * Sets the value of the getUuidOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUuidOutputType }
     *     
     */
    public void setGetUuidOutput(GetUuidOutputType value) {
        this.getUuidOutput = value;
    }

}
