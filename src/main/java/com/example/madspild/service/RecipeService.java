package com.example.madspild.service;

import com.example.madspild.model.Recipe;
import com.example.madspild.repository.RecipeRepository;

import java.util.List;

public class RecipeService {
    RecipeRepository recipeRepository;

    public RecipeService() {
        this.recipeRepository = new RecipeRepository();
    }

    public List<Recipe> getRecipesByFoodName(String foodName) {
        return recipeRepository.getRecipes(foodName);
    }

    public Recipe getRecipeByFoodName(String foodName) {
        return recipeRepository.getRecipe("chicken");
    }

    public int getSize() {
        return recipeRepository.getSize();
    }


}
