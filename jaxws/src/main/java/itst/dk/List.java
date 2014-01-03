
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.ListInputType;


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
 *         &lt;element ref="{urn:oio:sagdok:2.0.0}ListInput" minOccurs="0"/>
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
    "listInput"
})
@XmlRootElement(name = "List")
public class List {

    @XmlElement(name = "ListInput", namespace = "urn:oio:sagdok:2.0.0")
    protected ListInputType listInput;

    /**
     * Gets the value of the listInput property.
     * 
     * @return
     *     possible object is
     *     {@link ListInputType }
     *     
     */
    public ListInputType getListInput() {
        return listInput;
    }

    /**
     * Sets the value of the listInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListInputType }
     *     
     */
    public void setListInput(ListInputType value) {
        this.listInput = value;
    }

}
