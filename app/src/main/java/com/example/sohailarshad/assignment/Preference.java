package com.example.sohailarshad.assignment;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Random;


public class Preference {

    private static final String PREF_NAME = "Assignment 06";

    private static final String KEY_NAME = "names";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public Preference(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public int getNameCount(){
        return pref.getInt(KEY_NAME, 10);
    }

    public ArrayList<String> getNames(){
        ArrayList<String> name = new ArrayList<>();
        for(int i=0;i<getNameCount();i++){
            name.add(pref.getString("name"+i,"Book" + (i+1)));
        }

        return name;
    }

    public ArrayList<Integer> getRating(){
        ArrayList<Integer> rate = new ArrayList<>();

        for(int i=0;i<getNameCount();i++){
            Random rn = new Random();
            int maximum = 10;
            int minimum = 5;
            int randomNum;
            int n = maximum - minimum + 1;
            int k = rn.nextInt() % n;
            randomNum =  minimum + k;
            rate.add( pref.getInt("url"+i, randomNum));
        }

        return rate;
    }
}
