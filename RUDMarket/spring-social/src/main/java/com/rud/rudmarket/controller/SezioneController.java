package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.SezioneForm;
import com.rud.rudmarket.repository.SezioneRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sezione")
public class SezioneController {

	@Autowired
	SezioneRepository sezioneRepository;

	@PostMapping("/addSezione")
	//@PreAuthorize("hasRole('ADMIN')")
	public Sezione addSezione(@CurrentUser UserPrincipal userPrincipal, @RequestBody SezioneForm sezioneForm) {
		Sezione sezione = new Sezione();
		sezione.setNome(sezioneForm.getNome());
		sezioneRepository.save(sezione);
		return sezione;
	}

	@RequestMapping("/getSezioni")
	public List<Sezione> getSezioni() {
		return sezioneRepository.findAll();
	}
}
