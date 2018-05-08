package be.vdab.retrovideo.web;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.services.FilmService;

@Controller
@RequestMapping("mandje")
class MandjeController {
	private final Mandje mandje;
	private final FilmService filmService;
	private static final String VIEW ="mandje";
	private static final String REDIRECT_NA_VERWIJDEREN = "redirect:/mandje";
	
	public MandjeController(Mandje mandje, FilmService filmService) {
		this.mandje = mandje;
		this.filmService = filmService;
	}
	
	private Set<Film> maakFilmsVanFilmIds(Set<Long> filmIds){
		Set<Film> geselecteerdeFilms = new LinkedHashSet<>();
		for (long filmId : filmIds) {
			geselecteerdeFilms.add(filmService.findFilmById(filmId));
		}
		return geselecteerdeFilms;
	}
	
	@GetMapping
	ModelAndView toonMandje() {
		return new ModelAndView(VIEW)
				.addObject(new MandjeForm())
				.addObject("filmsInMandje",maakFilmsVanFilmIds(mandje.getFilmIds()));
	}
	
	@GetMapping
	ModelAndView verwijderFilmUitMandje() {
		return new ModelAndView(VIEW)
				.addObject(new MandjeForm())
				.addObject("filmsInMandje",maakFilmsVanFilmIds(mandje.getFilmIds()));
	}
	

}
