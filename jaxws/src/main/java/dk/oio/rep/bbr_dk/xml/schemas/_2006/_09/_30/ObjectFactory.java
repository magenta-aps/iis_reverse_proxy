
package dk.oio.rep.bbr_dk.xml.schemas._2006._09._30;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.oio.rep.bbr_dk.xml.schemas._2006._09._30 package. 
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

    private final static QName _AddressPoint_QNAME = new QName("http://rep.oio.dk/bbr.dk/xml/schemas/2006/09/30/", "AddressPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.oio.rep.bbr_dk.xml.schemas._2006._09._30
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddressPointType }
     * 
     */
    public AddressPointType createAddressPointType() {
        return new AddressPointType();
    }

    /**
     * Create an instance of {@link GeographicCoordinateTupleType }
     * 
     */
    public GeographicCoordinateTupleType createGeographicCoordinateTupleType() {
        return new GeographicCoordinateTupleType();
    }

    /**
     * Create an instance of {@link AddressPointStatusStructureType }
     * 
     */
    public AddressPointStatusStructureType createAddressPointStatusStructureType() {
        return new AddressPointStatusStructureType();
    }

    /**
     * Create an instance of {@link GeographicPointLocationType }
     * 
     */
    public GeographicPointLocationType createGeographicPointLocationType() {
        return new GeographicPointLocationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressPointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rep.oio.dk/bbr.dk/xml/schemas/2006/09/30/", name = "AddressPoint")
    public JAXBElement<AddressPointType> createAddressPoint(AddressPointType value) {
        return new JAXBElement<AddressPointType>(_AddressPoint_QNAME, AddressPointType.class, null, value);
    }

}
