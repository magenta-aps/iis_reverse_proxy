
package dk.oio.rep.cpr_dk.xml.schemas.core._2005._03._18;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.oio.rep.cpr_dk.xml.schemas.core._2005._03._18 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StreetCode_QNAME = new QName("http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", "StreetCode");
    private final static QName _MunicipalityCode_QNAME = new QName("http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", "MunicipalityCode");
    private final static QName _StreetNameForAddressingName_QNAME = new QName("http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", "StreetNameForAddressingName");
    private final static QName _PersonCivilRegistrationIdentifier_QNAME = new QName("http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", "PersonCivilRegistrationIdentifier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.oio.rep.cpr_dk.xml.schemas.core._2005._03._18
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", name = "StreetCode")
    public JAXBElement<String> createStreetCode(String value) {
        return new JAXBElement<String>(_StreetCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", name = "MunicipalityCode")
    public JAXBElement<String> createMunicipalityCode(String value) {
        return new JAXBElement<String>(_MunicipalityCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", name = "StreetNameForAddressingName")
    public JAXBElement<String> createStreetNameForAddressingName(String value) {
        return new JAXBElement<String>(_StreetNameForAddressingName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/cpr.dk/xml/schemas/core/2005/03/18/", name = "PersonCivilRegistrationIdentifier")
    public JAXBElement<String> createPersonCivilRegistrationIdentifier(String value) {
        return new JAXBElement<String>(_PersonCivilRegistrationIdentifier_QNAME, String.class, null, value);
    }

}
