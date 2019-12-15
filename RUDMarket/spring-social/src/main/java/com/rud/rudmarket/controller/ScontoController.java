package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Sconto;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.User;
import com.rud.rudmarket.model.form.ProdottoForm;
import com.rud.rudmarket.model.form.ScontoForm;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.ScontoRepository;
import com.rud.rudmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sconto")
public class ScontoController {

	@Autowired
	ScontoRepository scontoRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProdottoRepository prodottoRepository;

	@PostMapping("/addSconto")
	@PreAuthorize("hasRole('ADMIN')")
	public Prodotto addProdotto(@RequestBody ScontoForm scontoForm) throws Exception {
		if (scontoForm.getSelectedProdotto() != null) {
			User user = userRepository.findByEmail(scontoForm.getEmailUtente()).get();
			Prodotto prodotto = prodottoRepository.findById(scontoForm.getSelectedProdotto()).get();

			Sconto sconto = new Sconto();
			sconto.setUser(user);
			sconto.setProdotto(prodotto);
			sconto.setPerc(Integer.parseInt(scontoForm.getPerc()));

			scontoRepository.save(sconto);
		}

		throw new Exception("Il prodotto inserito non è corretto!");
	}
}
