package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.*;
import com.rud.rudmarket.model.form.OrdineForm;
import com.rud.rudmarket.repository.OrdineRepository;
import com.rud.rudmarket.repository.SupermercatoRepository;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ordine")
public class OrdineController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CarrelloController carrelloController;

	@Autowired
	OrdineRepository ordineRepository;

	@Autowired
	SupermercatoRepository supermercatoRepository;

	@RequestMapping("/addOrdine")
	public boolean addOrdine(@CurrentUser UserPrincipal userPrincipal, @RequestBody OrdineForm ordineForm) {
		System.out.println(ordineForm.getNome());

		User user = userRepository.findByEmail(userPrincipal.getEmail()).get();

		List<Ordine> ordineList = new ArrayList<>();
		Ordine ordine;

		for (ProdottoInCarrello p : carrelloController.getProdottiInCarrello(userPrincipal)) {
			ordine = new Ordine();
			ordine.setId(user.getId() + "_" + p.getProdotto().getId());
			ordine.setUser(user);
			ordine.setProdotto(p.getProdotto());
			ordine.setQuantita(p.getQuantita());

			ordine.setNome(ordineForm.getNome());
			ordine.setCognome(ordineForm.getCognome());

			ordineList.add(ordine);
		}

		if (ordineForm.isIndirizzoChecked()) {
			for (Ordine o : ordineList) {
				o.setIndirizzo(ordineForm.getIndirizzo());
				ordineRepository.save(o);
			}
		} else {
			for (Ordine o : ordineList) {
				String supermercatoNome = supermercatoRepository.findById(Long.parseLong(ordineForm.getSelectedSupermercato())).get().getNome();
				o.setSupermercatoNome(supermercatoNome);
				ordineRepository.save(o);
			}
		}

		return true;
	}

	@RequestMapping("/getOrdiniAttivi")
	public List<Ordine> getOrdiniAttivi(@CurrentUser UserPrincipal userPrincipal) {
		List<Ordine> result = new ArrayList<>();

		for (Ordine s : ordineRepository.findAll()) {
			if (s.getUser().getEmail().equals(userPrincipal.getEmail())) {
				result.add(s);
			}
		}

		return result;
	}
}
