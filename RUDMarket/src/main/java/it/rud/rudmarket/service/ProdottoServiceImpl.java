package it.rud.rudmarket.service;

import it.rud.rudmarket.model.Prodotto;
import it.rud.rudmarket.model.Sezione;
import it.rud.rudmarket.repository.ProdottoRepository;
import it.rud.rudmarket.repository.SezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepository;

	@Autowired
	SezioneRepository sezioneRepository;

	@Override
	public void addProdotto(String nomeProdotto, String nomeSezione) {
		Prodotto prodotto = new Prodotto(nomeProdotto);
		prodottoRepository.saveAndFlush(prodotto);
		Sezione sezione = sezioneRepository.findById(nomeSezione).get();
		sezione.getProdottoList().add(prodotto);
		sezioneRepository.saveAndFlush(sezione);
	}
}
