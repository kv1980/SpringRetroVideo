package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.KlantService;

@Controller
@RequestMapping("/klant")
class KlantController {
	private final KlantService klantService;
	private final static String VIEW = "klant";

	public KlantController(KlantService klantService) {
		this.klantService = klantService;
	}
	
	@GetMapping
	ModelAndView zoekKlant() {
		return new ModelAndView(VIEW);
	}

}
