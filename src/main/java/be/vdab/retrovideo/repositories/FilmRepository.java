package be.vdab.retrovideo.repositories;

import java.util.List;

import be.vdab.retrovideo.entities.Film;

public interface FilmRepository {
	void update(Film film);

	List<Film> findFilmsByGenreId(long genreId);

	Film findFilmById(long filmId);
}