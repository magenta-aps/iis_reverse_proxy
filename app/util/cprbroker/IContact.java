package util.cprbroker;

public interface IContact {

	/**
  			attributes.getKontaktKanal().getAndenKontaktKanal().getKontaktKanalTekst();
			attributes.getKontaktKanal().getAndenKontaktKanal().getNoteTekst();
			attributes.getKontaktKanal().getBegraensetAnvendelseTekst();
			attributes.getKontaktKanal().getEmailAddressIdentifier();
			attributes.getKontaktKanal().getNoteTekst();
			attributes.getKontaktKanal().getTelefon().getTelephoneNumberIdentifier();
			attributes.getKontaktKanal().getTelefon().isKanBrugesTilSmsIndikator();


	 **/
	
	String limitedUsageText();
	String email();
	String noteText();
	String phone();
	Boolean isPhoneAbleToRecieveSms();
	String otherContactText();
	String otherContactNoteText();
	
	
}
