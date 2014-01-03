
package dk.oio.rep.ebxml.xml.schemas.dkcc._2005._05._13;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.oio.rep.ebxml.xml.schemas.dkcc._2005._05._13 package. 
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

    private final static QName _PostOfficeBoxIdentifier_QNAME = new QName("http://rep.oio.dk/ebxml/xml/schemas/dkcc/2005/05/13/", "PostOfficeBoxIdentifier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.oio.rep.ebxml.xml.schemas.dkcc._2005._05._13
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/ebxml/xml/schemas/dkcc/2005/05/13/", name = "PostOfficeBoxIdentifier")
    public JAXBElement<BigInteger> createPostOfficeBoxIdentifier(BigInteger value) {
        return new JAXBElement<BigInteger>(_PostOfficeBoxIdentifier_QNAME, BigInteger.class, null, value);
    }

}
