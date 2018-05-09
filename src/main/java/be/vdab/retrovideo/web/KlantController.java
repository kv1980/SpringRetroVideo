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
	private final static String KLANT_VIEW = "klant";

	public KlantController(KlantService klantService) {
		this.klantService = klantService;
	}
	
	@GetMapping
	ModelAndView voorSubmitFamilienaam() {
		return new ModelAndView(KLANT_VIEW).addObject(new KlantForm());
	}

	@GetMapping(params = "letters")
	ModelAndView naSubmitFamilienaam(@Valid KlantForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(KLANT_VIEW);
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Klant> klanten = klantService.findKlantenByLetters(form.getLetters());
		if (klanten.isEmpty()) {
			bindingResult.reject("geenKlanten");
		} else {
			modelAndView.addObject("klanten",klanten);
		}
		return modelAndView;
	}
}