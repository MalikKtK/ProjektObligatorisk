package com.example.madspild.repository;

import com.example.madspild.model.Recipe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RecipesRepository {

    private List<Recipe> recipes = new ArrayList<Recipe>();

    public void generateMoviesList() {
        // add recipe obj from csv
        try {
            Scanner input = new Scanner(new File("C:\\Users\\danie\\OneDrive\\KEA\\IdeaProjects\\ProjektObligatorisk\\src\\main\\resources\\templates\\recipe.csv"));
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
                    String textBody = token.next();

                    // add attributes
                    recipes.add(new Recipe(foodType, textBody));
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
            if (foodType.equals(recipe.getTextBody())) {
                returnRecipe = recipe;
                break;
            }
        }

        return returnRecipe;
    }

    public int getSize() {
        return recipes.size();
    }
}
