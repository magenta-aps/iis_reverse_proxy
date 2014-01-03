
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegRegistreringType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegRegistreringType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tidspunkt" type="{urn:oio:sagdok:2.0.0}TidspunktType" minOccurs="0"/>
 *         &lt;element name="LivscyklusKode" type="{urn:oio:sagdok:2.0.0}LivscyklusKodeType" minOccurs="0"/>
 *         &lt;element name="AktoerRef" type="{urn:oio:sagdok:2.0.0}UnikIdType" minOccurs="0"/>
 *         &lt;element ref="{http://rep.oio.dk/vejsektoren.dk/core/schemas/xml/2007/03/31/}CommentText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegRegistreringType", propOrder = {
    "tidspunkt",
    "livscyklusKode",
    "aktoerRef",
    "commentText"
})
public class SoegRegistreringType {

    @XmlElement(name = "Tidspunkt")
    protected TidspunktType tidspunkt;
    @XmlElement(name = "LivscyklusKode")
    protected LivscyklusKodeType livscyklusKode;
    @XmlElement(name = "AktoerRef")
    protected UnikIdType aktoerRef;
    @XmlElement(name = "CommentText", namespace = "http://rep.oio.dk/vejsektoren.dk/core/schemas/xml/2007/03/31/")
    protected String commentText;

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

}
