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

import java.util.List;

@RestController
@RequestMapping("/sezione")
public class SezioneController {

	@Autowired
	SezioneRepository sezioneRepository;

	@PostMapping("/addSezione")
	@PreAuthorize("hasRole('ADMIN')")
	public Sezione addSezione(@CurrentUser UserPrincipal userPrincipal, @RequestBody SezioneForm sezioneForm) {
		System.out.println(userPrincipal);
		Sezione sezione = new Sezione();
		sezione.setNome(sezioneForm.getNomeSezione());
		sezioneRepository.save(sezione);
		return sezione;
	}

	@RequestMapping("/getProdottiByIdSezione")
	public List<Prodotto> getProdottiByIdSezione(@RequestBody String body) {
		System.out.println(body);
		Long id = Long.parseLong(body.split("=")[1]);
		Sezione sezione = sezioneRepository.findById(id).get();
		return sezione.getProdottoList();
	}

	@RequestMapping("/getSezioni")
	public List<Sezione> getSezioni() {
		return sezioneRepository.findAll();
	}
}
