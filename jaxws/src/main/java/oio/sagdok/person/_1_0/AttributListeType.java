
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LokalUdvidelseType;


/**
 * <p>Java class for AttributListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributListeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Egenskab" type="{urn:oio:sagdok:person:1.0.0}EgenskabType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SundhedOplysning" type="{urn:oio:sagdok:person:1.0.0}SundhedOplysningType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RegisterOplysning" type="{urn:oio:sagdok:person:1.0.0}RegisterOplysningType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AttributListeType", propOrder = {
    "egenskab",
    "sundhedOplysning",
    "registerOplysning",
    "lokalUdvidelse"
})
public class AttributListeType {

    @XmlElement(name = "Egenskab")
    protected List<EgenskabType> egenskab;
    @XmlElement(name = "SundhedOplysning")
    protected List<SundhedOplysningType> sundhedOplysning;
    @XmlElement(name = "RegisterOplysning")
    protected List<RegisterOplysningType> registerOplysning;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:2.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the egenskab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the egenskab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEgenskab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EgenskabType }
     * 
     * 
     */
    public List<EgenskabType> getEgenskab() {
        if (egenskab == null) {
            egenskab = new ArrayList<EgenskabType>();
        }
        return this.egenskab;
    }

    /**
     * Gets the value of the sundhedOplysning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sundhedOplysning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSundhedOplysning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SundhedOplysningType }
     * 
     * 
     */
    public List<SundhedOplysningType> getSundhedOplysning() {
        if (sundhedOplysning == null) {
            sundhedOplysning = new ArrayList<SundhedOplysningType>();
        }
        return this.sundhedOplysning;
    }

    /**
     * Gets the value of the registerOplysning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registerOplysning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegisterOplysning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegisterOplysningType }
     * 
     * 
     */
    public List<RegisterOplysningType> getRegisterOplysning() {
        if (registerOplysning == null) {
            registerOplysning = new ArrayList<RegisterOplysningType>();
        }
        return this.registerOplysning;
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
