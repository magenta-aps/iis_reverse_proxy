
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOejebliksbilledeInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOejebliksbilledeInputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:person:1.0.0}OejebliksbilledeInputType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oio:dkal:1.0.0}UUID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOejebliksbilledeInputType", propOrder = {
    "uuid"
})
public class ListOejebliksbilledeInputType
    extends OejebliksbilledeInputType
{

    @XmlElement(name = "UUID", namespace = "urn:oio:dkal:1.0.0")
    protected List<String> uuid;

    /**
     * Gets the value of the uuid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUUID() {
        if (uuid == null) {
            uuid = new ArrayList<String>();
        }
        return this.uuid;
    }

}
