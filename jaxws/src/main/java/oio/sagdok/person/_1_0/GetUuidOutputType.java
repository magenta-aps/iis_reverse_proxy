
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.BasicOutputType;


/**
 * <p>Java class for GetUuidOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUuidOutputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}BasicOutputType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:dkal:1.0.0}UUID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUuidOutputType", propOrder = {
    "uuid"
})
public class GetUuidOutputType
    extends BasicOutputType
{

    @XmlElement(name = "UUID", namespace = "urn:oio:dkal:1.0.0")
    protected String uuid;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

}
