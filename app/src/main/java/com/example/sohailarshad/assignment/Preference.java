package com.example.sohailarshad.assignment;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Sohail Arshad on 9/26/2017.
 */

public class Preference {

    private static final String PREF_NAME = "Assignment 4";

    private static final String KEY_NAME = "names";
    private static final String KEY_KEYWORD = "keywords";
    private static final String KEY_EMAIL = "emails";
    private static final String KEY_DATES = "dates";
    private static final String KEY_RATINGS = "rating";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_SHARE = "share";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public Preference(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void updateNames(ArrayList<String> names){
        for(int i=0;i<names.size();i++){
            editor.putString("name"+i,names.get(i));
        }
        setNameCount(names.size());
        editor.commit();
    }

    public void setNameCount(int i){
        editor.putInt(KEY_NAME,i);
        editor.commit();
    }

    public int getNameCount(){
        return pref.getInt(KEY_NAME,4);
    }

    public ArrayList<String> getNames(){
        ArrayList<String> name = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            name.add(pref.getString("name"+i,"Image" + i));
        }

        return name;
    }

    public void updateDates(ArrayList<String> dates){
        for(int i=0;i<dates.size();i++){
            editor.putString("date"+i,dates.get(i));
        }
        setNameCount(dates.size());
        editor.commit();
    }


    public ArrayList<String> getDates(){
        ArrayList<String> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add(pref.getString("date"+i,"0"+i+"/8/2017"));
        }

        return date;
    }

    public void updateRating(ArrayList<Integer> url){
        for(int i=0;i<url.size();i++){
            editor.putInt("url"+i,url.get(i));
        }
        setNameCount(url.size());
        editor.commit();
    }


    public ArrayList<Integer> getRating(){
        ArrayList<Integer> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add( pref.getInt("url"+i,0));
        }

        return date;
    }

    public void updateLocations(ArrayList<String> url){
        for(int i=0;i<url.size();i++){
            editor.putString("location"+i,url.get(i));
        }
        setNameCount(url.size());
        editor.commit();
    }


    public ArrayList<String> getLocation(){
        ArrayList<String> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add( pref.getString("location"+i,"http://via.placeholder.com/150x150"));
        }

        return date;
    }

    public void updateKeywords(ArrayList<String> url){
        for(int i=0;i<url.size();i++){
            editor.putString("keywords"+i,url.get(i));
        }
        setNameCount(url.size());
        editor.commit();
    }


    public ArrayList<String> getKeywords(){
        ArrayList<String> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add( pref.getString("keywords"+i," "));
        }

        return date;
    }

    public void updateEmails(ArrayList<String> url){
        for(int i=0;i<url.size();i++){
            editor.putString("emails"+i,url.get(i));
        }
        setNameCount(url.size());
        editor.commit();
    }


    public ArrayList<String> getEmails(){
        ArrayList<String> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add(pref.getString("emails"+i," "));
        }

        return date;
    }

    public void updateShare(ArrayList<Boolean> url){
        for(int i=0;i<url.size();i++){
            editor.putBoolean("share"+i,url.get(i));
        }
        setNameCount(url.size());
        editor.commit();
    }


    public ArrayList<Boolean> getShare(){
        ArrayList<Boolean> date = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            date.add( pref.getBoolean("share"+i,false));
        }

        return date;
    }




}
