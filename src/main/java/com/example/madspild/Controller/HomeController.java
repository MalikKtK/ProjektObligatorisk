package com.example.madspild.Controller;

import com.example.madspild.model.Recipe;
import com.example.madspild.service.RecipeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private RecipeService recipeService;

    public HomeController() {
        this.recipeService = new RecipeService();
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/about")
    public String about() {
        return "home/about";
    }

    @GetMapping("/read/foodwaste")
    public String foodWaste() {
        return "read/foodwaste";
    }

    @GetMapping("/read/foodrecipes")
    public String foodRecipes(Model model, @RequestParam String foodType) {
        List<Recipe> recipes = recipeService.getRecipesByFoodName(foodType);

        if (foodType.isBlank())
            recipes.add(new Recipe("", "Look for recipes of food you don't want to waste 2", "examples: chicken, onion, my name jeff"));
        else if (recipes.size() == 0)
            recipes.add(new Recipe("", "Look for recipes of food you don't want to waste 1", String.format("'%s' WAS NOT FOUND", foodType)));

        model.addAttribute("recipes", recipes);
        return "Read/FoodRecipes";
    }

}
