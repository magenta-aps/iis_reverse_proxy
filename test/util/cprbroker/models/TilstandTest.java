package util.cprbroker.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import util.cprbroker.ITilstand;
import util.cprbroker.IVirkning;

public class TilstandTest {

	private ITilstand testTilstand;
	private IVirkning mockedVirkning;
	
	@Before
	public void setUp() throws Exception {
		
		mockedVirkning = mock(IVirkning.class);
		
		Tilstand.Builder builder = new Tilstand.Builder();
		builder.civilStatusKode("newKode");
		builder.civilTilstandsVirkning(mockedVirkning);
		builder.livStatusKode("newKode");
		builder.livTilstandsVirkning(mockedVirkning);
		
		testTilstand = builder.build();
	}

	@Test
	public void testCivilStatusKode() {
		String expected = "newKode";
		
		assertEquals(expected, testTilstand.civilStatusKode());
	}
	
	@Test
	public void testCivilStatusVirkning() {
		assertEquals(mockedVirkning, testTilstand.civilTilstandsVirkning());
	}
	
	@Test
	public void testLivStatusKode() {
		String expected = "newKode";
		
		assertEquals(expected, testTilstand.livStatusKode());
	}
	
	@Test
	public void testLivStatusVirkning() {
		assertEquals(mockedVirkning, testTilstand.livTilstandsVirkning());
	}

}
