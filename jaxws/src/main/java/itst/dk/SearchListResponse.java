
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.SoegListOutputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}SoegListOutput" minOccurs="0"/>
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
    "soegListOutput"
})
@XmlRootElement(name = "SearchListResponse")
public class SearchListResponse {

    @XmlElement(name = "SoegListOutput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected SoegListOutputType soegListOutput;

    /**
     * Gets the value of the soegListOutput property.
     * 
     * @return
     *     possible object is
     *     {@link SoegListOutputType }
     *     
     */
    public SoegListOutputType getSoegListOutput() {
        return soegListOutput;
    }

    /**
     * Sets the value of the soegListOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegListOutputType }
     *     
     */
    public void setSoegListOutput(SoegListOutputType value) {
        this.soegListOutput = value;
    }

}
