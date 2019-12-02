package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.SezioneForm;
import com.rud.rudmarket.repository.SezioneRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sezione")
public class SezioneController {

	@Autowired
	SezioneRepository sezioneRepository;

	@PostMapping("/addSezione")
	//@PreAuthorize("hasRole('ADMIN')")
	public Sezione addSezione(@CurrentUser UserPrincipal userPrincipal, @RequestBody SezioneForm sezioneForm) {

        /* User currentUser = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Recipe newRecipe = new Recipe();
        newRecipe.setUser(currentUser);
        newRecipe.setTitle(recipeForm.getTitle());
        newRecipe.setSteps(recipeForm.getSteps());
        newRecipe.setDate(new Date());
        prodottoRepository.save(newRecipe);
        return newRecipe;*/

		Sezione sezione = new Sezione();
		sezione.setNome(sezioneForm.getNome());
		sezioneRepository.save(sezione);
		return sezione;
	}
}
