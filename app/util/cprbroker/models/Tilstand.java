package util.cprbroker.models;

import util.cprbroker.IEffect;
import util.cprbroker.ITilstand;

public class Tilstand implements ITilstand {

	private final String civilStatusKode;
	private final IEffect civilTilstandsVirkning;
	private final String livStatusKode;
	private final IEffect livTilstandsVirkning;
	
	public static class Builder {
		private String civilStatusKode;
		private IEffect civilTilstandsVirkning;
		private String livStatusKode;
		private IEffect livTilstandsVirkning;
		
		public ITilstand build() { return new Tilstand(this); }
		
		public Builder civilStatusKode(String newKode) { civilStatusKode = newKode; return this; }
		public Builder civilTilstandsVirkning(IEffect virkning) {civilTilstandsVirkning = virkning; return this; }
		public Builder livStatusKode(String newKode) { livStatusKode = newKode; return this; }
		public Builder livTilstandsVirkning(IEffect virkning) {livTilstandsVirkning = virkning; return this; }

		
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
	public IEffect civilTilstandsVirkning() { return civilTilstandsVirkning; }

	@Override
	public String livStatusKode() {	return livStatusKode; }

	@Override
	public IEffect livTilstandsVirkning() {	return livTilstandsVirkning; }

}
