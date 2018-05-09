package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
class DefaultReserveringService implements ReserveringService {
	private final FilmService filmService;
	private final ReservatieService reservatieService;
	private final KlantService klantService;

	public DefaultReserveringService(FilmService filmService, ReservatieService reservatieService, KlantService klantService) {
		this.filmService = filmService;
		this.reservatieService = reservatieService;
		this.klantService = klantService;
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
	public String getKlantnaam(long klantId) {
		klantService.
		return null;
	}
}