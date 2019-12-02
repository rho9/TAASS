package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.form.ProdottoForm;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdottoController {

    /*@Autowired
    private UserRepository userRepository;*/
    @Autowired
    private ProdottoRepository prodottoRepository;

    @PostMapping("/prodotto/addProdotto")
    //@PreAuthorize("hasRole('USER')")
    public Prodotto addProdotto(@CurrentUser UserPrincipal userPrincipal, @RequestBody ProdottoForm prodottoForm) {

        /* User currentUser = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Recipe newRecipe = new Recipe();
        newRecipe.setUser(currentUser);
        newRecipe.setTitle(recipeForm.getTitle());
        newRecipe.setSteps(recipeForm.getSteps());
        newRecipe.setDate(new Date());
        prodottoRepository.save(newRecipe);
        return newRecipe;*/

        Prodotto prodotto = new Prodotto();
        prodotto.setNome(prodottoForm.getNome());
        prodotto.setMarca(prodottoForm.getMarca());
        prodottoRepository.save(prodotto);
        return prodotto;
    }
}
