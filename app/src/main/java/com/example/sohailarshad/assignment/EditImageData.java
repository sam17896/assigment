package com.example.sohailarshad.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditImageData extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image_data);
        textView = (TextView) findViewById(R.id.name);
        Intent i = getIntent();
        ImageMetaData ci = i.getExtras().getParcelable("contact");
        textView.setText(ci.toString()); // tv is a TextView instance
    }
}
