package com.example.madspild.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
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
}
