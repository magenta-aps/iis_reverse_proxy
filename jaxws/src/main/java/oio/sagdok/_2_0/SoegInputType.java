
package oio.sagdok._2_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegInputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FoersteResultatReference" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="MaksimalAntalKvantitet" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegInputType", propOrder = {
    "foersteResultatReference",
    "maksimalAntalKvantitet"
})
@XmlSeeAlso({
    oio.sagdok.person._1_0.SoegInputType.class
})
public class SoegInputType {

    @XmlElement(name = "FoersteResultatReference")
    protected BigInteger foersteResultatReference;
    @XmlElement(name = "MaksimalAntalKvantitet")
    protected BigInteger maksimalAntalKvantitet;

    /**
     * Gets the value of the foersteResultatReference property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFoersteResultatReference() {
        return foersteResultatReference;
    }

    /**
     * Sets the value of the foersteResultatReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFoersteResultatReference(BigInteger value) {
        this.foersteResultatReference = value;
    }

    /**
     * Gets the value of the maksimalAntalKvantitet property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaksimalAntalKvantitet() {
        return maksimalAntalKvantitet;
    }

    /**
     * Sets the value of the maksimalAntalKvantitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaksimalAntalKvantitet(BigInteger value) {
        this.maksimalAntalKvantitet = value;
    }

}
