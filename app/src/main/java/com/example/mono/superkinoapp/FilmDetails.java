package com.example.mono.superkinoapp;

/**
 * Created by tfqo on 18.06.2017.
 */
public class FilmDetails {
    private String title;
    private String genre;
    private int imageNumber;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) { this.imageNumber = imageNumber; }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description;}
}
