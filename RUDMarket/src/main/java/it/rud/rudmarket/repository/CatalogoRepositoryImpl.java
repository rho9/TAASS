package it.rud.rudmarket.repository;


import it.rud.rudmarket.model.Sezione;

import java.util.ArrayList;
import java.util.List;

public class CatalogoRepositoryImpl implements CatalogoRepository {
	@Override
	public List<Sezione> findAllSezioni() {
		List<Sezione> sezioneList = new ArrayList<>();
		sezioneList.add(new Sezione("Carne"));
		sezioneList.add(new Sezione("Pesce"));
		return sezioneList;
	}
}
