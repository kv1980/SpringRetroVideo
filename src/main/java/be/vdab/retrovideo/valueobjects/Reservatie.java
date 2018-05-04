package be.vdab.retrovideo.valueobjects;

import java.time.LocalDate;

public class Reservatie {
	private final long klantId;
	private final long filmId;
	private final LocalDate reservatieDatum;
	
	public Reservatie(long klantId, long filmId) {
		this.klantId = klantId;
		this.filmId = filmId;
		this.reservatieDatum = LocalDate.now();
	}

	public long getKlantId() {
		return klantId;
	}

	public LocalDate getReservatieDatum() {
		return reservatieDatum;
	}

	public long getFilmId() {
		return filmId;
	}
}