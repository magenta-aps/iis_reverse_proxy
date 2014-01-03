
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.ListOutputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}ListOutput" minOccurs="0"/>
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
    "listOutput"
})
@XmlRootElement(name = "ListSnapshotResponse")
public class ListSnapshotResponse {

    @XmlElement(name = "ListOutput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected ListOutputType listOutput;

    /**
     * Gets the value of the listOutput property.
     * 
     * @return
     *     possible object is
     *     {@link ListOutputType }
     *     
     */
    public ListOutputType getListOutput() {
        return listOutput;
    }

    /**
     * Sets the value of the listOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOutputType }
     *     
     */
    public void setListOutput(ListOutputType value) {
        this.listOutput = value;
    }

}
