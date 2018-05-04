package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.repositories.FilmRepository;
import be.vdab.retrovideo.repositories.ReservatieRepository;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
class DefaultReservatieService implements ReservatieService{
	private ReservatieRepository reservatieRepository;
	private FilmRepository filmRepository;

	public DefaultReservatieService(ReservatieRepository reservatieRepository, FilmRepository filmRepository) {
		this.reservatieRepository = reservatieRepository;
		this.filmRepository = filmRepository;
	}

	@Override
	public String voerEenReservatieUit(Reservatie reservatie) {
		Film film = filmRepository.findFilmById(reservatie.getFilmId());
		if (film.toonBeschikbareExemplaren()!=0) {
			film.verhoogAantalGereserveerdMetEen();
			filmRepository.update(film);
			reservatieRepository.create(reservatie);
			return "";
		} else {
			return film.getTitel();
		}
	}
}