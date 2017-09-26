package com.example.sohailarshad.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class EditImageData extends AppCompatActivity {
    EditText name,location,email,rating,keyword;
    Switch share;
    DatePicker datePicker;
    Button btn;
    int position;
    ArrayList<String> dates, names, locations, keywords, emails;
    ArrayList<Integer> ratings;
    ArrayList<Boolean> shares;
    Preference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image_data);
        name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.location);
        email = (EditText) findViewById(R.id.email);
        rating = (EditText) findViewById(R.id.rating);
        keyword = (EditText) findViewById(R.id.keywords);
        datePicker = (DatePicker) findViewById(R.id.date);
        share = (Switch) findViewById(R.id.canShare);
        btn = (Button) findViewById(R.id.update);
        preference = new Preference(this);
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        ImageMetaData ci = i.getExtras().getParcelable("contact");
        if(ci !=null){
            if(ci.getName()!=null)
            name.setText(ci.getName()); // tv is a TextView instance
            if(ci.getLocation()!=null)
            location.setText(ci.getLocation()); // tv is a TextView instance
            if(ci.getDate()!=null)
            datePicker.updateDate(Integer.parseInt(ci.getDate().split("/")[2]),Integer.parseInt(ci.getDate().split("/")[1]),Integer.parseInt(ci.getDate().split("/")[0])); // tv is a TextView instance
            if(ci.getEmail()!=null)
            email.setText(ci.getEmail()); // tv is a TextView instance
            rating.setText(""+ci.getRating()); // tv is a TextView instance
            if(ci.getKeywords()!=null)
            keyword.setText(ci.getKeywords());
            // tv is a TextView instance
            share.setChecked(ci.isCanShare());
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageMetaData ci = new ImageMetaData();
                if(name.getText().toString()!=null)
                    ci.setName(name.getText().toString());
                if(location.getText().toString()!=null)
                    ci.setLocation(location.getText().toString());
                if(email.getText().toString()!=null)
                    ci.setEmail(email.getText().toString());
                if(keyword.getText().toString()!=null)
                    ci.setKeywords(keyword.getText().toString());
                ci.setCanShare(share.isChecked());
                if(rating.getText().toString()!=null)
                    ci.setRating(Integer.parseInt(rating.getText().toString()));
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                String date = day + "/" + month + "/" +year;
                ci.setDate(date);


                dates = preference.getDates();
                names = preference.getNames();
                locations = preference.getLocation();
                keywords = preference.getKeywords();
                emails= preference.getEmails();
                ratings= preference.getRating();
                shares = preference.getShare();

                dates.set(position,ci.getDate());
                names.set(position,ci.getName());
                locations.set(position,ci.getLocation());
                keywords.set(position,ci.getKeywords());
                emails.set(position,ci.getEmail());
                ratings.set(position,ci.getRating());
                shares.set(position,ci.isCanShare());

                preference.updateDates(dates);
                preference.updateNames(names);
                preference.updateLocations(locations);
                preference.updateKeywords(keywords);
                preference.updateEmails(emails);
                preference.updateRating(ratings);
                preference.updateShare(shares);

                finish();



            }
        });
    }
}
