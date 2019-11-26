package it.rud.rudmarket.controller;

import it.rud.rudmarket.service.ProdottoService;
import it.rud.rudmarket.service.RUDUserDetailsService;
import it.rud.rudmarket.service.SezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gestione")
public class GestioneController {

	@Autowired
	SezioneService sezioneService;

	@Autowired
	ProdottoService prodottoService;

	@Autowired
	@Qualifier("udsi")
	RUDUserDetailsService rudUserDetailsService;

	@RequestMapping("/viewAdmin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("/gestione/admin");
		return modelAndView;
	}

	@RequestMapping("/viewProdotto")
	public ModelAndView viewProdotto() {
		ModelAndView modelAndView = new ModelAndView("/gestione/prodotto");
		modelAndView.addObject("sezioni", sezioneService.getSezioni());
		return modelAndView;
	}

	@RequestMapping("/doAddProdotto")
	public String doAddProdotto(
			@RequestParam(name  ="nomeProdotto") String nomeProdotto,
			@RequestParam(name = "marcaProdotto") String marcaProdotto,
			@RequestParam(name = "prezzo") int prezzo,
			@RequestParam(name = "nomeSezione") String nomeSezione) {
		if (prodottoService.addProdotto(nomeProdotto, marcaProdotto, prezzo, nomeSezione)) {
			return "forward:/gestione/viewProdotto";
		} else {
			return "forward:/error";
		}
	}

	@RequestMapping("/viewChangeRole")
	public ModelAndView viewChangeRole(){
		ModelAndView modelAndView = new ModelAndView("/gestione/changeRole");
		modelAndView.addObject("utenti", rudUserDetailsService.getUserUsername());
		return modelAndView;
	}

	@RequestMapping("/upgradeRole")
	public String upgradeRole(@RequestParam(name="nomeUtente") String nomeUtente){
		rudUserDetailsService.upgradeRole(nomeUtente);
		return "forward:/gestione/viewAdmin";
	}
}
