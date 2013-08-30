package util.cprbroker.models;

import util.cprbroker.IContact;

public class Contact implements IContact {
	
	private final String limitedUsageText;
	private final String email;
	private final String noteText;
	private final String phone;
	private final String otherContactText;
	private final String otherContactNoteText;
	private final Boolean isPhoneAbleToRecieveSms;
	
	public static class Builder {
	
		private boolean isPhoneAbleToRecieveSms;
		private String limitedUsageText;
		private String email;
		private String noteText;
		private String phone;
		private String otherContactText;
		private String otherContactNoteText;
		
		public IContact build() { return new Contact(this); }
		
		public Builder limitedUsageText(String newText) {limitedUsageText = newText; return this;}
		public Builder email(String newEmail) {email = newEmail; return this;}
		public Builder noteText(String newText) {noteText = newText; return this;}
		public Builder phone(String newPhone) {phone = newPhone; return this;}
		public Builder otherContactText(String newText) {otherContactText = newText; return this;}
		public Builder otherContactNoteText(String newText) {otherContactNoteText = newText; return this;}
		public Builder isPhoneAbleToRecieveSms(boolean isAble) {isPhoneAbleToRecieveSms = isAble; return this; }
	}
	
	private Contact(Builder builder) {
		limitedUsageText = builder.limitedUsageText;
		email = builder.email;
		noteText = builder.noteText;
		phone = builder.phone;
		otherContactText = builder.otherContactText;
		otherContactNoteText = builder.otherContactNoteText;
		isPhoneAbleToRecieveSms = builder.isPhoneAbleToRecieveSms;
	}

	@Override
	public String limitedUsageText() { return limitedUsageText; }

	@Override
	public String email() { return email; }

	@Override
	public String noteText() { return noteText;	}

	@Override
	public String phone() { return phone; }

	@Override
	public String otherContactText() { return otherContactText;	}

	@Override
	public String otherContactNoteText() { return otherContactNoteText;	}

	@Override
	public Boolean isPhoneAbleToRecieveSms() { return isPhoneAbleToRecieveSms; }

}
