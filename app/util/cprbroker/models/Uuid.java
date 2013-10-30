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

import util.cprbroker.IUuid;

public class Uuid implements IUuid {
	
	private final String uuid;
	private final String message;
	private final int code;
	
	// Lazy initialized, cached hashCode
	private volatile int hashCode;
	
	/**
	 * 
	 * @param newUuid String representation of a hyphenated Guid with a length of 36
	 * @param newCode CPR Broker status code
	 * @param newMessage CPR Broker message
	 * @throws IllegaArgumentException Throws if newUuid length != 36
	 */
	public Uuid(final String newUuid, final int newCode, final String newMessage) {
		//TODO make a pattern match instead!
		if(newUuid.length() != 36) throw new IllegalArgumentException("A uuid must be a String representation of a hyphenated Guid with a length of 36");
		uuid = newUuid;
		message = newMessage;
		code = newCode;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public int code() {
		return code;
	}

	@Override
	public String value() {
		return uuid;
	}
	
	@Override
	public String toString() {
		return uuid;
	}
	
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 5;
			result = result + message.hashCode();
			result = result + code;
			result = result + uuid.hashCode();
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!( obj instanceof Uuid))
			return false;
		Uuid u = (Uuid) obj;
		return code == u.code() && message == u.message() && uuid == u.value();
		
	}


}
