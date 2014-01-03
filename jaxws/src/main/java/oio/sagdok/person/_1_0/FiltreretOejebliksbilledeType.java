
package oio.sagdok.person._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.LaesFiltreretOutputType;


/**
 * <p>Java class for FiltreretOejebliksbilledeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FiltreretOejebliksbilledeType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}LaesFiltreretOutputType">
 *       &lt;sequence>
 *         &lt;element name="AttributListe" type="{urn:oio:sagdok:person:1.0.0}AttributListeType" minOccurs="0"/>
 *         &lt;element name="TilstandListe" type="{urn:oio:sagdok:person:1.0.0}TilstandListeType" minOccurs="0"/>
 *         &lt;element name="RelationListe" type="{urn:oio:sagdok:person:1.0.0}RelationListeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiltreretOejebliksbilledeType", propOrder = {
    "attributListe",
    "tilstandListe",
    "relationListe"
})
public class FiltreretOejebliksbilledeType
    extends LaesFiltreretOutputType
{

    @XmlElement(name = "AttributListe")
    protected AttributListeType attributListe;
    @XmlElement(name = "TilstandListe")
    protected TilstandListeType tilstandListe;
    @XmlElement(name = "RelationListe")
    protected RelationListeType relationListe;

    /**
     * Gets the value of the attributListe property.
     * 
     * @return
     *     possible object is
     *     {@link AttributListeType }
     *     
     */
    public AttributListeType getAttributListe() {
        return attributListe;
    }

    /**
     * Sets the value of the attributListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributListeType }
     *     
     */
    public void setAttributListe(AttributListeType value) {
        this.attributListe = value;
    }

    /**
     * Gets the value of the tilstandListe property.
     * 
     * @return
     *     possible object is
     *     {@link TilstandListeType }
     *     
     */
    public TilstandListeType getTilstandListe() {
        return tilstandListe;
    }

    /**
     * Sets the value of the tilstandListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TilstandListeType }
     *     
     */
    public void setTilstandListe(TilstandListeType value) {
        this.tilstandListe = value;
    }

    /**
     * Gets the value of the relationListe property.
     * 
     * @return
     *     possible object is
     *     {@link RelationListeType }
     *     
     */
    public RelationListeType getRelationListe() {
        return relationListe;
    }

    /**
     * Sets the value of the relationListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationListeType }
     *     
     */
    public void setRelationListe(RelationListeType value) {
        this.relationListe = value;
    }

}
