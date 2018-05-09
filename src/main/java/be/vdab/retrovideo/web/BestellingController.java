package be.vdab.retrovideo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.services.ReserveringService;

@Controller
@RequestMapping("/bestelling")
class BestellingController {
	private final ReserveringService reserveringService;
	private final Mandje mandje;
	private final static String BEVESTIGEN_VIEW = "bevestigen";
	private final static String RAPPORT_VIEW = "rapport";

	public BestellingController(ReserveringService reserveringService, Mandje mandje) {
		this.reserveringService = reserveringService;
		this.mandje = mandje;
	}

	@GetMapping("bevestigen/{klantId}")
	ModelAndView voorBevestigen(@PathVariable long klantId) {
		return new ModelAndView(BEVESTIGEN_VIEW).addObject("aantalFilms", mandje.getFilmIds().size()).addObject("klant",
				reserveringService.getKlant(klantId));
	}

	@GetMapping("rapport/{klantId}")
	ModelAndView naBevestigen(@PathVariable long klantId) {
		List<Film> nietGereserveerdeFilms = new ArrayList<>();
		for (long filmId : mandje.getFilmIds()) {
			if (!reserveringService.isGereserveerd(klantId, filmId)) {
				nietGereserveerdeFilms.add(reserveringService.getFilm(filmId));
			}
			mandje.verwijderFilmId(filmId);
		}
		return new ModelAndView(RAPPORT_VIEW).addObject("nietGereserveerdeFilms", nietGereserveerdeFilms);
	}
}