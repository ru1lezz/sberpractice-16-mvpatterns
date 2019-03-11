package com.example.android.mvpatterns.movie;

import android.graphics.Bitmap;

public interface MovieDetailsView {
    void setTitle(String text);
    void setPoster(Bitmap bitmap);
}
