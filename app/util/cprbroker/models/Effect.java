package util.cprbroker.models;

import javax.xml.datatype.XMLGregorianCalendar;

import util.cprbroker.IEffect;

public class Effect implements IEffect {
	
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
		
		public IEffect build() { return new Effect(this); }
		
		public Builder actorUrn(String newUrn) { actorUrn = newUrn; return this; }
		public Builder actorUuid(String newUuid) { actorUuid = newUuid; return this; }
		public Builder comment(String newComment) { comment = newComment; return this; }
		public Builder effectiveFromDate(XMLGregorianCalendar newDate) { effectiveFromDate = newDate; return this; }
		public Builder isEffectiveFromLimit(Boolean isLimit) { isEffectiveFromLimit = isLimit; return this; }
		public Builder effectiveToDate(XMLGregorianCalendar newDate) { effectiveToDate = newDate; return this; }
		public Builder isEffectiveToLimit(Boolean isLimit) { isEffectiveToLimit = isLimit; return this; }
		
	}
	
	
	private Effect(Builder builder) {
		actorUrn = builder.actorUrn;
		actorUuid = builder.actorUuid;
		comment = builder.comment;
		effectiveFromDate = builder.effectiveFromDate;
		isEffectiveFromLimit = builder.isEffectiveFromLimit;
		effectiveToDate = builder.effectiveToDate;
		isEffectiveToLimit = builder.isEffectiveToLimit;
	}

	@Override
	public String actorUrn() { return actorUrn; }

	@Override
	public String actorUuid() {	return actorUuid; }

	@Override
	public String comment() { return comment; }

	@Override
	public XMLGregorianCalendar effectiveFromDate() { return effectiveFromDate;	}

	@Override
	public Boolean isEffectiveFromLimit() {	return isEffectiveFromLimit; }

	@Override
	public XMLGregorianCalendar effectiveToDate() {	return effectiveToDate; }

	@Override
	public Boolean isEffectiveToLimit() { return isEffectiveToLimit; }

}
