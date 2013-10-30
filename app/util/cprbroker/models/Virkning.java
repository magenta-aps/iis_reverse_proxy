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

import org.joda.time.DateTime;

import util.cprbroker.IVirkning;

public class Virkning implements IVirkning {
	
	private final String actorUrn;
	private final String actorUuid;
	private final String comment;
	private final DateTime effectiveFromDate;
	private final Boolean isEffectiveFromLimit;
	private final DateTime effectiveToDate;
	private final Boolean isEffectiveToLimit;

	public static class Builder {
		
		public Builder() {}
		
		private String actorUrn;
		private String actorUuid;
		private String comment;
		private DateTime effectiveFromDate;
		private Boolean isEffectiveFromLimit;
		private DateTime effectiveToDate;
		private Boolean isEffectiveToLimit;
		
		public IVirkning build() { return new Virkning(this); }
		
		public Builder actorUrn(String newUrn) { actorUrn = newUrn; return this; }
		//TODO Test for valid Uuid?
		public Builder actorUuid(String newUuid) { actorUuid = newUuid; return this; }
		public Builder comment(String newComment) { comment = newComment; return this; }
		public Builder effectiveFromDate(GregorianCalendar newDate) { effectiveFromDate = new DateTime(newDate); return this; }
		public Builder isEffectiveFromLimit(Boolean isLimit) { isEffectiveFromLimit = isLimit; return this; }
		public Builder effectiveToDate(GregorianCalendar newDate) { effectiveToDate = new DateTime(newDate); return this; }
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
	public DateTime fraTidspunkt() { return effectiveFromDate; }

	@Override
	public Boolean isFraTidspunktGraenseIndikator() { return isEffectiveFromLimit; }

	@Override
	public DateTime tilTidspunkt() { return effectiveToDate; }

	@Override
	public Boolean isTilTidspunktGraenseIndikator() { return isEffectiveToLimit; }

}
