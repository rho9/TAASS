package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.SezioneForm;
import com.rud.rudmarket.repository.SezioneRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

	@GetMapping("/getProdottiInCarrello")
	public List<Prodotto> getProdottiInCarrello(@CurrentUser UserPrincipal userPrincipal) {
		System.out.println(userPrincipal);
		List<Prodotto> prodottoList = new ArrayList<>();
		Prodotto prodotto = new Prodotto();
		prodotto.setNome("Nome");
		prodottoList.add(prodotto);
		return prodottoList;
	}
}
