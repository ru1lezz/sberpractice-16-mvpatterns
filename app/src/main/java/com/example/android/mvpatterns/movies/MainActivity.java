package com.example.android.mvpatterns.movies;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.android.mvpatterns.R;
import com.example.android.mvpatterns.databinding.ActivityMainBinding;
import com.example.android.mvpatterns.model.Movie;
import com.example.android.mvpatterns.movies.adapter.MovieAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new MovieAdapter(this);
        binding.recyclerView.setAdapter(mAdapter);

        MoviesViewModel viewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                mAdapter.setMovies(movies);
            }
        });


    }
}
