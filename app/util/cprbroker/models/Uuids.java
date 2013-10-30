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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.cprbroker.IUuids;

public class Uuids implements IUuids {

	private final List<String> uuids;
	private final String message;
	private final int code;
	
	public Uuids(final int newCode, final String newMessage, final List<String> newUuids) {
		
		uuids = defensiveCopyOfValues(newUuids);
		message = newMessage;
		code = newCode;
	}
	
	@Override
	public String message() { return message; }

	@Override
	public int code() {	return code; }

	@Override
	public List<String> values() { return uuids; }
	
	/**
	 * helper method to make the class immutable
	 * @param referencedValues String representations of Uuids
	 * @return Collections.unmodifiableList of a copy of the referencedValues
	 */
	private List<String> defensiveCopyOfValues(List<String> referencedValues) {
		
		List<String> copy = new LinkedList<String>();
		
		for(String uuid : referencedValues) {
			copy.add(uuid);
		}
		
		return Collections.unmodifiableList(copy);
	}
	
}
