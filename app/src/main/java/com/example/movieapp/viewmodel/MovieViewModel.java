package com.example.movieapp.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.model.response.MovieModel;
import com.example.movieapp.repository.MovieRepo;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepo repo = new MovieRepo();


    public LiveData<List<MovieModel>> getNowPlaying(Context context) {
        return repo.getNowPlaying(context);
    }
    //then return livedata directly from the viewmodel

    public LiveData<List<MovieModel>> getPopular(Context context) {
        return repo.getPopular(context);
    }

    public LiveData<List<MovieModel>> getUpcoming(Context context) {
        return repo.getUpcoming(context);
    }

}
