package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
class DefaultReserveringService implements ReserveringService {
	private final FilmService filmService;
	private final KlantService klantService;
	private final ReservatieService reservatieService;

	public DefaultReserveringService(FilmService filmService, KlantService klantService,
			ReservatieService reservatieService) {
		this.filmService = filmService;
		this.klantService = klantService;
		this.reservatieService = reservatieService;
	}

	@Override
	public boolean isGereserveerd(long klantId, long filmId) {
		Film film = filmService.findFilmById(filmId);
		if (film.isBeschikbaar()) {
			Reservatie reservatie = new Reservatie(klantId, filmId);
			reservatieService.create(reservatie);
			filmService.update(film);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Klant getKlant(long klantId) {
		return klantService.findKlantById(klantId);
	}

	@Override
	public Film getFilm(long filmId) {
		return filmService.findFilmById(filmId);
	}
}