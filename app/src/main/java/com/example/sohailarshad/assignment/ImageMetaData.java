package com.example.sohailarshad.assignment;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sohail Arshad on 9/26/2017.
 */

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
    private String keywords;
    private String date;
    private boolean canShare;
    private String email;
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(location);
        dest.writeString(email);
        dest.writeString(keywords);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dest.writeString(dateFormat.format(new Date()));
        dest.writeByte((byte)(canShare ? 1 : 0));
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
        url = in.readString();
        location = in.readString();
        email = in.readString();
        keywords = in.readString();
        date = in.readString();
        canShare = in.readByte() != 0;
        rating = in.readInt();
    }

    public ImageMetaData(){

    }
}
