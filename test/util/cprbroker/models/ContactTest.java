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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IContact;

public class ContactTest {

	IContact testContact;
	
	@Before
	public void setUp() {
		Contact.Builder builder = new Contact.Builder();
		
		builder.email("newEmail");
		builder.isPhoneAbleToRecieveSms(true);
		builder.limitedUsageText("newText");
		builder.noteText("newNote");
		builder.otherContactNoteText("newContactNote");
		builder.otherContactText("newContactText");
		builder.phone("12345678");
		
		testContact = builder.build();
	}
	
	@Test
	public void testEmail() {
		assertEquals("newEmail", testContact.email());
	}

	@Test
	public void testISPhoneAbleToRecieveSms() {
		assertEquals(Boolean.TRUE, testContact.isPhoneAbleToRecieveSms());
	}
	
	@Test
	public void testLimitedUsageText() {
		assertEquals("newText", testContact.limitedUsageText());
	}

	@Test
	public void testNoteText() {
		assertEquals("newNote", testContact.noteText());
	}
	
	@Test
	public void testOtherContactNoteText() {
		assertEquals("newContactNote", testContact.otherContactNoteText());
	}
	
	@Test
	public void testOtherContactText() {
		assertEquals("newContactText", testContact.otherContactText());
	}
	
	@Test
	public void testPhone() {
		assertEquals("12345678", testContact.phone());
	}
}
