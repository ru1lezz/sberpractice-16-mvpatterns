package com.example.android.mvpatterns.movies.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("Search")
    private List<RemoteMovie> movieList;

    public List<RemoteMovie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<RemoteMovie> movieList) {
        this.movieList = movieList;
    }
}
