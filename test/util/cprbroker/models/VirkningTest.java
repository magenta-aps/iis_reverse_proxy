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

import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import util.cprbroker.IVirkning;

public class VirkningTest {

	private IVirkning testVirkning;
	private GregorianCalendar gregorianCalenderFromTime;
	private GregorianCalendar gregorianCalenderToTime;
	private DateTime jodaDateTimeFromTime;
	private DateTime jodaDateTimeToTime;
	
	@Before
	public void setUp() throws Exception {
		
		gregorianCalenderFromTime = new GregorianCalendar(1978, 11, 26, 13, 37, 00);
		jodaDateTimeFromTime = new DateTime(1978, 12, 26, 13, 37, 00);

		gregorianCalenderToTime = new GregorianCalendar(1982, 2, 12, 13, 37, 00);
		jodaDateTimeToTime = new DateTime(1982, 3, 12, 13, 37, 00);

		Virkning.Builder builder = new Virkning.Builder();
		
		builder.actorUrn("newUrn");
		builder.actorUuid("newUuid");
		builder.comment("newComment");
		builder.effectiveFromDate(gregorianCalenderFromTime);
		builder.effectiveToDate(gregorianCalenderToTime);
		builder.isEffectiveFromLimit(false);
		builder.isEffectiveToLimit(true);
		
		testVirkning = builder.build();
	}

	@Test
	public void testAktoerRefUrn() {
		String expected = "newUrn";
		assertEquals(expected, testVirkning.aktoerRefUrn());
	}

	@Test
	public void testAktoerRefUuid() {
		String expected = "newUuid";
		assertEquals(expected, testVirkning.aktoerRefUuid());
	}

	@Test
	public void testKommentar() {
		String expected = "newComment";
		assertEquals(expected, testVirkning.kommentar());
	}
	
	@Test
	public void testFraTidspunkt() {
		long expected = jodaDateTimeFromTime.getMillis();
		assertEquals(expected, testVirkning.fraTidspunkt().getMillis());
	}

	@Test
	public void testTilTidspunkt() {
		long expected = jodaDateTimeToTime.getMillis();
		assertEquals(expected, testVirkning.tilTidspunkt().getMillis());
	}

	
	@Test
	public void testIsFraTidspunktGraenseIndikator() {
		Boolean expected = Boolean.FALSE;
		assertEquals(expected, testVirkning.isFraTidspunktGraenseIndikator());
	}

	@Test
	public void testIsTilTidspunktGraenseIndikator() {
		Boolean expected = Boolean.TRUE;
		assertEquals(expected, testVirkning.isTilTidspunktGraenseIndikator());
	}

}
