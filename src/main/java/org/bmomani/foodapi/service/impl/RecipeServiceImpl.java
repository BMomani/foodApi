package org.bmomani.foodapi.service.impl;

import org.bmomani.foodapi.dto.Nutrient;
import org.bmomani.foodapi.dto.RecipeInformation;
import org.bmomani.foodapi.dto.RecipeSearchResponse;
import org.bmomani.foodapi.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RestTemplate restTemplate;

    public RecipeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<RecipeSearchResponse> searchRecipes(String query, String cuisine, String type, int page, int size) {
        String url = "/recipes/search?query=%s&offset=%d&number=%d".formatted(
                query,
                (page - 1) * size,
                size);
        if (cuisine != null) {
            url = url + "&cuisine=%s".formatted(cuisine);
        }
        if (type != null) {
            url = url + "&type=%s".formatted(type);
        }

        return restTemplate
                .getForEntity(url, RecipeSearchResponse.class);
    }

    @Override
    public RecipeInformation getRecipe(int recipeId) {
        return getRecipe(recipeId, new int[]{});
    }

    @Override
    public RecipeInformation getRecipe(int recipeId, int[] removeIngredients) {
        RecipeInformation recipe = this.restTemplate
                .getForEntity("/recipes/{recipeId}/information?includeNutrition=true", RecipeInformation.class, recipeId)
                .getBody();


        recipe.totalCalories = getCaloriesForRecipe(recipe, removeIngredients);
        return recipe;
    }

    @Override
    public Double getCaloriesForRecipe(RecipeInformation recipe, int[] execludeIngrediants) {
        Set<Integer> execludedIds = Arrays.stream(execludeIngrediants).boxed().collect(Collectors.toSet()); // convert array to set
        return recipe.nutrition.ingredients.stream()
                .filter(ingredient -> !execludedIds.contains(ingredient.id))
                .flatMap(ingredient -> ingredient.nutrients.stream()
                        .filter(nutrient -> nutrient.name().toLowerCase().equals("calories"))
                        .map(Nutrient::amount))
                .reduce(0D, Double::sum);
    }
}