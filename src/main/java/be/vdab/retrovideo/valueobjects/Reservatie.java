package be.vdab.retrovideo.valueobjects;

public class Reservatie {
	private final long klantId;
	private final long filmId;
	private DatumTijd reservatietijd;
	
	public Reservatie(long klantId, long filmId, Object datumTijd) {
		this.klantId = klantId;
		this.filmId = filmId;
		this.reservatietijd = (DatumTijd) datumTijd;
	}

	public long getKlantId() {
		return klantId;
	}

	public long getFilmId() {
		return filmId;
	}	
	
	public DatumTijd getReservatietijd() {
		return reservatietijd;
	}
}