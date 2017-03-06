package com.weeaisin.android.icecreamrecipe;

/**
 * Created by AiLeng on 26-Feb-17.
 */

public class Recipe {
    private int id;
    private String title;
    private String description;
    private int image;

    public Recipe() {}

    public Recipe(int image, String title, String description) {
        super();
        this.image = image;
        this.title = title;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
