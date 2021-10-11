package com.theo.lab2corect.DTOs;

public class Category {
    String[] categories=new String[]{"Gardening", "Mechanics", "Cooking", "Sports"};

    public Category() {

    }

    public Category(String[] categories) {
        this.categories = categories;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
