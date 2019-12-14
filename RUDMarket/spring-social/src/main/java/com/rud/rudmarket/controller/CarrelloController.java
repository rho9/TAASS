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

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

	@RequestMapping("/getProdottiInCarrello")
	public List<Prodotto> getProdottiInCarrello(@CurrentUser UserPrincipal userPrincipal, @RequestBody String body) {
		String email = body.split("=")[1];
		System.out.println(email);
		List<Prodotto> prodottoList = new ArrayList<>();
		Prodotto prodotto = new Prodotto();
		prodotto.setNome("Nome");
		prodottoList.add(prodotto);
		return prodottoList;
	}
}
