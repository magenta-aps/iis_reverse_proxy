package util.cprbroker;

import javax.xml.datatype.XMLGregorianCalendar;

public interface IEffect {
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

	String actorUrn();
	String actorUuid();
	String comment();
	XMLGregorianCalendar effectiveFromDate();
	Boolean isEffectiveFromLimit();
	XMLGregorianCalendar effectiveToDate();
	Boolean isEffectiveToLimit();
}
