package com.example.movieapp.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.model.response.MovieModel;
import com.example.movieapp.repository.MovieRepo;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepo repo = new MovieRepo();

    public MutableLiveData<List<MovieModel>> nowPLayingLiveData = new MutableLiveData<>();
    public MutableLiveData<List<MovieModel>> popularLiveData = new MutableLiveData<>();
    public MutableLiveData<List<MovieModel>> upcomingLiveData = new MutableLiveData<>();


    public LiveData<List<MovieModel>> getNowPlaying(Context context) {
        return repo.getNowPlaying(context);
    }

    public void getPopular(Context context) {
        popularLiveData.postValue(repo.getPopular(context));
    }

    public void getUpcoming(Context context) {
        upcomingLiveData.postValue(repo.getUpcoming(context));
    }

}
