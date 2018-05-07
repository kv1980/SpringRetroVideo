package be.vdab.retrovideo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.repositories.FilmRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultFilmService implements FilmService {
	private final FilmRepository repository;

	public DefaultFilmService(FilmRepository repository) {
		this.repository = repository;
	}

	@Override
	public void update(Film film) {
		repository.update(film);
	}

	@Override
	public List<Film> findFilmsByGenreId(long genreId) {
		return repository.findFilmsByGenreId(genreId);
	}

	@Override
	public Film findFilmById(long filmId) {
		return repository.findFilmById(filmId);
	}
}