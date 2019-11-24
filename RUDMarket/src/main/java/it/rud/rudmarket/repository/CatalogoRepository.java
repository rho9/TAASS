package it.rud.rudmarket.repository;


import it.rud.rudmarket.model.Sezione;

import java.util.List;


public interface CatalogoRepository {
	List<Sezione> findAllSezioni();
}
