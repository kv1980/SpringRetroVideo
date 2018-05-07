package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmService;

@Controller 				
@RequestMapping("/film") 
class FilmController {
	private final FilmService filmService;
	private final static String FILM_VIEW = "film";


	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@GetMapping("{filmId}")
	ModelAndView index(@PathVariable long filmId) {
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW,"film",filmService.findFilmById(filmId));
		return modelAndView;
	}
}