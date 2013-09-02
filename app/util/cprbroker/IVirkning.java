package util.cprbroker;

import javax.xml.datatype.XMLGregorianCalendar;

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
	XMLGregorianCalendar fraTidspunkt();
	Boolean isFraTidspunktGraenseIndikator();
	XMLGregorianCalendar tilTidspunkt();
	Boolean isTilTidspunktGraenseIndikator();
}
