package com.example.movieapp.model.response;

import java.util.List;

public class MovieResponseModel {
    List<MovieModel> results;

    public MovieResponseModel(List<MovieModel> results) {
        this.results = results;
    }

    public List<MovieModel> getResults() {
        return results;
    }
}
