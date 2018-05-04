package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.entities.Film;

public interface FilmService {
	List<Film> findFilmsByGenreId(long id);
	Film findFilmById (long id);
}
