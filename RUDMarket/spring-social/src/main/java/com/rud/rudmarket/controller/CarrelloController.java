package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Carrello;
import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.User;
import com.rud.rudmarket.model.form.ProdottoInCarrelloForm;
import com.rud.rudmarket.repository.CarrelloRepository;
import com.rud.rudmarket.repository.ProdottoRepository;
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

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProdottoRepository prodottoRepository;

	@Autowired
	CarrelloRepository carrelloRepository;

	@PostMapping("/addProdottoInCarrello")
	public boolean addProdottoInCarrello(@CurrentUser UserPrincipal userPrincipal, @RequestBody ProdottoInCarrelloForm prodottoInCarrelloForm) {
		System.out.println(userPrincipal.getEmail() + " " + prodottoInCarrelloForm.getIdProdotto());

		String userEmail = userPrincipal.getEmail();
		Long idProdotto = Long.parseLong(prodottoInCarrelloForm.getIdProdotto());

		User user = userRepository.findByEmail(userEmail).get();
		Prodotto prodotto = prodottoRepository.findById(idProdotto).get();

		Carrello carrello = new Carrello();
		carrello.setUser(user);
		carrello.setProdotto(prodotto);

		carrelloRepository.save(carrello);

		return true;
  	}
    
	@RequestMapping("/getProdottiInCarrello")
	public List<Prodotto> getProdottiInCarrello(@CurrentUser UserPrincipal userPrincipal) {
		System.out.println(userPrincipal.getEmail());
		List<Prodotto> prodottoList = new ArrayList<>();
		Prodotto prodotto = new Prodotto();
		prodotto.setNome("Nome1_TEST");
		prodottoList.add(prodotto);
		return prodottoList;
	}
}
