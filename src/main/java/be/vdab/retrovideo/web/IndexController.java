package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;

@Controller 				
@RequestMapping("/") 
class IndexController {
	private final GenreService genreService;
	private final FilmService filmService;
	private final static String INDEX_VIEW = "index";
	private final static String GENRE_VIEW= "genre";
 

	public IndexController(GenreService genreService,FilmService filmService) {
		this.genreService = genreService;
		this.filmService = filmService;
	}

	@GetMapping
	ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(INDEX_VIEW);
		modelAndView.addObject("genres",genreService.findAll());
		return modelAndView;
	}
	
	@GetMapping(params = "genreId")
	ModelAndView index(long id) {
		ModelAndView modelAndView = new ModelAndView(GENRE_VIEW);
		modelAndView.addObject("genres",genreService.findAll());
		modelAndView.addObject("genreId",id);
		modelAndView.addObject("films",filmService.findFilmsByGenreId(id));
		return modelAndView;
	}
}
