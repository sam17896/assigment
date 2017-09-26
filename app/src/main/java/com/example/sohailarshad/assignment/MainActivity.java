package com.example.sohailarshad.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageMetaData> imageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageAdapter mAdapter;
    private Preference preference;
    ArrayList<String> dates, names, location, keywords, emails;
    ArrayList<Integer> ratings;
    ArrayList<Boolean> share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preference = new Preference(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        int count = preference.getNameCount();

        dates = preference.getDates();
        names = preference.getNames();
        location = preference.getLocation();
        keywords = preference.getKeywords();
        emails= preference.getEmails();
        ratings= preference.getRating();
        share = preference.getShare();

        for(int i=0;i<count;i++){
            ImageMetaData imageMetaData = new ImageMetaData();
            imageMetaData.setDate(dates.get(i));
            imageMetaData.setName(names.get(i));
            imageList.add(imageMetaData);
        }

        mAdapter = new ImageAdapter(imageList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent =  new Intent(MainActivity.this, EditImageData.class);
                        ImageMetaData ci = new ImageMetaData();
                        ci.setName(names.get(position));
                        ci.setDate(dates.get(position));
                        ci.setCanShare(share.get(position));
                        ci.setEmail(emails.get(position));
                        ci.setLocation(location.get(position));
                        ci.setRating(ratings.get(position));
                        ci.setKeywords(keywords.get(position));
                        intent.putExtra("contact", ci);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        recyclerView.setAdapter(mAdapter);

    }
}
