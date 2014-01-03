
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.BasicOutputType;


/**
 * <p>Java class for LaesOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaesOutputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}BasicOutputType">
 *       &lt;sequence>
 *         &lt;element name="LaesResultat" type="{urn:oio:sagdok:person:1.0.0}LaesResultatType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaesOutputType", propOrder = {
    "laesResultat"
})
public class LaesOutputType
    extends BasicOutputType
{

    @XmlElement(name = "LaesResultat")
    protected LaesResultatType laesResultat;

    /**
     * Gets the value of the laesResultat property.
     * 
     * @return
     *     possible object is
     *     {@link LaesResultatType }
     *     
     */
    public LaesResultatType getLaesResultat() {
        return laesResultat;
    }

    /**
     * Sets the value of the laesResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesResultatType }
     *     
     */
    public void setLaesResultat(LaesResultatType value) {
        this.laesResultat = value;
    }

}
