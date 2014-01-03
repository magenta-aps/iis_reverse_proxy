
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LokalUdvidelseType;


/**
 * <p>Java class for SoegTilstandListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegTilstandListeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LivStatus" type="{urn:oio:sagdok:person:1.0.0}LivStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CivilStatus" type="{urn:oio:sagdok:person:1.0.0}CivilStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}LokalUdvidelse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegTilstandListeType", propOrder = {
    "livStatus",
    "civilStatus",
    "lokalUdvidelse"
})
public class SoegTilstandListeType {

    @XmlElement(name = "LivStatus")
    protected List<LivStatusType> livStatus;
    @XmlElement(name = "CivilStatus")
    protected List<CivilStatusType> civilStatus;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:2.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the livStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the livStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLivStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LivStatusType }
     * 
     * 
     */
    public List<LivStatusType> getLivStatus() {
        if (livStatus == null) {
            livStatus = new ArrayList<LivStatusType>();
        }
        return this.livStatus;
    }

    /**
     * Gets the value of the civilStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the civilStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCivilStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CivilStatusType }
     * 
     * 
     */
    public List<CivilStatusType> getCivilStatus() {
        if (civilStatus == null) {
            civilStatus = new ArrayList<CivilStatusType>();
        }
        return this.civilStatus;
    }

    /**
     * Gets the value of the lokalUdvidelse property.
     * 
     * @return
     *     possible object is
     *     {@link LokalUdvidelseType }
     *     
     */
    public LokalUdvidelseType getLokalUdvidelse() {
        return lokalUdvidelse;
    }

    /**
     * Sets the value of the lokalUdvidelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LokalUdvidelseType }
     *     
     */
    public void setLokalUdvidelse(LokalUdvidelseType value) {
        this.lokalUdvidelse = value;
    }

}
