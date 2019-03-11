package com.example.android.mvpatterns.movie;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.android.mvpatterns.model.Movie;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

class MovieDetailsPresenter {
    private final Movie movie;
    private MovieDetailsView view;

    public MovieDetailsPresenter(Movie movie) {
        this.movie = movie;
    }

    void attachView(MovieDetailsView view) {
        this.view = view;
    }

    void detachView() {
        view = null;
    }

    void onResume() {
        view.setTitle(movie.getTitle());
        Picasso.get().load(movie.getUrl()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                view.setPoster(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }
}
