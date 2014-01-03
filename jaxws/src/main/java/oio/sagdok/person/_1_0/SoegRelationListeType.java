
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LokalUdvidelseType;
import oio.sagdok._2_0.SoegRelationType;


/**
 * <p>Java class for SoegRelationListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegRelationListeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoegModer" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegFader" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegBoern" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegAegtefaelle" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegRegistreretPartner" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegBopaelsamling" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegForaeldremyndighedsindehaver" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegForaeldremyndighedsboern" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegRetligHandleevneVaergeForPersonen" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegRetligHandleevneVaergemaalsindehaver" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegErstatningFor" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SoegErstattesAf" type="{urn:oio:sagdok:2.0.0}SoegRelationType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "SoegRelationListeType", propOrder = {
    "soegModer",
    "soegFader",
    "soegBoern",
    "soegAegtefaelle",
    "soegRegistreretPartner",
    "soegBopaelsamling",
    "soegForaeldremyndighedsindehaver",
    "soegForaeldremyndighedsboern",
    "soegRetligHandleevneVaergeForPersonen",
    "soegRetligHandleevneVaergemaalsindehaver",
    "soegErstatningFor",
    "soegErstattesAf",
    "lokalUdvidelse"
})
public class SoegRelationListeType {

    @XmlElement(name = "SoegModer")
    protected List<SoegRelationType> soegModer;
    @XmlElement(name = "SoegFader")
    protected List<SoegRelationType> soegFader;
    @XmlElement(name = "SoegBoern")
    protected List<SoegRelationType> soegBoern;
    @XmlElement(name = "SoegAegtefaelle")
    protected List<SoegRelationType> soegAegtefaelle;
    @XmlElement(name = "SoegRegistreretPartner")
    protected List<SoegRelationType> soegRegistreretPartner;
    @XmlElement(name = "SoegBopaelsamling")
    protected List<SoegRelationType> soegBopaelsamling;
    @XmlElement(name = "SoegForaeldremyndighedsindehaver")
    protected List<SoegRelationType> soegForaeldremyndighedsindehaver;
    @XmlElement(name = "SoegForaeldremyndighedsboern")
    protected List<SoegRelationType> soegForaeldremyndighedsboern;
    @XmlElement(name = "SoegRetligHandleevneVaergeForPersonen")
    protected List<SoegRelationType> soegRetligHandleevneVaergeForPersonen;
    @XmlElement(name = "SoegRetligHandleevneVaergemaalsindehaver")
    protected List<SoegRelationType> soegRetligHandleevneVaergemaalsindehaver;
    @XmlElement(name = "SoegErstatningFor")
    protected List<SoegRelationType> soegErstatningFor;
    @XmlElement(name = "SoegErstattesAf")
    protected List<SoegRelationType> soegErstattesAf;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:2.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the soegModer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegModer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegModer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegModer() {
        if (soegModer == null) {
            soegModer = new ArrayList<SoegRelationType>();
        }
        return this.soegModer;
    }

    /**
     * Gets the value of the soegFader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegFader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegFader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegFader() {
        if (soegFader == null) {
            soegFader = new ArrayList<SoegRelationType>();
        }
        return this.soegFader;
    }

    /**
     * Gets the value of the soegBoern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegBoern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegBoern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegBoern() {
        if (soegBoern == null) {
            soegBoern = new ArrayList<SoegRelationType>();
        }
        return this.soegBoern;
    }

    /**
     * Gets the value of the soegAegtefaelle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegAegtefaelle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegAegtefaelle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegAegtefaelle() {
        if (soegAegtefaelle == null) {
            soegAegtefaelle = new ArrayList<SoegRelationType>();
        }
        return this.soegAegtefaelle;
    }

    /**
     * Gets the value of the soegRegistreretPartner property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegRegistreretPartner property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegRegistreretPartner().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegRegistreretPartner() {
        if (soegRegistreretPartner == null) {
            soegRegistreretPartner = new ArrayList<SoegRelationType>();
        }
        return this.soegRegistreretPartner;
    }

    /**
     * Gets the value of the soegBopaelsamling property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegBopaelsamling property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegBopaelsamling().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegBopaelsamling() {
        if (soegBopaelsamling == null) {
            soegBopaelsamling = new ArrayList<SoegRelationType>();
        }
        return this.soegBopaelsamling;
    }

    /**
     * Gets the value of the soegForaeldremyndighedsindehaver property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegForaeldremyndighedsindehaver property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegForaeldremyndighedsindehaver().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegForaeldremyndighedsindehaver() {
        if (soegForaeldremyndighedsindehaver == null) {
            soegForaeldremyndighedsindehaver = new ArrayList<SoegRelationType>();
        }
        return this.soegForaeldremyndighedsindehaver;
    }

    /**
     * Gets the value of the soegForaeldremyndighedsboern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegForaeldremyndighedsboern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegForaeldremyndighedsboern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegForaeldremyndighedsboern() {
        if (soegForaeldremyndighedsboern == null) {
            soegForaeldremyndighedsboern = new ArrayList<SoegRelationType>();
        }
        return this.soegForaeldremyndighedsboern;
    }

    /**
     * Gets the value of the soegRetligHandleevneVaergeForPersonen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegRetligHandleevneVaergeForPersonen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegRetligHandleevneVaergeForPersonen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegRetligHandleevneVaergeForPersonen() {
        if (soegRetligHandleevneVaergeForPersonen == null) {
            soegRetligHandleevneVaergeForPersonen = new ArrayList<SoegRelationType>();
        }
        return this.soegRetligHandleevneVaergeForPersonen;
    }

    /**
     * Gets the value of the soegRetligHandleevneVaergemaalsindehaver property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegRetligHandleevneVaergemaalsindehaver property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegRetligHandleevneVaergemaalsindehaver().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegRetligHandleevneVaergemaalsindehaver() {
        if (soegRetligHandleevneVaergemaalsindehaver == null) {
            soegRetligHandleevneVaergemaalsindehaver = new ArrayList<SoegRelationType>();
        }
        return this.soegRetligHandleevneVaergemaalsindehaver;
    }

    /**
     * Gets the value of the soegErstatningFor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegErstatningFor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegErstatningFor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegErstatningFor() {
        if (soegErstatningFor == null) {
            soegErstatningFor = new ArrayList<SoegRelationType>();
        }
        return this.soegErstatningFor;
    }

    /**
     * Gets the value of the soegErstattesAf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegErstattesAf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegErstattesAf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegRelationType }
     * 
     * 
     */
    public List<SoegRelationType> getSoegErstattesAf() {
        if (soegErstattesAf == null) {
            soegErstattesAf = new ArrayList<SoegRelationType>();
        }
        return this.soegErstattesAf;
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
