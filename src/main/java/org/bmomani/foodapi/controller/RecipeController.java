package org.bmomani.foodapi.controller;

import org.bmomani.foodapi.dto.RecipeInformation;
import org.bmomani.foodapi.dto.RecipeSearchResponse;
import org.bmomani.foodapi.service.RecipeService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<RecipeSearchResponse> searchRecipes(
            @RequestParam String query,
            @DefaultValue( value = "Middle Eastern") String cuisine,
            @DefaultValue( value = "1") Integer page,
            @DefaultValue( value = "10") Integer size
    ) {
        return recipeService.searchRecipes(query, cuisine, null, page, size);
    }

    @GetMapping("/recipes/{recipeId}")
    public RecipeInformation getRecipe(@PathVariable int recipeId,
                                       @RequestParam int[] excludedIngredients) {
        return recipeService.getRecipe(recipeId, excludedIngredients);
    }

}