package be.vdab.retrovideo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.repositories.FilmRepository;
import be.vdab.retrovideo.repositories.ReservatieRepository;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class DefaultReservatieService implements ReservatieService{
	private final FilmRepository filmRepository;
	private final ReservatieRepository reservatieRepository;

	public DefaultReservatieService(FilmRepository filmRepository, ReservatieRepository reservatieRepository) {
		super();
		this.filmRepository = filmRepository;
		this.reservatieRepository = reservatieRepository;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
	public void create(Reservatie reservatie) {
		Film film = filmRepository.findFilmById(reservatie.getFilmId());
		if (film.isBeschikbaar()) {
			reservatieRepository.create(reservatie);
		}
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public Optional<Reservatie> read(Reservatie reservatie) {
		return reservatieRepository.read(reservatie);
	}
}