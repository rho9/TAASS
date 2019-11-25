package it.rud.rudmarket.controller.rest;

import it.rud.rudmarket.repository.CatalogoRepository;
import it.rud.rudmarket.model.Sezione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/catalogo")
public class CatalogoRestController {

	@Autowired
	CatalogoRepository catalogoRepository;

	@RequestMapping("/findAllSezioni")
	public List<Sezione> findAllSezioni() {
		return catalogoRepository.findAll();
	}
}
