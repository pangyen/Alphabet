package com.example.fatinnabila.alphabet.model;

/**
 * Created by fatin nabila on 11/7/2018.
 */

public class Items {
    String title;
    Integer image;

    // Setter for Gridview
    public Items(String title, Integer image) {
        this.title = title;
        this.image = image;
    }

    // Getter for Gridviews
    public String getTitle() {
        return title;
    }

    public Integer getImages() {
        return image;
    }
}