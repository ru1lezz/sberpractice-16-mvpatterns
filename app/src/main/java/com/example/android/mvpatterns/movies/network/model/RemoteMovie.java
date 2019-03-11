package com.example.android.mvpatterns.movies.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class RemoteMovie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Poster")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoteMovie movie = (RemoteMovie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(url, movie.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url);
    }
}
