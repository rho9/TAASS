package com.rud.rudmarket.controller;

import com.rud.rudmarket.exception.ResourceNotFoundException;
import com.rud.rudmarket.model.User;
import com.rud.rudmarket.model.Recipe;
import com.rud.rudmarket.model.form.RecipeForm;
import com.rud.rudmarket.repository.RecipeRepository;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RecipeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping("/recipe/addFromUser")
    @PreAuthorize("hasRole('USER')")
    public Recipe addRecipeFromCurrentUser(@CurrentUser UserPrincipal userPrincipal, @RequestBody RecipeForm recipeForm) {

        User currentUser = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Recipe newRecipe = new Recipe();
        newRecipe.setUser(currentUser);
        newRecipe.setTitle(recipeForm.getTitle());
        newRecipe.setSteps(recipeForm.getSteps());
        newRecipe.setDate(new Date());
        recipeRepository.save(newRecipe);
        return newRecipe;
    }
}
