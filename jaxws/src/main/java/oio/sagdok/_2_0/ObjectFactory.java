
package oio.sagdok._2_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oio.sagdok._2_0 package. 
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

    private final static QName _LokalUdvidelse_QNAME = new QName("urn:oio:sagdok:2.0.0", "LokalUdvidelse");
    private final static QName _NoteTekst_QNAME = new QName("urn:oio:sagdok:2.0.0", "NoteTekst");
    private final static QName _ListInput_QNAME = new QName("urn:oio:sagdok:2.0.0", "ListInput");
    private final static QName _TilstandVirkning_QNAME = new QName("urn:oio:sagdok:2.0.0", "TilstandVirkning");
    private final static QName _KaldenavnTekst_QNAME = new QName("urn:oio:sagdok:2.0.0", "KaldenavnTekst");
    private final static QName _Virkning_QNAME = new QName("urn:oio:sagdok:2.0.0", "Virkning");
    private final static QName _SoegVirkning_QNAME = new QName("urn:oio:sagdok:2.0.0", "SoegVirkning");
    private final static QName _LaesInput_QNAME = new QName("urn:oio:sagdok:2.0.0", "LaesInput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oio.sagdok._2_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SoegOutputType }
     * 
     */
    public SoegOutputType createSoegOutputType() {
        return new SoegOutputType();
    }

    /**
     * Create an instance of {@link LaesInputType }
     * 
     */
    public LaesInputType createLaesInputType() {
        return new LaesInputType();
    }

    /**
     * Create an instance of {@link ListInputType }
     * 
     */
    public ListInputType createListInputType() {
        return new ListInputType();
    }

    /**
     * Create an instance of {@link VirkningType }
     * 
     */
    public VirkningType createVirkningType() {
        return new VirkningType();
    }

    /**
     * Create an instance of {@link SoegVirkningType }
     * 
     */
    public SoegVirkningType createSoegVirkningType() {
        return new SoegVirkningType();
    }

    /**
     * Create an instance of {@link LokalUdvidelseType }
     * 
     */
    public LokalUdvidelseType createLokalUdvidelseType() {
        return new LokalUdvidelseType();
    }

    /**
     * Create an instance of {@link TilstandVirkningType }
     * 
     */
    public TilstandVirkningType createTilstandVirkningType() {
        return new TilstandVirkningType();
    }

    /**
     * Create an instance of {@link TidspunktType }
     * 
     */
    public TidspunktType createTidspunktType() {
        return new TidspunktType();
    }

    /**
     * Create an instance of {@link SoegSagDokObjektType }
     * 
     */
    public SoegSagDokObjektType createSoegSagDokObjektType() {
        return new SoegSagDokObjektType();
    }

    /**
     * Create an instance of {@link SoegInputType }
     * 
     */
    public SoegInputType createSoegInputType() {
        return new SoegInputType();
    }

    /**
     * Create an instance of {@link RegistreringType }
     * 
     */
    public RegistreringType createRegistreringType() {
        return new RegistreringType();
    }

    /**
     * Create an instance of {@link SoegRelationType }
     * 
     */
    public SoegRelationType createSoegRelationType() {
        return new SoegRelationType();
    }

    /**
     * Create an instance of {@link ListOutputType }
     * 
     */
    public ListOutputType createListOutputType() {
        return new ListOutputType();
    }

    /**
     * Create an instance of {@link PersonFlerRelationType }
     * 
     */
    public PersonFlerRelationType createPersonFlerRelationType() {
        return new PersonFlerRelationType();
    }

    /**
     * Create an instance of {@link UnikIdType }
     * 
     */
    public UnikIdType createUnikIdType() {
        return new UnikIdType();
    }

    /**
     * Create an instance of {@link BasicOutputType }
     * 
     */
    public BasicOutputType createBasicOutputType() {
        return new BasicOutputType();
    }

    /**
     * Create an instance of {@link SoegRegistreringType }
     * 
     */
    public SoegRegistreringType createSoegRegistreringType() {
        return new SoegRegistreringType();
    }

    /**
     * Create an instance of {@link StandardReturType }
     * 
     */
    public StandardReturType createStandardReturType() {
        return new StandardReturType();
    }

    /**
     * Create an instance of {@link RelationType }
     * 
     */
    public RelationType createRelationType() {
        return new RelationType();
    }

    /**
     * Create an instance of {@link FlerRelationType }
     * 
     */
    public FlerRelationType createFlerRelationType() {
        return new FlerRelationType();
    }

    /**
     * Create an instance of {@link LaesFiltreretOutputType }
     * 
     */
    public LaesFiltreretOutputType createLaesFiltreretOutputType() {
        return new LaesFiltreretOutputType();
    }

    /**
     * Create an instance of {@link SagDokObjektType }
     * 
     */
    public SagDokObjektType createSagDokObjektType() {
        return new SagDokObjektType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LokalUdvidelseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "LokalUdvidelse")
    public JAXBElement<LokalUdvidelseType> createLokalUdvidelse(LokalUdvidelseType value) {
        return new JAXBElement<LokalUdvidelseType>(_LokalUdvidelse_QNAME, LokalUdvidelseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "NoteTekst")
    public JAXBElement<String> createNoteTekst(String value) {
        return new JAXBElement<String>(_NoteTekst_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "ListInput")
    public JAXBElement<ListInputType> createListInput(ListInputType value) {
        return new JAXBElement<ListInputType>(_ListInput_QNAME, ListInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TilstandVirkningType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "TilstandVirkning")
    public JAXBElement<TilstandVirkningType> createTilstandVirkning(TilstandVirkningType value) {
        return new JAXBElement<TilstandVirkningType>(_TilstandVirkning_QNAME, TilstandVirkningType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "KaldenavnTekst")
    public JAXBElement<String> createKaldenavnTekst(String value) {
        return new JAXBElement<String>(_KaldenavnTekst_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VirkningType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "Virkning")
    public JAXBElement<VirkningType> createVirkning(VirkningType value) {
        return new JAXBElement<VirkningType>(_Virkning_QNAME, VirkningType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegVirkningType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "SoegVirkning")
    public JAXBElement<SoegVirkningType> createSoegVirkning(SoegVirkningType value) {
        return new JAXBElement<SoegVirkningType>(_SoegVirkning_QNAME, SoegVirkningType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaesInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oio:sagdok:2.0.0", name = "LaesInput")
    public JAXBElement<LaesInputType> createLaesInput(LaesInputType value) {
        return new JAXBElement<LaesInputType>(_LaesInput_QNAME, LaesInputType.class, null, value);
    }

}
