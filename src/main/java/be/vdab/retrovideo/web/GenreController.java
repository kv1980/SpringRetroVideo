package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;

@Controller 				
@RequestMapping("/genre") 
class GenreController {
	private final GenreService genreService;
	private final FilmService filmService;
	private final static String GENRE_VIEW = "genre";
 

	public GenreController(GenreService genreService,FilmService filmService) {
		this.genreService = genreService;
		this.filmService = filmService;
	}
	
	@GetMapping("{genreId}")
	ModelAndView index(@PathVariable long genreId) {
		ModelAndView modelAndView = new ModelAndView(GENRE_VIEW);
		modelAndView.addObject("genres",genreService.findAll());
		modelAndView.addObject("genreId",genreId);
		modelAndView.addObject("films",filmService.findFilmsByGenreId(genreId));
		return modelAndView;
	}
}
