package com.theo.lab2corect.DTO;

public class Category {
    String[] categories=new String[]{"Gaming", "Mechanics", "Cooking", "Sports"};

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
