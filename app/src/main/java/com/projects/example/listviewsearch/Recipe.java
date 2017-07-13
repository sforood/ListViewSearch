package com.projects.example.listviewsearch;

import android.net.Uri;

/**
 * Created by savannahforood on 4/23/17.
 */

public class Recipe {
    Uri uri;
    String name;
    double stars;

    public Recipe (Uri uri, String name, double stars) {
        this.uri = uri;
        this.name = name;
        this.stars = stars;
    }

    public void setURI(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getStars() {
        return this.stars;
    }
}
