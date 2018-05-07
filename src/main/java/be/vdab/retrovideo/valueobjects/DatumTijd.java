package be.vdab.retrovideo.valueobjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatumTijd {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private LocalDateTime waarde;
	
	public DatumTijd(LocalDateTime waarde) {
		this.waarde = waarde;
	}
	
	public DatumTijd(String waarde) {
		this.waarde = LocalDateTime.parse(waarde,FORMATTER);
	}
	
	public LocalDateTime getWaarde() {
		return waarde;
	}
	
	@Override
	public String toString() {
		return waarde.format(FORMATTER);
	}
}