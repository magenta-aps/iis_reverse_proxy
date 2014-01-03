
package oio.sagdok.part._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._2_0.SagDokObjektType;
import oio.sagdok.person._1_0.PersonType;


/**
 * <p>Java class for PartType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oio:sagdok:2.0.0}SagDokObjektType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartType")
@XmlSeeAlso({
    PersonType.class
})
public class PartType
    extends SagDokObjektType
{


}
