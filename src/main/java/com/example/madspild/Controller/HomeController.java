package com.example.madspild.Controller;

import com.example.madspild.model.Recipe;
import com.example.madspild.service.RecipeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
        Recipe recipe = recipeService.getRecipeByFoodName("chicken");
        int recipe2 = recipeService.getSize();

        model.addAttribute("recipe", recipe2);
        return "Read/FoodRecipies";
    }

}
