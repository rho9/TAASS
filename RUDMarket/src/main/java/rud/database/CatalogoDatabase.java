package rud.database;

import rud.model.Sezione;

import java.util.List;

public interface CatalogoDatabase {
	List<Sezione> findAllSezioni();
}
