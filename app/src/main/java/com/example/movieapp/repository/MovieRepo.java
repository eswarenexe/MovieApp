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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {

    Apis api = RetrofitObj.getRetrofit().create(Apis.class);

    public MutableLiveData<List<MovieModel>> getNowPlaying(Context context) {
        final MutableLiveData<List<MovieModel>> nowPlayingList = new MutableLiveData<>();
        Call<MovieResponseModel> response = api.getNowPlayingMovie(Credentials.API_KEY, "en_US", 1);

        response.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> results = response.body().getResults();
                    nowPlayingList.setValue(results);
                } else {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {
                Log.e("helloWorld", t.getLocalizedMessage().toString());
            }
        });

        Log.e("helloWorld", nowPlayingList.getValue() + "");

        return nowPlayingList;
    }
//have to use setvalue instead of postvalue for setting the livedata.
    public MutableLiveData<List<MovieModel>> getPopular(Context context) {
        final MutableLiveData<List<MovieModel>> popularList = new MutableLiveData<>();

        Call<MovieResponseModel> call = api.getPopular(Credentials.API_KEY, "en_US", 1);
        call.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> results = response.body().getResults();
                    popularList.setValue(results);
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

    public MutableLiveData<List<MovieModel>> getUpcoming(Context context) {
        final MutableLiveData<List<MovieModel>> upComingList = new MutableLiveData<>();

        Call<MovieResponseModel> call = api.getUpcoming(Credentials.API_KEY, "en_US", 1);
        call.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> results = response.body().getResults();
                    upComingList.setValue(results);
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
