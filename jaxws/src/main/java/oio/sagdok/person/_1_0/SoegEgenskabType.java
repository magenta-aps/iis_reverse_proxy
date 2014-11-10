
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import dk.oio.rep.ebxml.xml.schemas.dkcc._2006._01._23.PersonGenderCodeType;
import oio.sagdok._2_0.SoegVirkningType;


/**
 * <p>Java class for SoegEgenskabType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegEgenskabType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NavnStruktur" type="{urn:oio:sagdok:person:1.0.0}NavnStrukturType" minOccurs="0"/>
 *         &lt;element ref="{http://rep.oio.dk/ebxml/xml/schemas/dkcc/2006/01/23/}PersonGenderCode" minOccurs="0"/>
 *         &lt;element ref="{http://rep.oio.dk/ebxml/xml/schemas/dkcc/2005/03/15/}BirthDate" minOccurs="0"/>
 *         &lt;element name="FoedselsregistreringMyndighedNavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FoedestedNavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KontaktKanal" type="{urn:oio:sagdok:person:1.0.0}KontaktKanalType" minOccurs="0"/>
 *         &lt;element name="NaermestePaaroerende" type="{urn:oio:sagdok:person:1.0.0}KontaktKanalType" minOccurs="0"/>
 *         &lt;element name="AndreAdresser" type="{urn:oio:sagdok:person:1.0.0}AdresseType" minOccurs="0"/>
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}SoegVirkning" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegEgenskabType", propOrder = {
    "navnStruktur",
    "personGenderCode",
    "birthDate",
    "foedselsregistreringMyndighedNavn",
    "foedestedNavn",
    "kontaktKanal",
    "naermestePaaroerende",
    "andreAdresser",
    "soegVirkning"
})
public class SoegEgenskabType {

    @XmlElement(name = "NavnStruktur")
    protected NavnStrukturType navnStruktur;
    @XmlElement(name = "PersonGenderCode", namespace = "http://rep.oio.dk/ebxml/xml/schemas/dkcc/2006/01/23/")
    @XmlSchemaType(name = "string")
    protected PersonGenderCodeType personGenderCode;
    @XmlElement(name = "BirthDate", namespace = "http://rep.oio.dk/ebxml/xml/schemas/dkcc/2005/03/15/")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "FoedselsregistreringMyndighedNavn")
    protected String foedselsregistreringMyndighedNavn;
    @XmlElement(name = "FoedestedNavn")
    protected String foedestedNavn;
    @XmlElement(name = "KontaktKanal")
    protected KontaktKanalType kontaktKanal;
    @XmlElement(name = "NaermestePaaroerende")
    protected KontaktKanalType naermestePaaroerende;
    @XmlElement(name = "AndreAdresser")
    protected AdresseType andreAdresser;
    @XmlElement(name = "SoegVirkning", namespace = "urn:oio:sagdok:2.0.0")
    protected SoegVirkningType soegVirkning;

    /**
     * Gets the value of the navnStruktur property.
     * 
     * @return
     *     possible object is
     *     {@link NavnStrukturType }
     *     
     */
    public NavnStrukturType getNavnStruktur() {
        return navnStruktur;
    }

    /**
     * Sets the value of the navnStruktur property.
     * 
     * @param value
     *     allowed object is
     *     {@link NavnStrukturType }
     *     
     */
    public void setNavnStruktur(NavnStrukturType value) {
        this.navnStruktur = value;
    }

    /**
     * Gets the value of the personGenderCode property.
     * 
     * @return
     *     possible object is
     *     {@link PersonGenderCodeType }
     *     
     */
    public PersonGenderCodeType getPersonGenderCode() {
        return personGenderCode;
    }

    /**
     * Sets the value of the personGenderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonGenderCodeType }
     *     
     */
    public void setPersonGenderCode(PersonGenderCodeType value) {
        this.personGenderCode = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the foedselsregistreringMyndighedNavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoedselsregistreringMyndighedNavn() {
        return foedselsregistreringMyndighedNavn;
    }

    /**
     * Sets the value of the foedselsregistreringMyndighedNavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoedselsregistreringMyndighedNavn(String value) {
        this.foedselsregistreringMyndighedNavn = value;
    }

    /**
     * Gets the value of the foedestedNavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoedestedNavn() {
        return foedestedNavn;
    }

    /**
     * Sets the value of the foedestedNavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoedestedNavn(String value) {
        this.foedestedNavn = value;
    }

    /**
     * Gets the value of the kontaktKanal property.
     * 
     * @return
     *     possible object is
     *     {@link KontaktKanalType }
     *     
     */
    public KontaktKanalType getKontaktKanal() {
        return kontaktKanal;
    }

    /**
     * Sets the value of the kontaktKanal property.
     * 
     * @param value
     *     allowed object is
     *     {@link KontaktKanalType }
     *     
     */
    public void setKontaktKanal(KontaktKanalType value) {
        this.kontaktKanal = value;
    }

    /**
     * Gets the value of the naermestePaaroerende property.
     * 
     * @return
     *     possible object is
     *     {@link KontaktKanalType }
     *     
     */
    public KontaktKanalType getNaermestePaaroerende() {
        return naermestePaaroerende;
    }

    /**
     * Sets the value of the naermestePaaroerende property.
     * 
     * @param value
     *     allowed object is
     *     {@link KontaktKanalType }
     *     
     */
    public void setNaermestePaaroerende(KontaktKanalType value) {
        this.naermestePaaroerende = value;
    }

    /**
     * Gets the value of the andreAdresser property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseType }
     *     
     */
    public AdresseType getAndreAdresser() {
        return andreAdresser;
    }

    /**
     * Sets the value of the andreAdresser property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseType }
     *     
     */
    public void setAndreAdresser(AdresseType value) {
        this.andreAdresser = value;
    }

    /**
     * Gets the value of the soegVirkning property.
     * 
     * @return
     *     possible object is
     *     {@link SoegVirkningType }
     *     
     */
    public SoegVirkningType getSoegVirkning() {
        return soegVirkning;
    }

    /**
     * Sets the value of the soegVirkning property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegVirkningType }
     *     
     */
    public void setSoegVirkning(SoegVirkningType value) {
        this.soegVirkning = value;
    }

}
