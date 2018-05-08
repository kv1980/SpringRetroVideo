package be.vdab.retrovideo.valueobjects;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class Totaalprijs {
	@NumberFormat(pattern = "€ 0.00")
	private final BigDecimal waarde;

	public Totaalprijs(BigDecimal waarde) {
		this.waarde = waarde;
	}
	
	public BigDecimal getWaarde() {
		return waarde;
	}
}