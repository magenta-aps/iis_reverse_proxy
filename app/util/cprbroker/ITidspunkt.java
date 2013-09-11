package util.cprbroker;

import org.joda.time.DateTime;

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
	DateTime tidspunkt();
	Boolean isTidspunktGraenseIndikator();
	String sourceName();
}
