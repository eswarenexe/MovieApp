package com.example.movieapp.model.response;

public class MovieModel {
    private int id;
    private String original_title;
    private String poster_path;

    public MovieModel(int id, String original_title, String poster_path) {
        this.id = id;
        this.original_title = original_title;
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }
}
