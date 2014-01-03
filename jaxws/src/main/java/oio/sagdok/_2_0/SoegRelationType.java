
package oio.sagdok._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegRelationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegRelationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoegVirkning" type="{urn:oio:sagdok:2.0.0}SoegVirkningType" minOccurs="0"/>
 *         &lt;element name="ReferenceID" type="{urn:oio:sagdok:2.0.0}UnikIdType" minOccurs="0"/>
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
@XmlType(name = "SoegRelationType", propOrder = {
    "soegVirkning",
    "referenceID",
    "commentText"
})
public class SoegRelationType {

    @XmlElement(name = "SoegVirkning")
    protected SoegVirkningType soegVirkning;
    @XmlElement(name = "ReferenceID")
    protected UnikIdType referenceID;
    @XmlElement(name = "CommentText", namespace = "http://rep.oio.dk/vejsektoren.dk/core/schemas/xml/2007/03/31/")
    protected String commentText;

    /**
     * Gets the value of the soegVirkning property.
     * 
     * @return
     *     possible object is
     *     {@link SoegVirkningType }
     *     
     */
    public SoegVirkningType getSoegVirkning() {
        return soegVirkning;
    }

    /**
     * Sets the value of the soegVirkning property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegVirkningType }
     *     
     */
    public void setSoegVirkning(SoegVirkningType value) {
        this.soegVirkning = value;
    }

    /**
     * Gets the value of the referenceID property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the value of the referenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setReferenceID(UnikIdType value) {
        this.referenceID = value;
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
