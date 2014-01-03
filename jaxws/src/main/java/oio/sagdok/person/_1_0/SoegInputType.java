
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegInputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}SoegInputType">
 *       &lt;sequence>
 *         &lt;element name="SoegObjekt" type="{urn:oio:sagdok:person:1.0.0}SoegObjektType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegInputType", propOrder = {
    "soegObjekt"
})
public class SoegInputType
    extends oio.sagdok._2_0.SoegInputType
{

    @XmlElement(name = "SoegObjekt")
    protected SoegObjektType soegObjekt;

    /**
     * Gets the value of the soegObjekt property.
     * 
     * @return
     *     possible object is
     *     {@link SoegObjektType }
     *     
     */
    public SoegObjektType getSoegObjekt() {
        return soegObjekt;
    }

    /**
     * Sets the value of the soegObjekt property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegObjektType }
     *     
     */
    public void setSoegObjekt(SoegObjektType value) {
        this.soegObjekt = value;
    }

}
