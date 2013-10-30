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

import util.cprbroker.IContact;

public class Contact implements IContact {
	
	private final String limitedUsageText;
	private final String email;
	private final String noteText;
	private final String phone;
	private final String otherContactText;
	private final String otherContactNoteText;
	private final Boolean isPhoneAbleToRecieveSms;
	
	public static class Builder {
	
		private boolean isPhoneAbleToRecieveSms;
		private String limitedUsageText;
		private String email;
		private String noteText;
		private String phone;
		private String otherContactText;
		private String otherContactNoteText;
		
		public IContact build() { return new Contact(this); }
		
		public Builder limitedUsageText(String newText) {limitedUsageText = newText; return this;}
		public Builder email(String newEmail) {email = newEmail; return this;}
		public Builder noteText(String newText) {noteText = newText; return this;}
		public Builder phone(String newPhone) {phone = newPhone; return this;}
		public Builder otherContactText(String newText) {otherContactText = newText; return this;}
		public Builder otherContactNoteText(String newText) {otherContactNoteText = newText; return this;}
		public Builder isPhoneAbleToRecieveSms(boolean isAble) {isPhoneAbleToRecieveSms = isAble; return this; }
	}
	
	private Contact(Builder builder) {
		limitedUsageText = builder.limitedUsageText;
		email = builder.email;
		noteText = builder.noteText;
		phone = builder.phone;
		otherContactText = builder.otherContactText;
		otherContactNoteText = builder.otherContactNoteText;
		isPhoneAbleToRecieveSms = builder.isPhoneAbleToRecieveSms;
	}

	@Override
	public String limitedUsageText() { return limitedUsageText; }

	@Override
	public String email() { return email; }

	@Override
	public String noteText() { return noteText;	}

	@Override
	public String phone() { return phone; }

	@Override
	public String otherContactText() { return otherContactText;	}

	@Override
	public String otherContactNoteText() { return otherContactNoteText;	}

	@Override
	public Boolean isPhoneAbleToRecieveSms() { return isPhoneAbleToRecieveSms; }

}
