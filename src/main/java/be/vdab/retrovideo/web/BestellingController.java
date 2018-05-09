package be.vdab.retrovideo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.services.KlantService;
import be.vdab.retrovideo.services.ReserveringService;

@Controller
@RequestMapping("/bestelling")
class BestellingController {
	private final ReserveringService reserveringService;
	private final Mandje mandje;
	private final Identificatie identificatie;
	
	private final static String BEVESTIGEN_VIEW = "klant";
	private final static String RAPPOERT_VIEW = "redirect:/bestelling";
	
	public BestellingController(ReserveringService reserveringService, Mandje mandje, Identificatie identificatie) {
		this.reserveringService = reserveringService;
		this.mandje = mandje;
		this.identificatie = identificatie;
	}

	@GetMapping
	ModelAndView bevestigen() {
		return new ModelAndView(BEVESTIGEN_VIEW)
				.addObject("aantalFilms",mandje.getFilmIds().size());
				.addObject("naamKlant",reserveringService.identificatie.getKlantId())
	}

	@GetMapping(params = "letters")
	ModelAndView voorKeuzeKlant(@Valid KlantForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(KLANTEN_VIEW);
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Klant> klanten = klantService.findKlantenByLetters(form.getLetters());
		if (klanten.isEmpty()) {
			System.out.println("deze is leeg");
			bindingResult.reject("geenKlanten");
		} else {
			modelAndView.addObject("klanten",klanten);
		}
		return modelAndView;
	}
	
	@GetMapping(params = "id")
		ModelAndView naKeuzeKlant(Long id) {
			identificatie.setKlantId(id);
			return new ModelAndView(REDIRECT_NA_BEVESTIGING);
	}
}