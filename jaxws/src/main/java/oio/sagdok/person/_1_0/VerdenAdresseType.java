
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import dk.oio.rep.cpr_dk.xml.schemas._2008._05._01.ForeignAddressStructureType;


/**
 * <p>Java class for VerdenAdresseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerdenAdresseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:person:1.0.0}AdresseBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://rep.oio.dk/cpr.dk/xml/schemas/2008/05/01/}ForeignAddressStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerdenAdresseType", propOrder = {
    "foreignAddressStructure"
})
public class VerdenAdresseType
    extends AdresseBaseType
{

    @XmlElement(name = "ForeignAddressStructure", namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/2008/05/01/")
    protected ForeignAddressStructureType foreignAddressStructure;

    /**
     * Gets the value of the foreignAddressStructure property.
     * 
     * @return
     *     possible object is
     *     {@link ForeignAddressStructureType }
     *     
     */
    public ForeignAddressStructureType getForeignAddressStructure() {
        return foreignAddressStructure;
    }

    /**
     * Sets the value of the foreignAddressStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignAddressStructureType }
     *     
     */
    public void setForeignAddressStructure(ForeignAddressStructureType value) {
        this.foreignAddressStructure = value;
    }

}
