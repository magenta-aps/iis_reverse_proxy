
package dk.oio.rep.ebxml.xml.schemas.dkcc._2003._02._13;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for CountryIdentificationCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CountryIdentificationCodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="scheme" use="required" type="{http://rep.oio.dk/ebxml/xml/schemas/dkcc/2003/02/13/}_CountryIdentificationSchemeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryIdentificationCodeType", propOrder = {
    "value"
})
public class CountryIdentificationCodeType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "scheme", required = true)
    protected CountryIdentificationSchemeType scheme;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the scheme property.
     * 
     * @return
     *     possible object is
     *     {@link CountryIdentificationSchemeType }
     *     
     */
    public CountryIdentificationSchemeType getScheme() {
        return scheme;
    }

    /**
     * Sets the value of the scheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryIdentificationSchemeType }
     *     
     */
    public void setScheme(CountryIdentificationSchemeType value) {
        this.scheme = value;
    }

}
