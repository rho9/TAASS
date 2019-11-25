package it.rud.rudmarket.service;

import it.rud.rudmarket.model.Prodotto;
import it.rud.rudmarket.model.Sezione;
import it.rud.rudmarket.repository.ProdottoRepository;
import it.rud.rudmarket.repository.SezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepository;

	@Autowired
	SezioneRepository sezioneRepository;

	@Override
	public boolean addProdotto(String nomeProdotto, String nomeSezione) {
		Optional<Prodotto> prodottoOptional = prodottoRepository.findById(nomeProdotto);

		if (prodottoOptional.isPresent()) {
			return false;
		}

		Prodotto prodotto = new Prodotto(nomeProdotto);
		prodottoRepository.saveAndFlush(prodotto);
		Sezione sezione = sezioneRepository.findById(nomeSezione).get();
		sezione.getProdottoList().add(prodotto);
		sezioneRepository.saveAndFlush(sezione);
		return true;
	}
}
