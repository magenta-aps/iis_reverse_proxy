
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.dkal._1_0.ArrayOfString;
import oio.sagdok._2_0.StandardReturType;


/**
 * <p>Java class for SoegListOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegListOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}StandardRetur" minOccurs="0"/>
 *         &lt;element name="LaesResultat" type="{urn:oio:sagdok:person:1.0.0}LaesResultatType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oio:sagdok:1.0.0}Idliste" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegListOutputType", propOrder = {
    "standardRetur",
    "laesResultat",
    "idliste"
})
public class SoegListOutputType {

    @XmlElement(name = "StandardRetur", namespace = "urn:oio:sagdok:2.0.0")
    protected StandardReturType standardRetur;
    @XmlElement(name = "LaesResultat")
    protected List<LaesResultatType> laesResultat;
    @XmlElement(name = "Idliste", namespace = "urn:oio:sagdok:1.0.0")
    protected ArrayOfString idliste;

    /**
     * Gets the value of the standardRetur property.
     * 
     * @return
     *     possible object is
     *     {@link StandardReturType }
     *     
     */
    public StandardReturType getStandardRetur() {
        return standardRetur;
    }

    /**
     * Sets the value of the standardRetur property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardReturType }
     *     
     */
    public void setStandardRetur(StandardReturType value) {
        this.standardRetur = value;
    }

    /**
     * Gets the value of the laesResultat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laesResultat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaesResultat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LaesResultatType }
     * 
     * 
     */
    public List<LaesResultatType> getLaesResultat() {
        if (laesResultat == null) {
            laesResultat = new ArrayList<LaesResultatType>();
        }
        return this.laesResultat;
    }

    /**
     * Gets the value of the idliste property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getIdliste() {
        return idliste;
    }

    /**
     * Sets the value of the idliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setIdliste(ArrayOfString value) {
        this.idliste = value;
    }

}
