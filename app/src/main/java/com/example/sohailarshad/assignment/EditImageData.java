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

public class EditImageData extends AppCompatActivity {
    EditText name,location,email,rating,keyword;
    Switch share;
    DatePicker datePicker;
    Button btn;
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
        btn = (Button) findViewById(R.id.update);
        Intent i = getIntent();
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
            rating.setText(ci.getRating()); // tv is a TextView instance
            if(ci.getKeywords()!=null)
            keyword.setText(ci.getKeywords()); // tv is a TextView instance
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
                datePicker.getDayOfMonth();
                datePicker.getMonth();
                datePicker.getYear();

            }
        });
    }
}
