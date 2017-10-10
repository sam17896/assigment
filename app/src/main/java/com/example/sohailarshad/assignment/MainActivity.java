package com.example.sohailarshad.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageMetaData> imageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageAdapter mAdapter;
    private Preference preference;
    ArrayList<String> names;
    ArrayList<Integer> ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preference = new Preference(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        int count = preference.getNameCount();
        names = preference.getNames();
        ratings = preference.getRating();

        for(int i=0;i<count;i++){
            ImageMetaData ci = new ImageMetaData();
            ci.setName(names.get(i));
            ci.setRating(ratings.get(i));
            imageList.add(ci);
        }

        mAdapter = new ImageAdapter(imageList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);
    }

}
