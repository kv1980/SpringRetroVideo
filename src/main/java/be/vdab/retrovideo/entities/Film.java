package be.vdab.retrovideo.entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class Film {
	private final long id;
	private final long genreId;
	private final String titel;
	private int voorraad;
	private int gereserveerd;
	@NumberFormat(pattern ="0.00")
	private final BigDecimal prijs;
	
	public Film(long id, long genreId, String titel, int voorraad, BigDecimal prijs) {
		this.id = id;
		this.genreId = genreId;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = 0;
		this.prijs = prijs;
	}

	public void setGereserveerd(int gereserveerd) {
		this.gereserveerd = gereserveerd;
	}

	public long getId() {
		return id;
	}

	public long getGenreId() {
		return genreId;
	}

	public String getTitel() {
		return titel;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public int getGereserveerd() {
		return gereserveerd;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}
	
	public int toonBeschikbareExemplaren() {
		return voorraad-gereserveerd;
	}
}