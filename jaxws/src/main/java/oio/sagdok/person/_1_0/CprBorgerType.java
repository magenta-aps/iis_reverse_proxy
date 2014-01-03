
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import dk.oio.rep.ebxml.xml.schemas.dkcc._2003._02._13.CountryIdentificationCodeType;


/**
 * <p>Java class for CprBorgerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CprBorgerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/}PersonCivilRegistrationIdentifier" minOccurs="0"/>
 *         &lt;element name="PersonNummerGyldighedStatusIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://rep.oio.dk/ebxml/xml/schemas/dkcc/2006/01/03/}PersonNationalityCode" minOccurs="0"/>
 *         &lt;element name="NavneAdresseBeskyttelseIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TelefonNummerBeskyttelseIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ForskerBeskyttelseIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FolkeregisterAdresse" type="{urn:oio:sagdok:person:1.0.0}AdresseType" minOccurs="0"/>
 *         &lt;element name="AdresseNoteTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FolkekirkeMedlemIndikator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CprBorgerType", propOrder = {
    "personCivilRegistrationIdentifier",
    "personNummerGyldighedStatusIndikator",
    "personNationalityCode",
    "navneAdresseBeskyttelseIndikator",
    "telefonNummerBeskyttelseIndikator",
    "forskerBeskyttelseIndikator",
    "folkeregisterAdresse",
    "adresseNoteTekst",
    "folkekirkeMedlemIndikator"
})
public class CprBorgerType {

    @XmlElement(name = "PersonCivilRegistrationIdentifier", namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/")
    protected String personCivilRegistrationIdentifier;
    @XmlElement(name = "PersonNummerGyldighedStatusIndikator")
    protected boolean personNummerGyldighedStatusIndikator;
    @XmlElement(name = "PersonNationalityCode", namespace = "http://rep.oio.dk/ebxml/xml/schemas/dkcc/2006/01/03/")
    protected CountryIdentificationCodeType personNationalityCode;
    @XmlElement(name = "NavneAdresseBeskyttelseIndikator")
    protected boolean navneAdresseBeskyttelseIndikator;
    @XmlElement(name = "TelefonNummerBeskyttelseIndikator")
    protected boolean telefonNummerBeskyttelseIndikator;
    @XmlElement(name = "ForskerBeskyttelseIndikator")
    protected boolean forskerBeskyttelseIndikator;
    @XmlElement(name = "FolkeregisterAdresse")
    protected AdresseType folkeregisterAdresse;
    @XmlElement(name = "AdresseNoteTekst")
    protected String adresseNoteTekst;
    @XmlElement(name = "FolkekirkeMedlemIndikator")
    protected boolean folkekirkeMedlemIndikator;

    /**
     * Gets the value of the personCivilRegistrationIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonCivilRegistrationIdentifier() {
        return personCivilRegistrationIdentifier;
    }

    /**
     * Sets the value of the personCivilRegistrationIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonCivilRegistrationIdentifier(String value) {
        this.personCivilRegistrationIdentifier = value;
    }

    /**
     * Gets the value of the personNummerGyldighedStatusIndikator property.
     * 
     */
    public boolean isPersonNummerGyldighedStatusIndikator() {
        return personNummerGyldighedStatusIndikator;
    }

    /**
     * Sets the value of the personNummerGyldighedStatusIndikator property.
     * 
     */
    public void setPersonNummerGyldighedStatusIndikator(boolean value) {
        this.personNummerGyldighedStatusIndikator = value;
    }

    /**
     * Gets the value of the personNationalityCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountryIdentificationCodeType }
     *     
     */
    public CountryIdentificationCodeType getPersonNationalityCode() {
        return personNationalityCode;
    }

    /**
     * Sets the value of the personNationalityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryIdentificationCodeType }
     *     
     */
    public void setPersonNationalityCode(CountryIdentificationCodeType value) {
        this.personNationalityCode = value;
    }

    /**
     * Gets the value of the navneAdresseBeskyttelseIndikator property.
     * 
     */
    public boolean isNavneAdresseBeskyttelseIndikator() {
        return navneAdresseBeskyttelseIndikator;
    }

    /**
     * Sets the value of the navneAdresseBeskyttelseIndikator property.
     * 
     */
    public void setNavneAdresseBeskyttelseIndikator(boolean value) {
        this.navneAdresseBeskyttelseIndikator = value;
    }

    /**
     * Gets the value of the telefonNummerBeskyttelseIndikator property.
     * 
     */
    public boolean isTelefonNummerBeskyttelseIndikator() {
        return telefonNummerBeskyttelseIndikator;
    }

    /**
     * Sets the value of the telefonNummerBeskyttelseIndikator property.
     * 
     */
    public void setTelefonNummerBeskyttelseIndikator(boolean value) {
        this.telefonNummerBeskyttelseIndikator = value;
    }

    /**
     * Gets the value of the forskerBeskyttelseIndikator property.
     * 
     */
    public boolean isForskerBeskyttelseIndikator() {
        return forskerBeskyttelseIndikator;
    }

    /**
     * Sets the value of the forskerBeskyttelseIndikator property.
     * 
     */
    public void setForskerBeskyttelseIndikator(boolean value) {
        this.forskerBeskyttelseIndikator = value;
    }

    /**
     * Gets the value of the folkeregisterAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseType }
     *     
     */
    public AdresseType getFolkeregisterAdresse() {
        return folkeregisterAdresse;
    }

    /**
     * Sets the value of the folkeregisterAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseType }
     *     
     */
    public void setFolkeregisterAdresse(AdresseType value) {
        this.folkeregisterAdresse = value;
    }

    /**
     * Gets the value of the adresseNoteTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseNoteTekst() {
        return adresseNoteTekst;
    }

    /**
     * Sets the value of the adresseNoteTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseNoteTekst(String value) {
        this.adresseNoteTekst = value;
    }

    /**
     * Gets the value of the folkekirkeMedlemIndikator property.
     * 
     */
    public boolean isFolkekirkeMedlemIndikator() {
        return folkekirkeMedlemIndikator;
    }

    /**
     * Sets the value of the folkekirkeMedlemIndikator property.
     * 
     */
    public void setFolkekirkeMedlemIndikator(boolean value) {
        this.folkekirkeMedlemIndikator = value;
    }

}
