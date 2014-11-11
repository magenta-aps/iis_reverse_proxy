
package itst.dk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itst.dk package. 
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

    private final static QName _ApplicationHeader_QNAME = new QName("http://dk.itst", "ApplicationHeader");
    private final static QName _QualityHeader_QNAME = new QName("http://dk.itst", "QualityHeader");
    private final static QName _SourceUsageOrderHeader_QNAME = new QName("http://dk.itst", "SourceUsageOrderHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itst.dk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApplicationHeader }
     * 
     */
    public ApplicationHeader createApplicationHeader() {
        return new ApplicationHeader();
    }

    /**
     * Create an instance of {@link SearchListResponse }
     * 
     */
    public SearchListResponse createSearchListResponse() {
        return new SearchListResponse();
    }

    /**
     * Create an instance of {@link QualityHeader }
     * 
     */
    public QualityHeader createQualityHeader() {
        return new QualityHeader();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link RefreshRead }
     * 
     */
    public RefreshRead createRefreshRead() {
        return new RefreshRead();
    }

    /**
     * Create an instance of {@link GetUuidArray }
     * 
     */
    public GetUuidArray createGetUuidArray() {
        return new GetUuidArray();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link Read }
     * 
     */
    public Read createRead() {
        return new Read();
    }

    /**
     * Create an instance of {@link ReadResponse }
     * 
     */
    public ReadResponse createReadResponse() {
        return new ReadResponse();
    }

    /**
     * Create an instance of {@link GetUuidResponse }
     * 
     */
    public GetUuidResponse createGetUuidResponse() {
        return new GetUuidResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link ReadPeriod }
     * 
     */
    public ReadPeriod createReadPeriod() {
        return new ReadPeriod();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link ReadSnapshot }
     * 
     */
    public ReadSnapshot createReadSnapshot() {
        return new ReadSnapshot();
    }

    /**
     * Create an instance of {@link RefreshReadResponse }
     * 
     */
    public RefreshReadResponse createRefreshReadResponse() {
        return new RefreshReadResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link GetUuid }
     * 
     */
    public GetUuid createGetUuid() {
        return new GetUuid();
    }

    /**
     * Create an instance of {@link ReadPeriodResponse }
     * 
     */
    public ReadPeriodResponse createReadPeriodResponse() {
        return new ReadPeriodResponse();
    }

    /**
     * Create an instance of {@link SearchList }
     * 
     */
    public SearchList createSearchList() {
        return new SearchList();
    }

    /**
     * Create an instance of {@link GetUuidArrayResponse }
     * 
     */
    public GetUuidArrayResponse createGetUuidArrayResponse() {
        return new GetUuidArrayResponse();
    }

    /**
     * Create an instance of {@link SourceUsageOrderHeader }
     * 
     */
    public SourceUsageOrderHeader createSourceUsageOrderHeader() {
        return new SourceUsageOrderHeader();
    }

    /**
     * Create an instance of {@link ReadSnapshotResponse }
     * 
     */
    public ReadSnapshotResponse createReadSnapshotResponse() {
        return new ReadSnapshotResponse();
    }

    /**
     * Create an instance of {@link ListSnapshotResponse }
     * 
     */
    public ListSnapshotResponse createListSnapshotResponse() {
        return new ListSnapshotResponse();
    }

    /**
     * Create an instance of {@link ListPeriodResponse }
     * 
     */
    public ListPeriodResponse createListPeriodResponse() {
        return new ListPeriodResponse();
    }

    /**
     * Create an instance of {@link ListSnapshot }
     * 
     */
    public ListSnapshot createListSnapshot() {
        return new ListSnapshot();
    }

    /**
     * Create an instance of {@link ListPeriod }
     * 
     */
    public ListPeriod createListPeriod() {
        return new ListPeriod();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dk.itst", name = "ApplicationHeader")
    public JAXBElement<ApplicationHeader> createApplicationHeader(ApplicationHeader value) {
        return new JAXBElement<ApplicationHeader>(_ApplicationHeader_QNAME, ApplicationHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QualityHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dk.itst", name = "QualityHeader")
    public JAXBElement<QualityHeader> createQualityHeader(QualityHeader value) {
        return new JAXBElement<QualityHeader>(_QualityHeader_QNAME, QualityHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceUsageOrderHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dk.itst", name = "SourceUsageOrderHeader")
    public JAXBElement<SourceUsageOrderHeader> createSourceUsageOrderHeader(SourceUsageOrderHeader value) {
        return new JAXBElement<SourceUsageOrderHeader>(_SourceUsageOrderHeader_QNAME, SourceUsageOrderHeader.class, null, value);
    }

}
