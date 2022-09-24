package com.example.madspild.repository;

import com.example.madspild.model.Recipe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RecipeRepository {

    private List<Recipe> recipes = new ArrayList<Recipe>();

    public RecipeRepository() {
        generateRecipes();
    }

    public void generateRecipes() {
        // add recipe obj from csv
        try {
            Scanner input = new Scanner(new File("src/main/resources/templates/recipe.csv"));
            input.useDelimiter(";");

            // skip header
            input.nextLine();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner token = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);

                //  Year;Length;Title;Subject;Popularity;Awards
                while (token.hasNext()) {
                    // get attributes
                    String foodType = token.next();
                    String title = token.next();
                    String body = token.next();

                    // add attributes
                    recipes.add(new Recipe(foodType, title, body));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Recipe getRecipe(String foodType) {
        Recipe returnRecipe = null;

        // find recipe with food
        for (Recipe recipe : recipes) {
            if (foodType.equalsIgnoreCase(recipe.getFoodType())) {
                returnRecipe = recipe;
                break;
            }
        }

        return returnRecipe;
    }

    public List<Recipe> getRecipes(String foodType) {
        List<Recipe> returnRecipes = new ArrayList<>();

        // find all recipes with food
        for (Recipe recipe : recipes) {
            if (foodType.equalsIgnoreCase(recipe.getFoodType())) {
                returnRecipes.add(recipe);
            }
        }

        return returnRecipes;
    }

    public int getSize() {
        return recipes.size();
    }
}
