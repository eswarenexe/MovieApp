package com.example.movieapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.adapter.ParentAdapter;
import com.example.movieapp.model.data.ParentModel;
import com.example.movieapp.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;


public class MovieListActivity extends AppCompatActivity {
    RecyclerView rcvParent;
    ParentAdapter parentAdapter;
    List<ParentModel> parentModelArrayList;
    MovieViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvParent = findViewById(R.id.rcvParent);
        parentModelArrayList = new ArrayList<>();
        mViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        observeGetNowPlaying();
        observePopular();
        observeUpcoming();
    }

    private void observeGetNowPlaying() {
        mViewModel.getNowPlaying(this).observe(this, movieModels -> {
            parentModelArrayList.add(new ParentModel("Now Playing", movieModels));
            parentAdapter = new ParentAdapter(parentModelArrayList, this);
            rcvParent.setAdapter(parentAdapter);
        });
    }

    private void observePopular() {
        mViewModel.getPopular(this).observe(this, movieModels -> {
            parentModelArrayList.add(new ParentModel("Popular", movieModels));
            parentAdapter = new ParentAdapter(parentModelArrayList, this);
            rcvParent.setAdapter(parentAdapter);
        });
    }

    private void observeUpcoming() {
        mViewModel.getUpcoming(this).observe(this, movieModels -> {
            parentModelArrayList.add(new ParentModel("Upcoming", movieModels));
            parentAdapter = new ParentAdapter(parentModelArrayList, this);
            rcvParent.setAdapter(parentAdapter);
        });
    }


}