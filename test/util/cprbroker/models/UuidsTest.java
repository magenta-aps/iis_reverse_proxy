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

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IUuids;

public class UuidsTest {

	private IUuids testUuids;
	private List<String> values;
	
	@Before
	public void setUp() {
		List<String> newUuids = new LinkedList<String>();
		newUuids.add("12345678-1234-1234-1234-123456789abc");
		newUuids.add("12345678-1234-1234-1234-123456789def");
		values = newUuids;
		
		testUuids = new Uuids(200, "OK", newUuids);
	}
	
	@Test
	public void testCode() {
		int expected = 200;
		
		assertEquals(expected, testUuids.code());
	}
	
	@Test
	public void testMessage() {
		String expected = "OK";
		
		assertEquals(expected, testUuids.message());
	}
	
	@Test
	public void testUuidsCantBeChangedByAlteringListFromConstruction() {
		
		int expected = testUuids.values().size();
		
		values.add("12345678-1234-1234-1234-123456789ghi");
		
		assertEquals(expected, testUuids.values().size());
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUuidsNewValuesCanNotBeAdded() {
		testUuids.values().add("12345678-1234-1234-1234-123456789ghi");
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUuidsValuesCanNotBeRemoved() {
		testUuids.values().remove(0);
	}

	
}
