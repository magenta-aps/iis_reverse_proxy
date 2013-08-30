package util.cprbroker;

public interface ITilstand {

	/* condition/status?
	 * Civil
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getCivilStatus().getCivilStatusKode().name();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getCivilStatus().getTilstandVirkning().getAktoerRef();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getCivilStatus().getTilstandVirkning().getCommentText();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getCivilStatus().getTilstandVirkning().getFraTidspunkt().getTidsstempelDatoTid();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getCivilStatus().getTilstandVirkning().getFraTidspunkt().isGraenseIndikator();
	* Life
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getLivStatus().getLivStatusKode().name();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getLivStatus().getTilstandVirkning().getAktoerRef();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getLivStatus().getTilstandVirkning().getCommentText();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getLivStatus().getTilstandVirkning().getFraTidspunkt().getTidsstempelDatoTid();
	laesOutput.getLaesResultat().getRegistrering().getTilstandListe().getLivStatus().getTilstandVirkning().getFraTidspunkt().isGraenseIndikator();
	 */
	
	String civilStatusKode();
	IEffect civilTilstandsVirkning();
	String livStatusKode();
	IEffect livTilstandsVirkning();
}
