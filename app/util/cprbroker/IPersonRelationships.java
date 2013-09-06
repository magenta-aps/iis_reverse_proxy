package util.cprbroker;

import java.util.List;

public interface IPersonRelationships {
	
	/* Relations
	List<PersonRelationType> p1 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getAegtefaelle();
	List<PersonFlerRelationType> p2 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getBoern();
	List<PersonFlerRelationType> p3 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getBopaelssamling();
	List<PersonRelationType> p4 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getErstatningAf();
	List<PersonFlerRelationType> p5 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getErstatningFor();
	List<PersonRelationType> p6 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getFader();
	List<PersonFlerRelationType> p7 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getForaeldremyndighedsboern();
	List<PersonRelationType> p8 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getForaeldremyndighedsindehaver();
	LokalUdvidelseType p9 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getLokalUdvidelse();
	List<PersonRelationType> p10 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getModer();
	List<PersonRelationType> p11 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getRegistreretPartner();
	List<PersonRelationType> p12 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getRetligHandleevneVaergeForPersonen();
	List<PersonFlerRelationType> p13 = laesOutput.getLaesResultat().getRegistrering().getRelationListe().getRetligHandleevneVaergemaalsindehaver();
	*/
	int numberOfRelations();
	List<IRelationship> aegtefaelle();
	List<IRelationship> boern();
	List<IRelationship> bopaelssamling();
	List<IRelationship> erstatingAf();
	List<IRelationship> erstatingFor();
	List<IRelationship> fader();
	List<IRelationship> foraeldremydighedsboern();
	List<IRelationship> foraeldremyndighedsindehaver();
	List<IRelationship> moder();
	List<IRelationship> registreretPartner();
	List<IRelationship> retligHandleevneVaergeForPersonen();
	List<IRelationship> retligHandleevneVaergemaalsindehaver();

}
