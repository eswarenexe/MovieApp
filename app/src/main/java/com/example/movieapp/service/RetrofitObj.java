package com.example.movieapp.service;

import com.example.movieapp.utility.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObj {
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(Credentials.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
