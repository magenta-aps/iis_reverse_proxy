
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.LaesOejebliksbilledeInputType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}LaesOejebliksbilledeInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "laesOejebliksbilledeInput"
})
@XmlRootElement(name = "ReadSnapshot")
public class ReadSnapshot {

    @XmlElement(name = "LaesOejebliksbilledeInput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected LaesOejebliksbilledeInputType laesOejebliksbilledeInput;

    /**
     * Gets the value of the laesOejebliksbilledeInput property.
     * 
     * @return
     *     possible object is
     *     {@link LaesOejebliksbilledeInputType }
     *     
     */
    public LaesOejebliksbilledeInputType getLaesOejebliksbilledeInput() {
        return laesOejebliksbilledeInput;
    }

    /**
     * Sets the value of the laesOejebliksbilledeInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesOejebliksbilledeInputType }
     *     
     */
    public void setLaesOejebliksbilledeInput(LaesOejebliksbilledeInputType value) {
        this.laesOejebliksbilledeInput = value;
    }

}
