package com.example.android.mvpatterns.model;

import java.io.Serializable;
import java.util.Objects;

public class Movie implements Serializable {
    private String title;

    private String url;

    public Movie(String title, String url) {
        this.title = title;
        this.url = url;
    }

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
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(url, movie.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url);
    }
}
