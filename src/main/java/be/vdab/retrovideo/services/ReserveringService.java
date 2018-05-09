package be.vdab.retrovideo.services;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;

public interface ReserveringService {
	boolean isGereserveerd(long klantId, long filmId);
	Klant getKlant(long klantId);
	Film getFilm(long filmId);
}