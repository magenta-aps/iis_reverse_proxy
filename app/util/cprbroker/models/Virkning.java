package util.cprbroker.models;

import javax.xml.datatype.XMLGregorianCalendar;

import util.cprbroker.IVirkning;

public class Virkning implements IVirkning {
	
	private final String actorUrn;
	private final String actorUuid;
	private final String comment;
	private final XMLGregorianCalendar effectiveFromDate;
	private final Boolean isEffectiveFromLimit;
	private final XMLGregorianCalendar effectiveToDate;
	private final Boolean isEffectiveToLimit;

	public static class Builder {
		
		public Builder() {}
		
		private String actorUrn;
		private String actorUuid;
		private String comment;
		private XMLGregorianCalendar effectiveFromDate;
		private Boolean isEffectiveFromLimit;
		private XMLGregorianCalendar effectiveToDate;
		private Boolean isEffectiveToLimit;
		
		public IVirkning build() { return new Virkning(this); }
		
		public Builder actorUrn(String newUrn) { actorUrn = newUrn; return this; }
		public Builder actorUuid(String newUuid) { actorUuid = newUuid; return this; }
		public Builder comment(String newComment) { comment = newComment; return this; }
		public Builder effectiveFromDate(XMLGregorianCalendar newDate) { effectiveFromDate = newDate; return this; }
		public Builder isEffectiveFromLimit(Boolean isLimit) { isEffectiveFromLimit = isLimit; return this; }
		public Builder effectiveToDate(XMLGregorianCalendar newDate) { effectiveToDate = newDate; return this; }
		public Builder isEffectiveToLimit(Boolean isLimit) { isEffectiveToLimit = isLimit; return this; }
		
	}
	
	
	private Virkning(Builder builder) {
		actorUrn = builder.actorUrn;
		actorUuid = builder.actorUuid;
		comment = builder.comment;
		effectiveFromDate = builder.effectiveFromDate;
		isEffectiveFromLimit = builder.isEffectiveFromLimit;
		effectiveToDate = builder.effectiveToDate;
		isEffectiveToLimit = builder.isEffectiveToLimit;
	}

	@Override
	public String aktoerRefUrn() { return actorUrn; }

	@Override
	public String aktoerRefUuid() {	return actorUuid; }

	@Override
	public String kommentar() { return comment; }

	@Override
	public XMLGregorianCalendar fraTidspunkt() { return effectiveFromDate; }

	@Override
	public Boolean isFraTidspunktGraenseIndikator() {	return isEffectiveFromLimit; }

	@Override
	public XMLGregorianCalendar tilTidspunkt() {	return effectiveToDate; }

	@Override
	public Boolean isTilTidspunktGraenseIndikator() { return isEffectiveToLimit; }

}
