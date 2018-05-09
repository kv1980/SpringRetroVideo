package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmService;

@Controller
@RequestMapping("/film")
class FilmController {
	private final Mandje mandje;
	private final FilmService filmService;
	private final static String FILM_VIEW = "film";
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/mandje";

	public FilmController(FilmService filmService, Mandje mandje) {
		this.filmService = filmService;
		this.mandje = mandje;
	}

	@GetMapping("{filmId}")
	ModelAndView filmVoorMandje(@PathVariable long filmId) {
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW).addObject("film", filmService.findFilmById(filmId));
		return modelAndView;
	}

	@PostMapping
	String voegFilmtoeAanMandje(MandjeForm form) {
		mandje.voegFilmIdtoe(form.getFilmId());
		return REDIRECT_NA_TOEVOEGEN;
	}
}