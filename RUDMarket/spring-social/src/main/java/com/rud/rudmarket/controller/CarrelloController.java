package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.*;
import com.rud.rudmarket.model.form.ProdottoInCarrelloForm;
import com.rud.rudmarket.repository.CarrelloRepository;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.ScontoRepository;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProdottoRepository prodottoRepository;

	@Autowired
	CarrelloRepository carrelloRepository;

	@Autowired
	ScontoRepository scontoRepository;

	@Autowired
	ScontoController scontoController;

	@PostMapping("/addProdottoInCarrello")
	public boolean addProdottoInCarrello(@CurrentUser UserPrincipal userPrincipal, @RequestBody ProdottoInCarrelloForm prodottoInCarrelloForm) {
		System.out.println(userPrincipal.getEmail() + " " + prodottoInCarrelloForm.getIdProdotto());

		String userEmail = userPrincipal.getEmail();
		Long idProdotto = Long.parseLong(prodottoInCarrelloForm.getIdProdotto());

		User user = userRepository.findByEmail(userEmail).get();
		Prodotto prodotto = prodottoRepository.findById(idProdotto).get();

		String carrelloId = user.getId() + "_" + prodotto.getId();
		Optional<Carrello> optionalCarrello = carrelloRepository.findById(carrelloId);
		Carrello carrello;

		if (optionalCarrello.isPresent()) {
			carrello = optionalCarrello.get();
			carrello.setQuantita(carrello.getQuantita() + prodottoInCarrelloForm.getQuantita());
		} else {
			carrello = new Carrello();
			carrello.setId(carrelloId);
			carrello.setUser(user);
			carrello.setProdotto(prodotto);
			carrello.setQuantita(prodottoInCarrelloForm.getQuantita());
		}

		carrelloRepository.save(carrello);

		return true;
  	}
    
	@RequestMapping("/getProdottiInCarrello")
	public List<ProdottoInCarrello> getProdottiInCarrello(@CurrentUser UserPrincipal userPrincipal) {
		List<ProdottoInCarrello> result = new ArrayList<>();
		Prodotto prodotto;
		Long userId = userPrincipal.getId();
		List<Sconto> scontiAttivi = scontoController.getScontiAttivi(userPrincipal);

		for(Carrello c : carrelloRepository.findAll()){
			if(c.getUser().getId().equals(userId)) {
				prodotto = c.getProdotto();
				int percSconto = 0;
				for (Sconto scontoAttivo : scontiAttivi) {
					if (scontoAttivo.getProdotto().getId().equals(prodotto.getId())) {
						percSconto = scontoAttivo.getPerc();
					}
				}
				result.add(new ProdottoInCarrello(prodotto, percSconto, c.getQuantita()));
			}
		}
		return result;
	}

	@RequestMapping("/getCostoTotale")
	public float getCostoTotale(@CurrentUser UserPrincipal userPrincipal){
		List<ProdottoInCarrello> prodottoList = getProdottiInCarrello(userPrincipal);
		float costoTotale = 0;
		float sumCosto;
		for(ProdottoInCarrello prodottoInCarrello : prodottoList){
			sumCosto = prodottoInCarrello.getProdotto().getPrezzo() -
					((prodottoInCarrello.getPercSconto() * prodottoInCarrello.getProdotto().getPrezzo()) / 100);
			System.out.println(sumCosto);
			costoTotale += sumCosto * prodottoInCarrello.getQuantita();
		}
		return costoTotale;
	}

	@PostMapping("/effettuaPagamento")
	public boolean effettuaPagamento(@CurrentUser UserPrincipal userPrincipal) {
		for(Carrello carrello : carrelloRepository.findAll()){
			if (carrello.getUser().getId().equals(userPrincipal.getId())) {
				carrelloRepository.delete(carrello);
			}
		}
		return true;
	}
}
