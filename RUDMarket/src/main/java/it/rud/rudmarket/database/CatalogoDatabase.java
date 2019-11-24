package it.rud.rudmarket.database;


import it.rud.rudmarket.model.Sezione;

import java.util.List;


public interface CatalogoDatabase {
	List<Sezione> findAllSezioni();
}
