package com.example.android.mvpatterns.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mvpatterns.R;
import com.example.android.mvpatterns.model.Movie;

public class MovieActivity extends AppCompatActivity implements MovieDetailsView{

    private static final String EXTRA_MOVIE = "extra_movie";

    private MovieDetailsPresenter mPresenter;

    private TextView mTitleTextView;
    private ImageView mPosterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initViews();

        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);
        if(movie != null) {
            mPresenter = new MovieDetailsPresenter(movie);
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void initViews() {
        mTitleTextView = findViewById(R.id.title_activity_movie);
        mPosterImageView = findViewById(R.id.poster_image_view_activity_movie);
    }

    public static final Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    public void setTitle(String text) {
        mTitleTextView.setText(text);
    }

    @Override
    public void setPoster(Bitmap bitmap) {
        mPosterImageView.setImageBitmap(bitmap);
    }
}
