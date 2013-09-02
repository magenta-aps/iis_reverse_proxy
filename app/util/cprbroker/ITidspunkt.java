package util.cprbroker;

import javax.xml.datatype.XMLGregorianCalendar;

public interface ITidspunkt {
/*
	laesOutput.getLaesResultat().getRegistrering().getAktoerRef().getURNIdentifikator();
	laesOutput.getLaesResultat().getRegistrering().getAktoerRef().getUUID();
	laesOutput.getLaesResultat().getRegistrering().getCommentText();
	laesOutput.getLaesResultat().getRegistrering().getLivscyklusKode();
	laesOutput.getLaesResultat().getRegistrering().getTidspunkt().getTidsstempelDatoTid();
	laesOutput.getLaesResultat().getRegistrering().getTidspunkt().isGraenseIndikator();
	
*/
	String aktoerRefUrn();
	String aktoerRefUuid();
	String kommentar();
	String livscyklusKode();
	XMLGregorianCalendar tidspunkt();
	Boolean isTidspunktGraenseIndikator();

}
