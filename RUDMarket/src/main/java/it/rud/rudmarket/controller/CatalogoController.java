package it.rud.rudmarket.controller;

import it.rud.rudmarket.service.SezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired
	SezioneService sezioneService;

	@RequestMapping("/findAllSezioni")
	public ModelAndView findAllSezioni(Model model) {
		ModelAndView modelAndView = new ModelAndView("catalogo");
		modelAndView.addObject("list", sezioneService.getSezioni());
		return modelAndView;
	}
}
