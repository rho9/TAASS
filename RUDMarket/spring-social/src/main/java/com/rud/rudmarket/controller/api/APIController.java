package com.rud.rudmarket.controller.api;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.api.ProdottoAPI;
import com.rud.rudmarket.model.form.SezioneForm;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	ProdottoRepository prodottoRepository;

	@GetMapping("/getProdottiByName")
	public List<ProdottoAPI> addSezione(@RequestBody String body) {
		List<ProdottoAPI> result = new ArrayList<>();

		for (Prodotto p : prodottoRepository.findAll()) {
			if (p.getNome().toLowerCase().contains(body.toLowerCase())) {
				ProdottoAPI prodottoAPI = new ProdottoAPI(p);
				result.add(prodottoAPI);
			}
		}

		return result;
	}
}
