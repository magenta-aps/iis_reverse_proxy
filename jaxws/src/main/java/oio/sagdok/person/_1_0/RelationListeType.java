
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LokalUdvidelseType;
import oio.sagdok._2_0.PersonFlerRelationType;


/**
 * <p>Java class for RelationListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelationListeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Moder" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fader" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Boern" type="{urn:oio:sagdok:2.0.0}PersonFlerRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Aegtefaelle" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RegistreretPartner" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bopaelssamling" type="{urn:oio:sagdok:2.0.0}PersonFlerRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Foraeldremyndighedsindehaver" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Foraeldremyndighedsboern" type="{urn:oio:sagdok:2.0.0}PersonFlerRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RetligHandleevneVaergeForPersonen" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RetligHandleevneVaergemaalsindehaver" type="{urn:oio:sagdok:2.0.0}PersonFlerRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ErstatningFor" type="{urn:oio:sagdok:2.0.0}PersonFlerRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ErstatningAf" type="{urn:oio:sagdok:person:1.0.0}PersonRelationType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "RelationListeType", propOrder = {
    "moder",
    "fader",
    "boern",
    "aegtefaelle",
    "registreretPartner",
    "bopaelssamling",
    "foraeldremyndighedsindehaver",
    "foraeldremyndighedsboern",
    "retligHandleevneVaergeForPersonen",
    "retligHandleevneVaergemaalsindehaver",
    "erstatningFor",
    "erstatningAf",
    "lokalUdvidelse"
})
public class RelationListeType {

    @XmlElement(name = "Moder")
    protected List<PersonRelationType> moder;
    @XmlElement(name = "Fader")
    protected List<PersonRelationType> fader;
    @XmlElement(name = "Boern")
    protected List<PersonFlerRelationType> boern;
    @XmlElement(name = "Aegtefaelle")
    protected List<PersonRelationType> aegtefaelle;
    @XmlElement(name = "RegistreretPartner")
    protected List<PersonRelationType> registreretPartner;
    @XmlElement(name = "Bopaelssamling")
    protected List<PersonFlerRelationType> bopaelssamling;
    @XmlElement(name = "Foraeldremyndighedsindehaver")
    protected List<PersonRelationType> foraeldremyndighedsindehaver;
    @XmlElement(name = "Foraeldremyndighedsboern")
    protected List<PersonFlerRelationType> foraeldremyndighedsboern;
    @XmlElement(name = "RetligHandleevneVaergeForPersonen")
    protected List<PersonRelationType> retligHandleevneVaergeForPersonen;
    @XmlElement(name = "RetligHandleevneVaergemaalsindehaver")
    protected List<PersonFlerRelationType> retligHandleevneVaergemaalsindehaver;
    @XmlElement(name = "ErstatningFor")
    protected List<PersonFlerRelationType> erstatningFor;
    @XmlElement(name = "ErstatningAf")
    protected List<PersonRelationType> erstatningAf;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:2.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the moder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the moder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getModer() {
        if (moder == null) {
            moder = new ArrayList<PersonRelationType>();
        }
        return this.moder;
    }

    /**
     * Gets the value of the fader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getFader() {
        if (fader == null) {
            fader = new ArrayList<PersonRelationType>();
        }
        return this.fader;
    }

    /**
     * Gets the value of the boern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonFlerRelationType }
     * 
     * 
     */
    public List<PersonFlerRelationType> getBoern() {
        if (boern == null) {
            boern = new ArrayList<PersonFlerRelationType>();
        }
        return this.boern;
    }

    /**
     * Gets the value of the aegtefaelle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aegtefaelle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAegtefaelle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getAegtefaelle() {
        if (aegtefaelle == null) {
            aegtefaelle = new ArrayList<PersonRelationType>();
        }
        return this.aegtefaelle;
    }

    /**
     * Gets the value of the registreretPartner property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registreretPartner property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistreretPartner().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getRegistreretPartner() {
        if (registreretPartner == null) {
            registreretPartner = new ArrayList<PersonRelationType>();
        }
        return this.registreretPartner;
    }

    /**
     * Gets the value of the bopaelssamling property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bopaelssamling property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBopaelssamling().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonFlerRelationType }
     * 
     * 
     */
    public List<PersonFlerRelationType> getBopaelssamling() {
        if (bopaelssamling == null) {
            bopaelssamling = new ArrayList<PersonFlerRelationType>();
        }
        return this.bopaelssamling;
    }

    /**
     * Gets the value of the foraeldremyndighedsindehaver property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foraeldremyndighedsindehaver property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForaeldremyndighedsindehaver().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getForaeldremyndighedsindehaver() {
        if (foraeldremyndighedsindehaver == null) {
            foraeldremyndighedsindehaver = new ArrayList<PersonRelationType>();
        }
        return this.foraeldremyndighedsindehaver;
    }

    /**
     * Gets the value of the foraeldremyndighedsboern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foraeldremyndighedsboern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForaeldremyndighedsboern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonFlerRelationType }
     * 
     * 
     */
    public List<PersonFlerRelationType> getForaeldremyndighedsboern() {
        if (foraeldremyndighedsboern == null) {
            foraeldremyndighedsboern = new ArrayList<PersonFlerRelationType>();
        }
        return this.foraeldremyndighedsboern;
    }

    /**
     * Gets the value of the retligHandleevneVaergeForPersonen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retligHandleevneVaergeForPersonen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetligHandleevneVaergeForPersonen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getRetligHandleevneVaergeForPersonen() {
        if (retligHandleevneVaergeForPersonen == null) {
            retligHandleevneVaergeForPersonen = new ArrayList<PersonRelationType>();
        }
        return this.retligHandleevneVaergeForPersonen;
    }

    /**
     * Gets the value of the retligHandleevneVaergemaalsindehaver property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retligHandleevneVaergemaalsindehaver property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetligHandleevneVaergemaalsindehaver().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonFlerRelationType }
     * 
     * 
     */
    public List<PersonFlerRelationType> getRetligHandleevneVaergemaalsindehaver() {
        if (retligHandleevneVaergemaalsindehaver == null) {
            retligHandleevneVaergemaalsindehaver = new ArrayList<PersonFlerRelationType>();
        }
        return this.retligHandleevneVaergemaalsindehaver;
    }

    /**
     * Gets the value of the erstatningFor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erstatningFor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErstatningFor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonFlerRelationType }
     * 
     * 
     */
    public List<PersonFlerRelationType> getErstatningFor() {
        if (erstatningFor == null) {
            erstatningFor = new ArrayList<PersonFlerRelationType>();
        }
        return this.erstatningFor;
    }

    /**
     * Gets the value of the erstatningAf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erstatningAf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErstatningAf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonRelationType }
     * 
     * 
     */
    public List<PersonRelationType> getErstatningAf() {
        if (erstatningAf == null) {
            erstatningAf = new ArrayList<PersonRelationType>();
        }
        return this.erstatningAf;
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
