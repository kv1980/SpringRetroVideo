package be.vdab.retrovideo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Genre;
import be.vdab.retrovideo.repositories.GenreRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultGenreService implements GenreService {
	private final GenreRepository repository;

	public DefaultGenreService(GenreRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Genre> vindAlleGenres() {
		return repository.vindAlleGenres();
	}
}