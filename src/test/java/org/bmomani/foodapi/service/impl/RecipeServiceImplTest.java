package org.bmomani.foodapi.service.impl;

import org.bmomani.foodapi.dto.*;
import org.bmomani.foodapi.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(RecipeServiceImplTest.class);

    @Autowired
    RecipeService recipeService;

    @Test
    void testSearchRecipes() {
        ResponseEntity<RecipeSearchResponse> pizzaSearch = recipeService.searchRecipes("pizza");
        log.debug(pizzaSearch.toString());
        assertNotNull(pizzaSearch.getBody());

    }
    @Test
    void testSearchRecipes2() {
        ResponseEntity<RecipeSearchResponse> cuisineWiseSearch = recipeService.searchRecipes("", "Middle Eastern", null, 1, 10);
        log.debug(cuisineWiseSearch.toString());
        assertNotNull(cuisineWiseSearch.getBody());

    }

    @Test
    void testRecipeById() {
        RecipeInformation byId = recipeService.getRecipe(633518);
        log.debug(byId.toString());
        assertNotNull(byId);
    }

    @Test
    void getCaloriesForRecipe() {
        RecipeInformation recipeInformation = new RecipeInformation();
        recipeInformation.nutrition = new Nutrition();
        recipeInformation.nutrition.ingredients = new ArrayList<>();
        Ingredient egg = new Ingredient();
        egg.id = 1;
        egg.nutrients.add(new Nutrient("calories", 100, "kcal", 10));
        egg.nutrients.add(new Nutrient("sodium", 10, "gram", 6));
        egg.nutrients.add(new Nutrient("protein", 10, "gram", 6));
        Ingredient bacon = new Ingredient();
        bacon.id = 2;
        bacon.nutrients.add(new Nutrient("calories", 200, "kcal", 10));
        bacon.nutrients.add(new Nutrient("potassium", 10, "gram", 6));
        Ingredient mushroom = new Ingredient();
        mushroom.id = 3;
        mushroom.nutrients.add(new Nutrient("Zinc", 100, "gram", 10));
        mushroom.nutrients.add(new Nutrient("Calcium", 100, "gram", 10));

        recipeInformation.nutrition.ingredients.add(egg);
        recipeInformation.nutrition.ingredients.add(bacon);
        recipeInformation.nutrition.ingredients.add(mushroom);

        Double totalCalories = recipeService.getCaloriesForRecipe(recipeInformation, new int[]{});
        assertEquals(300, totalCalories);

        Double totalCalories2 = recipeService.getCaloriesForRecipe(recipeInformation, new int[]{2});
        assertEquals(100, totalCalories2);
    }
}
