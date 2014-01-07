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

import util.cprbroker.ELifeStatusType;
import util.cprbroker.EMaritalStatusType;
import util.cprbroker.IVirkning;
import util.cprbroker.ITilstand;

public class Tilstand implements ITilstand {

	private final EMaritalStatusType civilStatusKode;
	private final IVirkning civilTilstandsVirkning;
	private final ELifeStatusType livStatusKode;
	private final IVirkning livTilstandsVirkning;

	//TODO Look at ITilstand - isGraeseIndikator? Implement it!
	public static class Builder {
		private EMaritalStatusType civilStatusKode;
		private IVirkning civilTilstandsVirkning;
		private ELifeStatusType livStatusKode;
		private IVirkning livTilstandsVirkning;
		
		public ITilstand build() { return new Tilstand(this); }
		
		public Builder civilStatusKode(String newKode) { civilStatusKode = EMaritalStatusType.valueOf(newKode); return this; }
		public Builder civilTilstandsVirkning(IVirkning virkning) {civilTilstandsVirkning = virkning; return this; }
		public Builder livStatusKode(String newKode) { livStatusKode = ELifeStatusType.valueOf(newKode); return this; }
		public Builder livTilstandsVirkning(IVirkning virkning) {livTilstandsVirkning = virkning; return this; }

		
	}
	
	private Tilstand(Builder builder) {
		civilStatusKode = builder.civilStatusKode;
		civilTilstandsVirkning = builder.civilTilstandsVirkning;
		livStatusKode = builder.livStatusKode;
		livTilstandsVirkning = builder.livTilstandsVirkning;
	}
	
	@Override
	public EMaritalStatusType civilStatusKode() { return civilStatusKode;}

	@Override
	public IVirkning civilTilstandsVirkning() { return civilTilstandsVirkning; }

	@Override
	public ELifeStatusType livStatusKode() {	return livStatusKode; }

	@Override
	public IVirkning livTilstandsVirkning() {	return livTilstandsVirkning; }

}
