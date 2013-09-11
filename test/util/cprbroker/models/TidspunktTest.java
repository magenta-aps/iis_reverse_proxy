package util.cprbroker.models;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import util.cprbroker.ITidspunkt;

public class TidspunktTest {

	private ITidspunkt testTidspunkt;
	private DateTime newDateTime;
	
	@Before
	public void setUp() throws Exception {
		GregorianCalendar newDate = new GregorianCalendar(1978, 11, 26, 13, 37, 00);
		newDateTime = new DateTime(1978, 12, 26, 13, 37, 00);
		
		Tidspunkt.Builder builder = new Tidspunkt.Builder();
		
		builder.aktoerRefUrn("newUrn");
		builder.aktoerRefUuid("newUuid");
		builder.isTidspunktGraenseIndikator(true);
		builder.kommentar("newKommentar");
		builder.livscyklusKode("newKode");
		builder.tidspunkt(newDate);
		
		testTidspunkt = builder.build();
	}

	@Test
	public void testAktoerRefUrn() {
		assertEquals("newUrn", testTidspunkt.aktoerRefUrn());
	}

	@Test
	public void testAktoerRefUuid() {
		assertEquals("newUuid", testTidspunkt.aktoerRefUuid());
	}

	@Test
	public void testIsTidspunktGraenseIndikator() {
		assertEquals(Boolean.TRUE, testTidspunkt.isTidspunktGraenseIndikator());
	}

	@Test
	public void testKommentar() {
		assertEquals("newKommentar", testTidspunkt.kommentar());
	}
	
	@Test
	public void testLivscyklusKode() {
		assertEquals("newKode", testTidspunkt.livscyklusKode());
	}
	
	@Test
	public void testTidspunkt() {
		long expected = newDateTime.getMillis();
		assertEquals(expected, testTidspunkt.tidspunkt().getMillis());
	}
	
	// TODO Make generic test of all the names appering in settings
	@Test
	public void testSourceNames() {

		assertNull(testTidspunkt.sourceName());
		
		String cprDirectUuid ="2B2C1518-F466-491F-8149-57AFEF48CC01";
		String dprUuid = "4A953CF9-B4C1-4CE9-BF09-2BF655DC61C7";
		String eAndMUuid = "F2B564A4-CB97-4984-990C-39A5F010BDE3";
		String kmdUuid = "A4E9B3E0-275F-4b76-AADB-4398AA56B871";
		
		ITidspunkt cprDirect = new Tidspunkt.Builder().aktoerRefUuid(cprDirectUuid).build();
		assertEquals("CPR Direct", cprDirect.sourceName());
		
		ITidspunkt dpr = new Tidspunkt.Builder().aktoerRefUuid(dprUuid).build();
		assertEquals("DPR", dpr.sourceName());

		ITidspunkt eAndM = new Tidspunkt.Builder().aktoerRefUuid(eAndMUuid).build();
		assertEquals("E&M", eAndM.sourceName());
		
		ITidspunkt kmd = new Tidspunkt.Builder().aktoerRefUuid(kmdUuid).build();
		assertEquals("KMD", kmd.sourceName());


	}
}
