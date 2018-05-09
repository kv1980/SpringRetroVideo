package be.vdab.retrovideo.entities;

public class Klant {
	private final long id;
	private final String familienaam;
	private final String voornaam;
	private final String straatNummer;
	private final String postnummer;
	private final String gemeente;

	public Klant(long id, String familienaam, String voornaam, String straatNummer, String postnummer,
			String gemeente) {
		this.id = id;
		this.familienaam = familienaam;
		this.voornaam = voornaam;
		this.straatNummer = straatNummer;
		this.postnummer = postnummer;
		this.gemeente = gemeente;
	}

	public long getId() {
		return id;
	}

	public String getFamilienaam() {
		return familienaam;
	}
	
	public String getNaam() {
		return voornaam+" "+familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getStraatNummer() {
		return straatNummer;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public String getGemeente() {
		return gemeente;
	}
}