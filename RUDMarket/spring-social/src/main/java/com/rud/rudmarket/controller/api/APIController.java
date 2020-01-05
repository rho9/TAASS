package com.rud.rudmarket.controller.api;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.api.ProdottoAPI;
import com.rud.rudmarket.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	ProdottoRepository prodottoRepository;

	@GetMapping("/getProdottiByName/{name}")
	public List<ProdottoAPI> getProdottiByName(@PathVariable String name) {
		List<ProdottoAPI> result = new ArrayList<>();

		for (Prodotto p : prodottoRepository.findAll()) {
			if (p.getNome().toLowerCase().contains(name.toLowerCase())) {
				ProdottoAPI prodottoAPI = new ProdottoAPI(p);
				result.add(prodottoAPI);
			}
		}

		return result;
	}
}
