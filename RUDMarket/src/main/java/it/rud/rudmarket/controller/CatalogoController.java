package it.rud.rudmarket.controller;

import it.rud.rudmarket.repository.CatalogoRepository;
import it.rud.rudmarket.repository.CatalogoRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	@PostMapping("/findAllSezioni")
	public ModelAndView findAllSezioni(Model model) {
		CatalogoRepository catalogoRepository = new CatalogoRepositoryImpl();
		ModelAndView modelAndView = new ModelAndView("catalogo");
		modelAndView.addObject("list", catalogoRepository.findAllSezioni());
		return modelAndView;
	}
}
