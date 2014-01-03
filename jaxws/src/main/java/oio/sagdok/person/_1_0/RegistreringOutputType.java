
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.BasicOutputType;


/**
 * <p>Java class for RegistreringOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistreringOutputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}BasicOutputType">
 *       &lt;sequence>
 *         &lt;element name="Registrering" type="{urn:oio:sagdok:person:1.0.0}RegistreringType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistreringOutputType", propOrder = {
    "registrering"
})
public class RegistreringOutputType
    extends BasicOutputType
{

    @XmlElement(name = "Registrering")
    protected RegistreringType registrering;

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

}
