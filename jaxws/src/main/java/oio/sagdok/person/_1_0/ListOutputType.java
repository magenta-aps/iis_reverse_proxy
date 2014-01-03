
package oio.sagdok.person._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOutputType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}ListOutputType">
 *       &lt;sequence>
 *         &lt;element name="LaesResultat" type="{urn:oio:sagdok:person:1.0.0}LaesResultatType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOutputType", propOrder = {
    "laesResultat"
})
public class ListOutputType
    extends oio.sagdok._2_0.ListOutputType
{

    @XmlElement(name = "LaesResultat")
    protected List<LaesResultatType> laesResultat;

    /**
     * Gets the value of the laesResultat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laesResultat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaesResultat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LaesResultatType }
     * 
     * 
     */
    public List<LaesResultatType> getLaesResultat() {
        if (laesResultat == null) {
            laesResultat = new ArrayList<LaesResultatType>();
        }
        return this.laesResultat;
    }

}
