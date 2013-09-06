package util.cprbroker.models;

import java.util.LinkedList;
import java.util.List;

import util.cprbroker.IPersonRelationships;
import util.cprbroker.IRelationship;

public class PersonRelationships implements IPersonRelationships {
	
	private final int numberOfRelations;
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
	private final List<IRelationship> allRelations;
	
	public static class Builder {
		private int numberOfRelations = 0; 
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
				
		public Builder aegtefaelle(List<IRelationship> newRelationship) { numberOfRelations++; aegtefaelle = newRelationship; return this; }
		public Builder boern(List<IRelationship> newRelationship) { numberOfRelations++; boern = newRelationship; return this; }
		public Builder bopaelssamling(List<IRelationship> newRelationship) { numberOfRelations++; bopaelssamling = newRelationship; return this; }
		public Builder erstatingAf(List<IRelationship> newRelationship) { numberOfRelations++; erstatingAf = newRelationship; return this; }
		public Builder erstatingFor(List<IRelationship> newRelationship) { numberOfRelations++; erstatingFor = newRelationship; return this; }
		public Builder fader(List<IRelationship> newRelationship) { numberOfRelations++; fader = newRelationship; return this; }
		public Builder foraeldremydighedsboern(List<IRelationship> newRelationship) { numberOfRelations++; foraeldremydighedsboern = newRelationship; return this; }
		public Builder foraeldremyndighedsindehaver(List<IRelationship> newRelationship) { numberOfRelations++; foraeldremyndighedsindehaver = newRelationship; return this; }
		public Builder moder(List<IRelationship> newRelationship) { numberOfRelations++; moder = newRelationship; return this; }
		public Builder registreretPartner(List<IRelationship> newRelationship) { numberOfRelations++; registreretPartner = newRelationship; return this; }
		public Builder retligHandleevneVaergeForPersonen(List<IRelationship> newRelationship) { numberOfRelations++; retligHandleevneVaergeForPersonen = newRelationship; return this; }
		public Builder retligHandleevneVaergemaalsindehaver(List<IRelationship> newRelationship) { numberOfRelations++; retligHandleevneVaergemaalsindehaver = newRelationship; return this; }
	}
	
	
	private PersonRelationships(Builder builder) {

		erstatingAf = builder.erstatingAf;
		erstatingFor = builder.erstatingFor; 
		fader = builder.fader;
		moder = builder.moder;
		foraeldremyndighedsindehaver = builder.foraeldremyndighedsindehaver;
		retligHandleevneVaergeForPersonen = builder.retligHandleevneVaergeForPersonen;		
		aegtefaelle = builder.aegtefaelle;
		registreretPartner = builder.registreretPartner;		
		boern = builder.boern;
		foraeldremydighedsboern = builder.foraeldremydighedsboern;
		retligHandleevneVaergemaalsindehaver = builder.retligHandleevneVaergemaalsindehaver;
		bopaelssamling = builder.bopaelssamling;
		numberOfRelations = builder.numberOfRelations;
		
		List<IRelationship> tmpAllRelations = new LinkedList<IRelationship>();
		
		if(erstatingAf != null) tmpAllRelations.addAll(erstatingAf);
		if(erstatingFor != null) tmpAllRelations.addAll(erstatingFor);
		if(fader != null) tmpAllRelations.addAll(fader);
		if(moder != null) tmpAllRelations.addAll(moder);
		if(foraeldremyndighedsindehaver != null) tmpAllRelations.addAll(foraeldremyndighedsindehaver);		
		if(retligHandleevneVaergeForPersonen != null) tmpAllRelations.addAll(retligHandleevneVaergeForPersonen);
		if(aegtefaelle != null) tmpAllRelations.addAll(aegtefaelle);
		if(registreretPartner != null) tmpAllRelations.addAll(registreretPartner);
		if(boern != null) tmpAllRelations.addAll(boern);
		if(foraeldremydighedsboern != null) tmpAllRelations.addAll(foraeldremydighedsboern);
		if(retligHandleevneVaergemaalsindehaver != null) tmpAllRelations.addAll(retligHandleevneVaergemaalsindehaver);
		if(bopaelssamling != null) tmpAllRelations.addAll(bopaelssamling);

		allRelations = tmpAllRelations;
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

	@Override
	public int numberOfRelations() { return numberOfRelations; }

	@Override
	public List<IRelationship> allRelations() { return allRelations; }

}
