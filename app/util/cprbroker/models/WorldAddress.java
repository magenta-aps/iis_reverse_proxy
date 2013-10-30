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

import util.cprbroker.EAddressType;
import util.cprbroker.IBuilder;
import util.cprbroker.IDanishAddress;
import util.cprbroker.IGreenlandicAddress;
import util.cprbroker.IWorldAddress;

public class WorldAddress implements IWorldAddress {

	private final String note;
	private final String countryIdentificationCode;
	private final String locationDescriptionText;
	private final String postalAddressFirstLineText;
	private final String postalAddressSecondLineText;
	private final String postalAddressThirdLineText;
	private final String postalAddressFourthLineText;
	private final String postalAddressFifthLineText;
	private final Boolean isUkendtAdresseIndikator;

	public static class Builder implements IBuilder<IWorldAddress>{

		private String note;
		private String countryIdentificationCode;
		private String locationDescriptionText;
		private String postalAddressFirstLineText;
		private String postalAddressSecondLineText;
		private String postalAddressThirdLineText;
		private String postalAddressFourthLineText;
		private String postalAddressFifthLineText;
		private Boolean isUkendtAdresseIndikator;
		
		public IWorldAddress build() {return new WorldAddress(this); }

		public Builder note(String newNote) {note = newNote; return this; }
		public Builder countryIdentificationCode(String newNote) {countryIdentificationCode = newNote; return this; }
		public Builder locationDescriptionText(String newText) {locationDescriptionText = newText; return this; }
		public Builder postalAddressFirstLineText(String newLine) {postalAddressFirstLineText = newLine; return this; }
		public Builder postalAddressSecondLineText(String newLine) {postalAddressSecondLineText = newLine; return this; }
		public Builder postalAddressThirdLineText(String newLine) {postalAddressThirdLineText = newLine; return this; }
		public Builder postalAddressFourthLineText(String newLine) {postalAddressFourthLineText = newLine; return this; }
		public Builder postalAddressFifthLineText(String newLine) {postalAddressFifthLineText = newLine; return this; }
		public Builder isUkendtAdresseIndikator(Boolean isUkendtAdresse) {isUkendtAdresseIndikator = isUkendtAdresse; return this; }
	}
	
	private WorldAddress(Builder builder) {

		note = builder.note;
		countryIdentificationCode = builder.countryIdentificationCode;
		locationDescriptionText = builder.locationDescriptionText;
		postalAddressFirstLineText = builder.postalAddressFirstLineText;
		postalAddressSecondLineText = builder.postalAddressSecondLineText;
		postalAddressThirdLineText = builder.postalAddressThirdLineText;
		postalAddressFourthLineText = builder.postalAddressFourthLineText;
		postalAddressFifthLineText = builder.postalAddressFifthLineText;
		isUkendtAdresseIndikator = builder.isUkendtAdresseIndikator;

	}
	
	@Override
	public EAddressType addressType() {	return EAddressType.World; }

	@Override
	public IDanishAddress danishAddress() {	throw new UnsupportedOperationException(); }

	@Override
	public IGreenlandicAddress greenlandicAddress() { throw new UnsupportedOperationException(); }

	@Override
	public IWorldAddress worldAddress() { return this; }

	@Override
	public String note() { return note;	}

	@Override
	public String countryIdentificationCode() {	return countryIdentificationCode; }

	@Override
	public String locationDescriptionText() { return locationDescriptionText; }

	@Override
	public String postalAddressFirstLineText() { return postalAddressFirstLineText; }

	@Override
	public String postalAddressSecondLineText() { return postalAddressSecondLineText; }

	@Override
	public String postalAddressThirdLineText() { return postalAddressThirdLineText; }

	@Override
	public String postalAddressFourthLineText() { return postalAddressFourthLineText; }

	@Override
	public String postalAddressFifthLineText() { return postalAddressFifthLineText; }

	@Override
	public Boolean isUkendtAdresseIndikator() {	return isUkendtAdresseIndikator; }

}
