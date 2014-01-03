
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.ListPeriodInputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}ListPeriodInput" minOccurs="0"/>
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
    "listPeriodInput"
})
@XmlRootElement(name = "ListPeriod")
public class ListPeriod {

    @XmlElement(name = "ListPeriodInput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected ListPeriodInputType listPeriodInput;

    /**
     * Gets the value of the listPeriodInput property.
     * 
     * @return
     *     possible object is
     *     {@link ListPeriodInputType }
     *     
     */
    public ListPeriodInputType getListPeriodInput() {
        return listPeriodInput;
    }

    /**
     * Sets the value of the listPeriodInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListPeriodInputType }
     *     
     */
    public void setListPeriodInput(ListPeriodInputType value) {
        this.listPeriodInput = value;
    }

}
