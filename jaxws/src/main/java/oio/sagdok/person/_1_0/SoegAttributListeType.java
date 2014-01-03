
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LokalUdvidelseType;


/**
 * <p>Java class for SoegAttributListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegAttributListeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoegEgenskab" type="{urn:oio:sagdok:person:1.0.0}SoegEgenskabType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegSundhedOplysning" type="{urn:oio:sagdok:person:1.0.0}SundhedOplysningType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegRegisterOplysning" type="{urn:oio:sagdok:person:1.0.0}RegisterOplysningType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "SoegAttributListeType", propOrder = {
    "soegEgenskab",
    "soegSundhedOplysning",
    "soegRegisterOplysning",
    "lokalUdvidelse"
})
public class SoegAttributListeType {

    @XmlElement(name = "SoegEgenskab")
    protected List<SoegEgenskabType> soegEgenskab;
    @XmlElement(name = "SoegSundhedOplysning")
    protected List<SundhedOplysningType> soegSundhedOplysning;
    @XmlElement(name = "SoegRegisterOplysning")
    protected List<RegisterOplysningType> soegRegisterOplysning;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:2.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the soegEgenskab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegEgenskab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegEgenskab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegEgenskabType }
     * 
     * 
     */
    public List<SoegEgenskabType> getSoegEgenskab() {
        if (soegEgenskab == null) {
            soegEgenskab = new ArrayList<SoegEgenskabType>();
        }
        return this.soegEgenskab;
    }

    /**
     * Gets the value of the soegSundhedOplysning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegSundhedOplysning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegSundhedOplysning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SundhedOplysningType }
     * 
     * 
     */
    public List<SundhedOplysningType> getSoegSundhedOplysning() {
        if (soegSundhedOplysning == null) {
            soegSundhedOplysning = new ArrayList<SundhedOplysningType>();
        }
        return this.soegSundhedOplysning;
    }

    /**
     * Gets the value of the soegRegisterOplysning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegRegisterOplysning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegRegisterOplysning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegisterOplysningType }
     * 
     * 
     */
    public List<RegisterOplysningType> getSoegRegisterOplysning() {
        if (soegRegisterOplysning == null) {
            soegRegisterOplysning = new ArrayList<RegisterOplysningType>();
        }
        return this.soegRegisterOplysning;
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
