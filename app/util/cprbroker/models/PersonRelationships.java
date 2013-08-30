package util.cprbroker.models;

import java.util.List;

import util.cprbroker.IPersonRelationships;
import util.cprbroker.IRelationship;

public class PersonRelationships implements IPersonRelationships {

	private final List<IRelationship> aegtefaelle;
	private final List<IRelationship> boern;
	private final List<IRelationship> bopaelssamling;
	private final List<IRelationship> erstatingAf;
	private final List<IRelationship> erstatingFor; 
	private final List<IRelationship> fader;
	private final List<IRelationship> foraeldremydighedsboern;
	private final List<IRelationship> foraeldremyndighedsindehaver;
	private final List<IRelationship> moder;
	private final List<IRelationship> registreretPartner;
	private final List<IRelationship> retligHandleevneVaergeForPersonen;
	private final List<IRelationship> retligHandleevneVaergemaalsindehaver;
	
	public static class Builder {
		private List<IRelationship> aegtefaelle;
		private List<IRelationship> boern;
		private List<IRelationship> bopaelssamling;
		private List<IRelationship> erstatingAf;
		private List<IRelationship> erstatingFor; 
		private List<IRelationship> fader;
		private List<IRelationship> foraeldremydighedsboern;
		private List<IRelationship> foraeldremyndighedsindehaver;
		private List<IRelationship> moder;
		private List<IRelationship> registreretPartner;
		private List<IRelationship> retligHandleevneVaergeForPersonen;
		private List<IRelationship> retligHandleevneVaergemaalsindehaver;
		
		public IPersonRelationships build() { return new PersonRelationships(this); }
				
		public Builder aegtefaelle(List<IRelationship> newRelationship) { aegtefaelle = newRelationship; return this; }
		public Builder boern(List<IRelationship> newRelationship) { boern = newRelationship; return this; }
		public Builder bopaelssamling(List<IRelationship> newRelationship) { bopaelssamling = newRelationship; return this; }
		public Builder erstatingAf(List<IRelationship> newRelationship) { erstatingAf = newRelationship; return this; }
		public Builder erstatingFor(List<IRelationship> newRelationship) { erstatingFor = newRelationship; return this; }
		public Builder fader(List<IRelationship> newRelationship) { fader = newRelationship; return this; }
		public Builder foraeldremydighedsboern(List<IRelationship> newRelationship) { foraeldremydighedsboern = newRelationship; return this; }
		public Builder foraeldremyndighedsindehaver(List<IRelationship> newRelationship) { foraeldremyndighedsindehaver = newRelationship; return this; }
		public Builder moder(List<IRelationship> newRelationship) { moder = newRelationship; return this; }
		public Builder registreretPartner(List<IRelationship> newRelationship) { registreretPartner = newRelationship; return this; }
		public Builder retligHandleevneVaergeForPersonen(List<IRelationship> newRelationship) { retligHandleevneVaergeForPersonen = newRelationship; return this; }
		public Builder retligHandleevneVaergemaalsindehaver(List<IRelationship> newRelationship) { retligHandleevneVaergemaalsindehaver = newRelationship; return this; }
	}
	
	
	private PersonRelationships(Builder builder) {
	
		aegtefaelle = builder.aegtefaelle;
		boern = builder.boern;
		bopaelssamling = builder.bopaelssamling;
		erstatingAf = builder.erstatingAf;
		erstatingFor = builder.erstatingFor; 
		fader = builder.fader;
		foraeldremydighedsboern = builder.foraeldremydighedsboern;
		foraeldremyndighedsindehaver = builder.foraeldremyndighedsindehaver;
		moder = builder.moder;
		registreretPartner = builder.registreretPartner;
		retligHandleevneVaergeForPersonen = builder.retligHandleevneVaergeForPersonen;
		retligHandleevneVaergemaalsindehaver = builder.retligHandleevneVaergemaalsindehaver;
	}
	
	@Override
	public List<IRelationship> aegtefaelle() { return aegtefaelle; }

	@Override
	public List<IRelationship> boern() { return boern;}

	@Override
	public List<IRelationship> bopaelssamling() { return bopaelssamling; }

	@Override
	public List<IRelationship> erstatingAf() { return erstatingAf;	}

	@Override
	public List<IRelationship> erstatingFor() {	return erstatingFor; }

	@Override
	public List<IRelationship> fader() { return fader; }

	@Override
	public List<IRelationship> foraeldremydighedsboern() { return foraeldremydighedsboern;	}

	@Override
	public List<IRelationship> foraeldremyndighedsindehaver() {	return foraeldremyndighedsindehaver; }

	@Override
	public List<IRelationship> moder() { return moder; }

	@Override
	public List<IRelationship> registreretPartner() { return registreretPartner;	}

	@Override
	public List<IRelationship> retligHandleevneVaergeForPersonen() { return retligHandleevneVaergeForPersonen; }

	@Override
	public List<IRelationship> retligHandleevneVaergemaalsindehaver() {	return retligHandleevneVaergemaalsindehaver; }

}
