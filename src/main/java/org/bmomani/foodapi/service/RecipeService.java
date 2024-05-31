package org.bmomani.foodapi.service;

import org.bmomani.foodapi.dto.RecipeInformation;
import org.bmomani.foodapi.dto.RecipeSearchResponse;
import org.springframework.http.ResponseEntity;

public interface RecipeService {

    default ResponseEntity<RecipeSearchResponse> searchRecipes(String query) {
        return searchRecipes(query, null, null,1, 10);
    }
    ResponseEntity<RecipeSearchResponse> searchRecipes(String query, String cuisine, String type, int page, int size);

    RecipeInformation getRecipe(int recipeId);

    RecipeInformation getRecipe(int recipeId, int[] removeIngredients);

    Double getCaloriesForRecipe(RecipeInformation recipe, int[] execludeIngrediants);
}
