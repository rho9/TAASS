package it.rud.rudmarket.controller.rest;

import it.rud.rudmarket.database.CatalogoDatabase;
import it.rud.rudmarket.database.CatalogoHibernateDatabase;
import it.rud.rudmarket.model.Sezione;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/catalogo")
public class CatalogoRestController {

	@RequestMapping("/findAllSezioni")
	public List<Sezione> findAllSezioni() {
		CatalogoDatabase catalogoDatabase = new CatalogoHibernateDatabase();
		return catalogoDatabase.findAllSezioni();
	}
}
