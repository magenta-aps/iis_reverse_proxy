package util.cprbroker.models;

import javax.xml.datatype.XMLGregorianCalendar;

import util.cprbroker.ITidspunkt;

public class Tidspunkt implements ITidspunkt {
	
	private final String aktoerRefUrn;
	private final String aktoerRefUuid;
	private final String kommentar;
	private final String livscyklusKode;
	private final XMLGregorianCalendar tidspunkt;
	private final Boolean isTidspunktGraenseIndikator;

	public static class Builder {
		private String aktoerRefUrn;
		private String aktoerRefUuid;
		private String kommentar;
		private String livscyklusKode;
		private XMLGregorianCalendar tidspunkt;
		private Boolean isTidspunktGraenseIndikator;

		public ITidspunkt build() { return new Tidspunkt(this); }
		
		public Builder aktoerRefUrn(String newUrn) { aktoerRefUrn = newUrn; return this; }
		public Builder aktoerRefUuid(String newUuid) { aktoerRefUuid = newUuid; return this; }
		public Builder kommentar(String newKommentar) { kommentar = newKommentar; return this; }
		public Builder livscyklusKode(String newKode) { livscyklusKode = newKode; return this; }
		public Builder tidspunkt(XMLGregorianCalendar newDate) { tidspunkt = newDate; return this; }
		public Builder isTidspunktGraenseIndikator(Boolean isGraense) { isTidspunktGraenseIndikator = isGraense; return this; }
	}
	
	
	private Tidspunkt(Builder builder) {
		aktoerRefUrn = builder.aktoerRefUrn;
		aktoerRefUuid = builder.aktoerRefUuid;
		kommentar = builder.kommentar;
		livscyklusKode = builder.livscyklusKode;
		tidspunkt = builder.tidspunkt;
		isTidspunktGraenseIndikator = builder.isTidspunktGraenseIndikator;
	}
	
	@Override
	public String aktoerRefUrn() {	return aktoerRefUrn; }

	@Override
	public String aktoerRefUuid() {	return aktoerRefUuid; }

	@Override
	public String kommentar() { return kommentar; }

	@Override
	public String livscyklusKode() { return livscyklusKode; }

	@Override
	public XMLGregorianCalendar tidspunkt() { return tidspunkt; }

	@Override
	public Boolean isTidspunktGraenseIndikator() { return isTidspunktGraenseIndikator;	}

}
