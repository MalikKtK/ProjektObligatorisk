package com.example.madspild.model;

public class Recipe {
    String foodType;
    String title;
    String body;

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Recipe(String foodType, String title, String body) {
        this.foodType = foodType;
        this.title = title;
        this.body = body;
    }

}
