package com.example.android.mvpatterns.movies;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.android.mvpatterns.model.Movie;
import com.example.android.mvpatterns.movies.network.ApiMapper;
import com.example.android.mvpatterns.movies.network.RetrofitHelper;
import com.example.android.mvpatterns.movies.network.model.MoviesResponse;
import com.example.android.mvpatterns.movies.network.model.RemoteMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {
    private final ApiMapper mapper;
    private MutableLiveData<List<Movie>> mutableLiveData;


    public MoviesViewModel() {
        super();
        mapper = new ApiMapper(new RetrofitHelper());
    }

    LiveData<List<Movie>> getMovies() {
        if(mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            getMoviesFromModel();
        }
        return mutableLiveData;
    }

    private void getMoviesFromModel() {
        mapper.getMovieAsync("Avengers", new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                final List<Movie> movieList = new ArrayList<>();
                MoviesResponse moviesResponse = response.body();
                List<RemoteMovie> tempList = moviesResponse.getMovieList();
                for(RemoteMovie remoteMovie : tempList) {
                    movieList.add(new Movie(remoteMovie.getTitle(), remoteMovie.getUrl()));
                }
                mutableLiveData.setValue(movieList);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(getClass().getName(), t.getMessage());
            }
        });
    }
}
