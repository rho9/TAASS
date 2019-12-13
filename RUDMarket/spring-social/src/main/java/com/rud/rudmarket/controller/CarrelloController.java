package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.User;
import com.rud.rudmarket.model.form.ProdottoInCarrelloForm;
import com.rud.rudmarket.model.form.SezioneForm;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProdottoRepository prodottoRepository;

	@PostMapping("/addProdottoInCarrello")
	public boolean addSezione(@CurrentUser UserPrincipal userPrincipal, @RequestBody ProdottoInCarrelloForm prodottoInCarrelloForm) {
		System.out.println(userPrincipal.getEmail() + " " + prodottoInCarrelloForm.getIdProdotto());
		String userEmail = userPrincipal.getEmail();
		Long idProdotto = Long.parseLong(prodottoInCarrelloForm.getIdProdotto());

		User user = userRepository.findByEmail(userEmail).get();
		Prodotto prodotto = prodottoRepository.findById(idProdotto).get();
		List<User> users = prodotto.getCarrelloUtenti();
		users.add(user);
		prodotto.setCarrelloUtenti(users);

		prodottoRepository.save(prodotto);

		return true;
	}
}
