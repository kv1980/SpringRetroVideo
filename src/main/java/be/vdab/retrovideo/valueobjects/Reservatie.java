package be.vdab.retrovideo.valueobjects;

import java.time.LocalDateTime;

public class Reservatie {
	private final long klantId;
	private final long filmId;
	private LocalDateTime reservatietijd;
	
	public Reservatie(long klantId, long filmId, LocalDateTime reservatietijd) {
		this.klantId = klantId;
		this.filmId = filmId;
		this.reservatietijd = reservatietijd;
	}

	public long getKlantId() {
		return klantId;
	}

	public long getFilmId() {
		return filmId;
	}	
	
	public LocalDateTime getReservatietijd() {
		return reservatietijd;
	}
}