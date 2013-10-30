/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

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
		//TODO Check for valid uuid?
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
	
	//TODO Check for valid uuid? Catch all to return Ukendt string? Make into Enum? Load from settings?
	@Override
	public String sourceName() { return sourceUuidMap.get(aktoerRefUuid.toUpperCase()); }

}
