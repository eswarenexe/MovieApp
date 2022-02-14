package com.example.movieapp.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.model.response.MovieModel;
import com.example.movieapp.model.response.MovieResponseModel;
import com.example.movieapp.service.Apis;
import com.example.movieapp.service.RetrofitObj;
import com.example.movieapp.utility.Credentials;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {

    Apis api = RetrofitObj.getRetrofit().create(Apis.class);

    public MutableLiveData<List<MovieModel>> getNowPlaying(Context context) {
        MutableLiveData<List<MovieModel>> nowPlayingList = new MutableLiveData<>();
        try {
            Response<MovieResponseModel> response = api.getNowPlayingMovie(Credentials.API_KEY, "en_US", 1);
            if (response.isSuccessful()) {
                List<MovieModel> results = response.body().getResults();
                    nowPlayingList.setValue(results);
            } else {
                Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e("asdfasdf", e.getLocalizedMessage());
        }
        Log.e("asdfasdaf", nowPlayingList.toString());
        return nowPlayingList;
    }

    public List<MovieModel> getPopular(Context context) {
        List<MovieModel> popularList = new ArrayList<>();

        Call<MovieResponseModel> call = api.getPopular(Credentials.API_KEY, "en_US", 1);
        call.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> results = response.body().getResults();
                    for (int i = 0; i < 10; i++) {
                        popularList.add(results.get(i));
                    }

                } else {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {
                Log.e("helloWorld", t.getLocalizedMessage().toString());
            }
        });
        return popularList;
    }

    public List<MovieModel> getUpcoming(Context context) {
        List<MovieModel> upComingList = new ArrayList<>();

        Call<MovieResponseModel> call = api.getUpcoming(Credentials.API_KEY, "en_US", 1);
        call.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> results = response.body().getResults();
                    for (int i = 0; i < 10; i++) {
                        upComingList.add(results.get(i));
                    }
                } else {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {
                Log.e("helloWorld", t.getLocalizedMessage().toString());
            }
        });
        return upComingList;
    }
}
