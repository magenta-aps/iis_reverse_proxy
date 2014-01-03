
package oio.sagdok._1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import oio.dkal._1_0.ArrayOfString;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oio.sagdok._1_0 package. 
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

    private final static QName _Idliste_QNAME = new QName("urn:oio:sagdok:1.0.0", "Idliste");
    private final static QName _BrugervendtNoegleTekst_QNAME = new QName("urn:oio:sagdok:1.0.0", "BrugervendtNoegleTekst");
    private final static QName _TidsstempelDatoTid_QNAME = new QName("urn:oio:sagdok:1.0.0", "TidsstempelDatoTid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oio.sagdok._1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:1.0.0", name = "Idliste")
    public JAXBElement<ArrayOfString> createIdliste(ArrayOfString value) {
        return new JAXBElement<ArrayOfString>(_Idliste_QNAME, ArrayOfString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:1.0.0", name = "BrugervendtNoegleTekst")
    public JAXBElement<String> createBrugervendtNoegleTekst(String value) {
        return new JAXBElement<String>(_BrugervendtNoegleTekst_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:1.0.0", name = "TidsstempelDatoTid")
    public JAXBElement<XMLGregorianCalendar> createTidsstempelDatoTid(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TidsstempelDatoTid_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
