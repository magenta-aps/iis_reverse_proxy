package util.cprbroker;

import org.joda.time.DateTime;
/**
 * Wrapper for a CPR Broker Virkning response
 * @author Søren Kirkegård
 *
 */
public interface IVirkning {
	/**************************************************************************************
	// TODO implement these
	attributes.getVirkning().getAktoerRef().getURNIdentifikator();
	attributes.getVirkning().getAktoerRef().getUUID();
	attributes.getVirkning().getCommentText();
	attributes.getVirkning().getFraTidspunkt().getTidsstempelDatoTid();
	attributes.getVirkning().getFraTidspunkt().isGraenseIndikator();
	attributes.getVirkning().getTilTidspunkt().getTidsstempelDatoTid();
	attributes.getVirkning().getTilTidspunkt().isGraenseIndikator();

 	******************************************************************************************/

	String aktoerRefUrn();
	String aktoerRefUuid();
	String kommentar();
	DateTime fraTidspunkt();
	Boolean isFraTidspunktGraenseIndikator();
	DateTime tilTidspunkt();
	Boolean isTilTidspunktGraenseIndikator();
}
