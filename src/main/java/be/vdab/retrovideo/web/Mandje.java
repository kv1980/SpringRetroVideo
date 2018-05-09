package be.vdab.retrovideo.web;

import java.util.Set;

public interface Mandje {
	void voegFilmIdtoe(long filmId);
	void verwijderFilmId(long filmId);
	Set<Long> getFilmIds();
}