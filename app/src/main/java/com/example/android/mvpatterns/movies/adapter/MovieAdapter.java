package com.example.android.mvpatterns.movies.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.mvpatterns.R;
import com.example.android.mvpatterns.databinding.MovieListItemBinding;
import com.example.android.mvpatterns.model.Movie;
import com.example.android.mvpatterns.movie.MovieActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements MovieEventListener {

    private final Context mContext;
    private final List<Movie> mMovieList;

    public MovieAdapter(Context mContext) {
        this.mContext = mContext;
        this.mMovieList = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        mMovieList.clear();
        mMovieList.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MovieListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.movie_list_item, viewGroup, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie = mMovieList.get(i);
        movieViewHolder.getBinding().setMovie(movie);
        movieViewHolder.getBinding().setOnClickListener(this);
        Picasso.get().load(movie.getUrl()).into(movieViewHolder.getPoster());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    @Override
    public void openMovie(Movie movie) {
        mContext.startActivity(MovieActivity.newIntent(mContext, movie));
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding mBinding;
        private ImageView mPoster;

        public MovieViewHolder(MovieListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mPoster = mBinding.getRoot().findViewById(R.id.poster_image_view);
        }

        public MovieListItemBinding getBinding() {
            return mBinding;
        }

        public ImageView getPoster() {
            return mPoster;
        }
    }
}
