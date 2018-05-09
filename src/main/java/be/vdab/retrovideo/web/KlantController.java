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

@Controller
@RequestMapping("/klant")
class KlantController {
	private final KlantService klantService;
	private final Mandje mandje;
	private final Identificatie identificatie;
	
	private final static String KLANTEN_VIEW = "klant";
	private final static String REDIRECT_NA_BEVESTIGING = "redirect:/bestelling";

	public KlantController(KlantService klantService,Mandje mandje,Identificatie identificatie) {
		this.klantService = klantService;
		this.mandje = mandje;
		this.identificatie = identificatie;
	}
	
	@GetMapping
	ModelAndView voorZoekenOpFamilienaam() {
		return new ModelAndView(KLANTEN_VIEW).addObject(new KlantForm());
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