package rud.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rud.database.CatalogoDatabase;
import rud.database.CatalogoHibernateDatabase;
import rud.model.Sezione;

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
