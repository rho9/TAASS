package it.rud.rudmarket.controller;

import it.rud.rudmarket.database.CatalogoDatabase;
import it.rud.rudmarket.database.CatalogoHibernateDatabase;
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
		CatalogoDatabase catalogoDatabase = new CatalogoHibernateDatabase();
		ModelAndView modelAndView = new ModelAndView("catalogo");
		modelAndView.addObject("list", catalogoDatabase.findAllSezioni());
		return modelAndView;
	}
}
