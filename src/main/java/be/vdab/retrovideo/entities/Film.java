package be.vdab.retrovideo.entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class Film {
	private final long id;
	private final String titel;
	private int voorraad;
	private int gereserveerd;
	@NumberFormat(pattern = "0.00")
	private final BigDecimal prijs;

	public Film(long id, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
		this.id = id;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}

	public long getId() {
		return id;
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

	public void reserveer() {
		gereserveerd++;
	}

	public int toonBeschikbareExemplaren() {
		return voorraad - gereserveerd;
	}

	public boolean isBeschikbaar() {
		return voorraad > gereserveerd;
	}
}