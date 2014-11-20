
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.GetUuidArrayOutputType;


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
 *         &lt;element name="GetUuidArrayResult" type="{urn:oio:sagdok:person:1.0.0}GetUuidArrayOutputType" minOccurs="0"/>
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
    "getUuidArrayResult"
})
@XmlRootElement(name = "GetUuidArrayResponse")
public class GetUuidArrayResponse {

    @XmlElement(name = "GetUuidArrayResult")
    protected GetUuidArrayOutputType getUuidArrayResult;

    /**
     * Gets the value of the getUuidArrayResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetUuidArrayOutputType }
     *     
     */
    public GetUuidArrayOutputType getGetUuidArrayResult() {
        return getUuidArrayResult;
    }

    /**
     * Sets the value of the getUuidArrayResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUuidArrayOutputType }
     *     
     */
    public void setGetUuidArrayResult(GetUuidArrayOutputType value) {
        this.getUuidArrayResult = value;
    }

}
