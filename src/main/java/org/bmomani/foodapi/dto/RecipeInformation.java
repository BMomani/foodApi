package org.bmomani.foodapi.dto;

import java.util.ArrayList;

public class RecipeInformation{
    public int id;
    public String title;
    public String image;
    public String imageType;
    public int servings;
    public int readyInMinutes;
    public String license;
    public String sourceName;
    public String sourceUrl;
    public String spoonacularSourceUrl;
    public double healthScore;
    public double spoonacularScore;
    public double pricePerServing;
    public ArrayList<Object> analyzedInstructions;
    public boolean cheap;
    public String creditsText;
    public ArrayList<Object> cuisines;
    public boolean dairyFree;
    public ArrayList<Object> diets;
    public String gaps;
    public boolean glutenFree;
    public String instructions;
    public boolean ketogenic;
    public boolean lowFodmap;
    public ArrayList<Object> occasions;
    public boolean sustainable;
    public boolean vegan;
    public boolean vegetarian;
    public boolean veryHealthy;
    public boolean veryPopular;
    public boolean whole30;
    public int weightWatcherSmartPoints;
    public ArrayList<String> dishTypes;
    public ArrayList<Object> extendedIngredients;
    public String summary;
    public Object winePairing;
    public Nutrition nutrition;
    public Double totalCalories;
}

//public class Nutrition {
//    public ArrayList<Nutrient> nutrients;
////    public ArrayList<Property> properties;
////    public ArrayList<Flavonoid> flavonoids;
//    public ArrayList<Ingredient> ingredients;
////    public CaloricBreakdown caloricBreakdown;
////    public WeightPerServing weightPerServing;
//}

