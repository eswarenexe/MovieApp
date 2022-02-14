package com.example.movieapp.model.data;

import com.example.movieapp.model.response.MovieModel;

import java.util.List;

public class ParentModel {
    private String title;
    private List<MovieModel> movieModelList;

    public ParentModel(String title, List<MovieModel> movieModelList) {
        this.title = title;
        this.movieModelList = movieModelList;
    }

    public String getTitle() {
        return title;
    }

    public List<MovieModel> getMovieModelList() {
        return movieModelList;
    }
}
