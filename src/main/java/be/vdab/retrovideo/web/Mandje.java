package be.vdab.retrovideo.web;

import java.util.Set;

public interface Mandje {
	void addFilmId(long filmId);
	Set<Long> getFilmIds();
}