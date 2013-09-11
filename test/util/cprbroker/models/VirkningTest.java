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
		
		gregorianCalenderFromTime = new GregorianCalendar(1978, 11, 26, 12, 13, 14);
		jodaDateTimeFromTime = new DateTime(1978, 12, 26, 12, 13, 14);

		gregorianCalenderToTime = new GregorianCalendar(1982, 2, 12, 12, 13, 14);
		jodaDateTimeToTime = new DateTime(1982, 3, 12, 12, 13, 14);

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
