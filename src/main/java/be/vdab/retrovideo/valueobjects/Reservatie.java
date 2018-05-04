package be.vdab.retrovideo.valueobjects;

public class Reservatie {
	private final long klantId;
	private final long filmId;
	
	public Reservatie(long klantId, long filmId) {
		this.klantId = klantId;
		this.filmId = filmId;
	}

	public long getKlantId() {
		return klantId;
	}

	public long getFilmId() {
		return filmId;
	}
}