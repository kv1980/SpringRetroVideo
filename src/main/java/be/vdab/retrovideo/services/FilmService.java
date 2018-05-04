package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.entities.Film;

public interface FilmService {
	void update(Film film);
	List<Film> findFilmsByGenreId(long id);
	Film findFilmById (long id);
}
