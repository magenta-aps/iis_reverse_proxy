
package oio.sagdok._2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistreringType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistreringType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tidspunkt" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *         &lt;element name="LivscyklusKode" type="{urn:oio:sagdok:2.0.0}LivscyklusKodeType"/>
 *         &lt;element name="AktoerRef" type="{urn:oio:sagdok:2.0.0}UnikIdType" minOccurs="0"/>
 *         &lt;element ref="{http://rep.oio.dk/vejsektoren.dk/core/schemas/xml/2007/03/31/}CommentText" minOccurs="0"/>
 *         &lt;element name="Virkning" type="{urn:oio:sagdok:2.0.0}VirkningType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistreringType", propOrder = {
    "tidspunkt",
    "livscyklusKode",
    "aktoerRef",
    "commentText",
    "virkning"
})
@XmlSeeAlso({
    oio.sagdok.person._1_0.RegistreringType.class
})
public class RegistreringType {

    @XmlElement(name = "Tidspunkt")
    protected TidspunktType tidspunkt;
    @XmlElement(name = "LivscyklusKode", required = true)
    @XmlSchemaType(name = "string")
    protected LivscyklusKodeType livscyklusKode;
    @XmlElement(name = "AktoerRef")
    protected UnikIdType aktoerRef;
    @XmlElement(name = "CommentText", namespace = "http://rep.oio.dk/vejsektoren.dk/core/schemas/xml/2007/03/31/")
    protected String commentText;
    @XmlElement(name = "Virkning")
    protected List<VirkningType> virkning;

    /**
     * Gets the value of the tidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getTidspunkt() {
        return tidspunkt;
    }

    /**
     * Sets the value of the tidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setTidspunkt(TidspunktType value) {
        this.tidspunkt = value;
    }

    /**
     * Gets the value of the livscyklusKode property.
     * 
     * @return
     *     possible object is
     *     {@link LivscyklusKodeType }
     *     
     */
    public LivscyklusKodeType getLivscyklusKode() {
        return livscyklusKode;
    }

    /**
     * Sets the value of the livscyklusKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LivscyklusKodeType }
     *     
     */
    public void setLivscyklusKode(LivscyklusKodeType value) {
        this.livscyklusKode = value;
    }

    /**
     * Gets the value of the aktoerRef property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getAktoerRef() {
        return aktoerRef;
    }

    /**
     * Sets the value of the aktoerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setAktoerRef(UnikIdType value) {
        this.aktoerRef = value;
    }

    /**
     * Gets the value of the commentText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Sets the value of the commentText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentText(String value) {
        this.commentText = value;
    }

    /**
     * Gets the value of the virkning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virkning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirkning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirkningType }
     * 
     * 
     */
    public List<VirkningType> getVirkning() {
        if (virkning == null) {
            virkning = new ArrayList<VirkningType>();
        }
        return this.virkning;
    }

}
