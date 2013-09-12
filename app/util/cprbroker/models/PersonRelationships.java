package util.cprbroker.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.cprbroker.ERelationshipType;
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

		public Builder selectTheRightRelationship(List<IRelationship> newRelationship) {
			
			// guard check
			if(newRelationship == null || newRelationship.isEmpty()) {
				return null;
			}
			
			ERelationshipType type = newRelationship.get(0).relationshipType();
			
			switch(type) {
				case aegtefaelle:
					aegtefaelle(newRelationship);
					break;
				case boern:
					boern(newRelationship);
					break;
				case bopaelssamling:
					bopaelssamling(newRelationship);
					break;
				case erstatingAf:
					erstatingAf(newRelationship);
					break;
				case erstatingFor:
					erstatingFor(newRelationship);
					break;
				case fader:
					fader(newRelationship);
					break;
				case foraeldremydighedsboern:
					foraeldremydighedsboern(newRelationship);
					break;
				case foraeldremyndighedsindehaver:
					foraeldremyndighedsindehaver(newRelationship);
					break;					
				case moder:
					moder(newRelationship);
					break;
				case registreretPartner:
					registreretPartner(newRelationship);
					break;
				case retligHandleevneVaergeForPersonen:
					retligHandleevneVaergeForPersonen(newRelationship);
					break;
				case retligHandleevneVaergemaalsindehaver:
					retligHandleevneVaergemaalsindehaver(newRelationship);
					break;
				default:
					throw new IllegalArgumentException(); //If ERelationshipType is modified it will be caught
			}
			return this;
		}
		
		public Builder aegtefaelle(List<IRelationship> newRelationship) {
			numberOfRelations++;
			aegtefaelle = defensiveCopyOfValues(newRelationship,ERelationshipType.aegtefaelle);
			return this;
		}
		
		public Builder boern(List<IRelationship> newRelationship) {
			numberOfRelations++;
			boern =  defensiveCopyOfValues(newRelationship,ERelationshipType.boern);
			return this;
		}
		
		public Builder bopaelssamling(List<IRelationship> newRelationship) {
			numberOfRelations++;
			bopaelssamling = defensiveCopyOfValues(newRelationship,ERelationshipType.bopaelssamling);
			return this;
		}
		
		public Builder erstatingAf(List<IRelationship> newRelationship) {
			numberOfRelations++;
			erstatingAf = defensiveCopyOfValues(newRelationship,ERelationshipType.erstatingAf);
			return this;
		}
		
		public Builder erstatingFor(List<IRelationship> newRelationship) {
			numberOfRelations++;
			erstatingFor = defensiveCopyOfValues(newRelationship,ERelationshipType.erstatingFor);
			return this;
		}
		
		public Builder fader(List<IRelationship> newRelationship) {
			numberOfRelations++;
			fader = defensiveCopyOfValues(newRelationship,ERelationshipType.fader);
			return this;
		}
		
		public Builder foraeldremydighedsboern(List<IRelationship> newRelationship) {
			numberOfRelations++;
			foraeldremydighedsboern = defensiveCopyOfValues(newRelationship,ERelationshipType.foraeldremydighedsboern);
			return this;
		}
		
		public Builder foraeldremyndighedsindehaver(List<IRelationship> newRelationship) {
			numberOfRelations++;
			foraeldremyndighedsindehaver = defensiveCopyOfValues(newRelationship,ERelationshipType.foraeldremyndighedsindehaver);
			return this;
		}
		
		public Builder moder(List<IRelationship> newRelationship) { 
			numberOfRelations++;
			moder = defensiveCopyOfValues(newRelationship,ERelationshipType.moder);
			return this;
		}
		
		public Builder registreretPartner(List<IRelationship> newRelationship) {
			numberOfRelations++;
			registreretPartner = defensiveCopyOfValues(newRelationship,ERelationshipType.registreretPartner);
			return this;
		}
		
		public Builder retligHandleevneVaergeForPersonen(List<IRelationship> newRelationship) {
			numberOfRelations++;
			retligHandleevneVaergeForPersonen = defensiveCopyOfValues(newRelationship,ERelationshipType.retligHandleevneVaergeForPersonen);
			return this;
		}
		
		public Builder retligHandleevneVaergemaalsindehaver(List<IRelationship> newRelationship) {
			numberOfRelations++;
			retligHandleevneVaergemaalsindehaver = defensiveCopyOfValues(newRelationship,ERelationshipType.retligHandleevneVaergemaalsindehaver);
			return this;
		}
		
		/**
		 * helper method to make the class immutable
		 * @param referencedValues IRelationship representations of Relationships
		 * @return Collections.unmodifiableList of a copy of the referencedValues
		 */
		private List<IRelationship> defensiveCopyOfValues(
										List<IRelationship> referencedValues,
										 ERelationshipType referencedType) {
			
			// null check
			if(referencedValues == null) { 
				return null;
			}

			// make defensive copy
			List<IRelationship> copy = new LinkedList<IRelationship>();
			
			for(IRelationship relationship : referencedValues) {
				if(isCorrectRelationshipType(relationship, referencedType)) {
					copy.add(relationship);
				} else {
					throw new IllegalArgumentException();
				}	
			}
			
			return Collections.unmodifiableList(copy);
		}

		/**
		 * helper method to help check if the relationship is of the correct type
		 * @param relationship IRelationship to be checked
		 * @param shouldBeType ERelationshipType that the relationship parameter should be
		 * @return boolean value of the check if relationship is of shouldBeType
		 */
		private boolean isCorrectRelationshipType(IRelationship relationship, ERelationshipType shouldBeType) {
			if(relationship.relationshipType() == shouldBeType) {
				return true;
			}
			return false;
		}
		
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
	public List<IRelationship> getRelationshipsOfType(ERelationshipType relationshipType) {
		
		switch(relationshipType) {
			case aegtefaelle: return aegtefaelle();
			case boern: return boern();
			case bopaelssamling: return bopaelssamling();
			case erstatingAf: return erstatingAf();
			case erstatingFor: return erstatingFor();
			case fader:	return fader();
			case foraeldremydighedsboern: return foraeldremydighedsboern();
			case foraeldremyndighedsindehaver:return foraeldremyndighedsindehaver();					
			case moder: return moder();
			case registreretPartner: return registreretPartner();
			case retligHandleevneVaergeForPersonen: return retligHandleevneVaergeForPersonen();
			case retligHandleevneVaergemaalsindehaver: return retligHandleevneVaergemaalsindehaver();
			default: throw new IllegalArgumentException(); //If ERelationshipType is modified it will be caught
		}
		
	}
}
