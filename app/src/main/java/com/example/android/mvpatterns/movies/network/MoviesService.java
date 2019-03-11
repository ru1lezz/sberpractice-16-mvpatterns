package com.example.android.mvpatterns.movies.network;

import com.example.android.mvpatterns.movies.network.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {
    @GET("?")
    Call<MoviesResponse> getMovie(@Query("apikey") String apiKey, @Query("s") String movieName);
}
