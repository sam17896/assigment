package com.example.sohailarshad.assignment;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {

    private String name;
    private String url;
    private int rating;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public Book(){

    }
}
