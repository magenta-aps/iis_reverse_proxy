package util.cprbroker.models;

import util.cprbroker.IVirkning;
import util.cprbroker.ITilstand;

public class Tilstand implements ITilstand {

	private final String civilStatusKode;
	private final IVirkning civilTilstandsVirkning;
	private final String livStatusKode;
	private final IVirkning livTilstandsVirkning;

	//TODO Look at ITilstand - isGraeseIndikator? Implement it!
	public static class Builder {
		private String civilStatusKode;
		private IVirkning civilTilstandsVirkning;
		private String livStatusKode;
		private IVirkning livTilstandsVirkning;
		
		public ITilstand build() { return new Tilstand(this); }
		
		public Builder civilStatusKode(String newKode) { civilStatusKode = newKode; return this; }
		public Builder civilTilstandsVirkning(IVirkning virkning) {civilTilstandsVirkning = virkning; return this; }
		public Builder livStatusKode(String newKode) { livStatusKode = newKode; return this; }
		public Builder livTilstandsVirkning(IVirkning virkning) {livTilstandsVirkning = virkning; return this; }

		
	}
	
	private Tilstand(Builder builder) {
		civilStatusKode = builder.civilStatusKode;
		civilTilstandsVirkning = builder.civilTilstandsVirkning;
		livStatusKode = builder.livStatusKode;
		livTilstandsVirkning = builder.livTilstandsVirkning;
	}
	
	@Override
	public String civilStatusKode() { return civilStatusKode;}

	@Override
	public IVirkning civilTilstandsVirkning() { return civilTilstandsVirkning; }

	@Override
	public String livStatusKode() {	return livStatusKode; }

	@Override
	public IVirkning livTilstandsVirkning() {	return livTilstandsVirkning; }

}
