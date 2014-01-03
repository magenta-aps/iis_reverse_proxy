
package itst.dk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok.person._1_0.ListOejebliksbilledeInputType;


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
 *         &lt;element ref="{urn:oio:sagdok:person:1.0.0}ListOejebliksbilledeInput" minOccurs="0"/>
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
    "listOejebliksbilledeInput"
})
@XmlRootElement(name = "ListSnapshot")
public class ListSnapshot {

    @XmlElement(name = "ListOejebliksbilledeInput", namespace = "urn:oio:sagdok:person:1.0.0")
    protected ListOejebliksbilledeInputType listOejebliksbilledeInput;

    /**
     * Gets the value of the listOejebliksbilledeInput property.
     * 
     * @return
     *     possible object is
     *     {@link ListOejebliksbilledeInputType }
     *     
     */
    public ListOejebliksbilledeInputType getListOejebliksbilledeInput() {
        return listOejebliksbilledeInput;
    }

    /**
     * Sets the value of the listOejebliksbilledeInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOejebliksbilledeInputType }
     *     
     */
    public void setListOejebliksbilledeInput(ListOejebliksbilledeInputType value) {
        this.listOejebliksbilledeInput = value;
    }

}
