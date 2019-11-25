package it.rud.rudmarket.controller.rest;

import it.rud.rudmarket.repository.SezioneRepository;
import it.rud.rudmarket.model.Sezione;
import it.rud.rudmarket.service.SezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/rest/catalogo")
public class CatalogoRestController {

	@Autowired
	SezioneService sezioneService;

	@RequestMapping("/findAllSezioni")
	public List<Sezione> findAllSezioni(Model model) {
		return sezioneService.getSezioni();
	}
}
