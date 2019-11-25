package it.rud.rudmarket.controller;

import it.rud.rudmarket.repository.SezioneRepository;
import it.rud.rudmarket.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gestione")
public class GestioneController {

	@Autowired
	SezioneRepository sezioneRepository;

	@Autowired
	ProdottoService prodottoService;

	@RequestMapping("/viewAdmin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("/gestione/admin");
		return modelAndView;
	}

	@RequestMapping("/viewProdotto")
	public ModelAndView viewProdotto() {
		ModelAndView modelAndView = new ModelAndView("/gestione/prodotto");
		modelAndView.addObject("sezioni", sezioneRepository.findAll());
		return modelAndView;
	}

	@RequestMapping("/doAddProdotto")
	public String doAddProdotto(@RequestParam(name="nomeProdotto") String nomeProdotto, @RequestParam(name="nomeSezione") String nomeSezione) {
		prodottoService.addProdotto(nomeProdotto, nomeSezione);
		return "forward:/gestione/viewProdotto";
	}
}
