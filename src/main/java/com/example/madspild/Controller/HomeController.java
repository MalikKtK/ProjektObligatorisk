package com.example.madspild.Controller;

import com.example.madspild.model.Recipe;
import com.example.madspild.service.RecipeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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

    @GetMapping("/read/foodwaste")
    public String FoodWaste() {
        return "read/foodwaste";
    }

    @GetMapping("/game/foodwastegame")
    public String FoodWasteGame() {
        return "game/foodwastegame";
    }

    @GetMapping("/read/foodrecipes")
    public String FoodRecipes(Model model) {
        Recipe recipes = recipeService.getRecipeByFoodName("chicken");
        List<Recipe> recipes1 = recipeService.getRecipesByFoodName("chicken");

        model.addAttribute("recipes", recipes1);
        return "Read/FoodRecipes";
    }

}
