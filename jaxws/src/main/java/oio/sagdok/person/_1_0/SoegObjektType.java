
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.SoegSagDokObjektType;


/**
 * <p>Java class for SoegObjektType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegObjektType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}SoegSagDokObjektType">
 *       &lt;sequence>
 *         &lt;element name="SoegAttributListe" type="{urn:oio:sagdok:person:1.0.0}SoegAttributListeType" minOccurs="0"/>
 *         &lt;element name="SoegTilstandListe" type="{urn:oio:sagdok:person:1.0.0}SoegTilstandListeType" minOccurs="0"/>
 *         &lt;element name="SoegRelationListe" type="{urn:oio:sagdok:person:1.0.0}SoegRelationListeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegObjektType", propOrder = {
    "soegAttributListe",
    "soegTilstandListe",
    "soegRelationListe"
})
public class SoegObjektType
    extends SoegSagDokObjektType
{

    @XmlElement(name = "SoegAttributListe")
    protected SoegAttributListeType soegAttributListe;
    @XmlElement(name = "SoegTilstandListe")
    protected SoegTilstandListeType soegTilstandListe;
    @XmlElement(name = "SoegRelationListe")
    protected SoegRelationListeType soegRelationListe;

    /**
     * Gets the value of the soegAttributListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegAttributListeType }
     *     
     */
    public SoegAttributListeType getSoegAttributListe() {
        return soegAttributListe;
    }

    /**
     * Sets the value of the soegAttributListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegAttributListeType }
     *     
     */
    public void setSoegAttributListe(SoegAttributListeType value) {
        this.soegAttributListe = value;
    }

    /**
     * Gets the value of the soegTilstandListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegTilstandListeType }
     *     
     */
    public SoegTilstandListeType getSoegTilstandListe() {
        return soegTilstandListe;
    }

    /**
     * Sets the value of the soegTilstandListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegTilstandListeType }
     *     
     */
    public void setSoegTilstandListe(SoegTilstandListeType value) {
        this.soegTilstandListe = value;
    }

    /**
     * Gets the value of the soegRelationListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegRelationListeType }
     *     
     */
    public SoegRelationListeType getSoegRelationListe() {
        return soegRelationListe;
    }

    /**
     * Sets the value of the soegRelationListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegRelationListeType }
     *     
     */
    public void setSoegRelationListe(SoegRelationListeType value) {
        this.soegRelationListe = value;
    }

}
