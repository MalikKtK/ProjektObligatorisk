package com.example.madspild.model;

public class Recipe {
    String foodType;
    String textBody;

    public Recipe(String foodType, String textBody) {
        this.foodType = foodType;
        this.textBody = textBody;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }
}
