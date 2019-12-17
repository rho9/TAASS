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
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
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

	@RequestMapping("/getScontiAttivi")
	public List<Sconto> getScontiAttivi(@CurrentUser UserPrincipal userPrincipal) {
		List<Sconto> result = new ArrayList<>();

		for (Sconto s : scontoRepository.findAll()) {
			if (s.getUser().getEmail().equals(userPrincipal.getEmail())) {
				result.add(s);
			}
		}

		return result;
	}

	@RequestMapping("/findScontiByUtente")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Sconto> findScontiByUtente(@RequestBody String body) {
		List<Sconto> result = new ArrayList<>();
		User user = userRepository.findByEmail(body).get();

		for (Sconto s : scontoRepository.findAll()) {
			if (s.getUser().getId().equals(user.getId())) {
				result.add(s);
			}
		}

		return result;
	}

	@RequestMapping("/removeSconto")
	@PreAuthorize("hasRole('ADMIN')")
	public void removeSconto(@RequestBody String body) {
		scontoRepository.delete(scontoRepository.findById(Long.parseLong(body)).get());
	}
}
