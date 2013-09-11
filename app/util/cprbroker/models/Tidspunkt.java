package util.cprbroker.models;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import util.cprbroker.ITidspunkt;

public class Tidspunkt implements ITidspunkt {
	
	private final String aktoerRefUrn;
	private final String aktoerRefUuid;
	private final String kommentar;
	private final String livscyklusKode;
	private final DateTime tidspunkt;
	private final Boolean isTidspunktGraenseIndikator;
	private final Map<String, String> sourceUuidMap;
	
	public static class Builder {
		private String aktoerRefUrn;
		private String aktoerRefUuid;
		private String kommentar;
		private String livscyklusKode;
		private DateTime tidspunkt;
		private Boolean isTidspunktGraenseIndikator;

		public ITidspunkt build() { return new Tidspunkt(this); }
		
		public Builder aktoerRefUrn(String newUrn) { aktoerRefUrn = newUrn; return this; }
		public Builder aktoerRefUuid(String newUuid) { aktoerRefUuid = newUuid; return this; }
		public Builder kommentar(String newKommentar) { kommentar = newKommentar; return this; }
		public Builder livscyklusKode(String newKode) { livscyklusKode = newKode; return this; }
		public Builder tidspunkt(GregorianCalendar newDate) { tidspunkt = new DateTime(newDate); return this; }
		public Builder isTidspunktGraenseIndikator(Boolean isGraense) { isTidspunktGraenseIndikator = isGraense; return this; }
	}
	
	
	private Tidspunkt(Builder builder) {
		aktoerRefUrn = builder.aktoerRefUrn;
		aktoerRefUuid = builder.aktoerRefUuid;
		kommentar = builder.kommentar;
		livscyklusKode = builder.livscyklusKode;
		tidspunkt = builder.tidspunkt;
		isTidspunktGraenseIndikator = builder.isTidspunktGraenseIndikator;
		
		sourceUuidMap = new HashMap<String, String>();
		sourceUuidMap.put("2B2C1518-F466-491F-8149-57AFEF48CC01", "CPR Direct");
		sourceUuidMap.put("4A953CF9-B4C1-4CE9-BF09-2BF655DC61C7", "DPR");
		sourceUuidMap.put("F2B564A4-CB97-4984-990C-39A5F010BDE3", "E&M");
		sourceUuidMap.put("A4E9B3E0-275F-4B76-AADB-4398AA56B871", "KMD");
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
	public DateTime tidspunkt() { return tidspunkt; }

	@Override
	public Boolean isTidspunktGraenseIndikator() { return isTidspunktGraenseIndikator;	}

	@Override
	public String sourceName() { return sourceUuidMap.get(aktoerRefUuid.toUpperCase()); }

}
