package it.rud.rudmarket.controller;

import it.rud.rudmarket.repository.CatalogoRepository;
import it.rud.rudmarket.service.RUDUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired
	CatalogoRepository catalogoRepository;

	@PostMapping("/findAllSezioni")
	public ModelAndView findAllSezioni(Model model) {
		ModelAndView modelAndView = new ModelAndView("catalogo");
		modelAndView.addObject("list", catalogoRepository.findAll());
		return modelAndView;
	}
}
