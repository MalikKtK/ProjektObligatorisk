package com.example.madspild.service;

import com.example.madspild.model.Recipe;
import com.example.madspild.repository.RecipesRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeService {
    RecipesRepository recipesRepository;

    public RecipeService() {
        this.recipesRepository = new RecipesRepository();
    }

    public List<Recipe> getRecipesByFoodName(String foodName) {
        return recipesRepository.getRecipes(foodName);
    }

    public Recipe getRecipeByFoodName(String foodName) {
        return recipesRepository.getRecipe("chicken");
    }

    public int getSize() {
        return recipesRepository.getSize();
    }


}
