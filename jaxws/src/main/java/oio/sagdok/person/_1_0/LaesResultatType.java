
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LaesResultatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaesResultatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Registrering" type="{urn:oio:sagdok:person:1.0.0}RegistreringType" minOccurs="0"/>
 *           &lt;element name="FiltreretOejebliksbillede" type="{urn:oio:sagdok:person:1.0.0}FiltreretOejebliksbilledeType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaesResultatType", propOrder = {
    "registrering",
    "filtreretOejebliksbillede"
})
public class LaesResultatType {

    @XmlElement(name = "Registrering")
    protected RegistreringType registrering;
    @XmlElement(name = "FiltreretOejebliksbillede")
    protected FiltreretOejebliksbilledeType filtreretOejebliksbillede;

    /**
     * Gets the value of the registrering property.
     * 
     * @return
     *     possible object is
     *     {@link RegistreringType }
     *     
     */
    public RegistreringType getRegistrering() {
        return registrering;
    }

    /**
     * Sets the value of the registrering property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistreringType }
     *     
     */
    public void setRegistrering(RegistreringType value) {
        this.registrering = value;
    }

    /**
     * Gets the value of the filtreretOejebliksbillede property.
     * 
     * @return
     *     possible object is
     *     {@link FiltreretOejebliksbilledeType }
     *     
     */
    public FiltreretOejebliksbilledeType getFiltreretOejebliksbillede() {
        return filtreretOejebliksbillede;
    }

    /**
     * Sets the value of the filtreretOejebliksbillede property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltreretOejebliksbilledeType }
     *     
     */
    public void setFiltreretOejebliksbillede(FiltreretOejebliksbilledeType value) {
        this.filtreretOejebliksbillede = value;
    }

}
