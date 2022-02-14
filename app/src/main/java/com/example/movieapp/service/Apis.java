package com.example.movieapp.service;

import com.example.movieapp.model.response.MovieResponseModel;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {

    @GET("movie/now_playing")
    Call<MovieResponseModel> getNowPlayingMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
    @GET("movie/popular")
    Call<MovieResponseModel> getPopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
    @GET("movie/upcoming")
    Call<MovieResponseModel> getUpcoming(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
