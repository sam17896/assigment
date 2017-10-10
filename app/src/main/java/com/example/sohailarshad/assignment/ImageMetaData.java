package com.example.sohailarshad.assignment;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageMetaData implements Parcelable {

    private String name;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String location;
    private int rating;

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


    public String getLocation() {
        return location;
    }

    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rating);
    }

    // Creator
    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public ImageMetaData createFromParcel(Parcel in) {
            return new ImageMetaData(in);
        }

        public ImageMetaData[] newArray(int size) {
            return new ImageMetaData[size];
        }
    };

    // "De-parcel object
    public ImageMetaData(Parcel in) {
        name = in.readString();
        rating = in.readInt();
    }

    public ImageMetaData(){

    }
}
