package com.example.rickandmortyapp;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "imageURL";
    public static final String EXTRA_NAME = "nameDetail";
    public static final String EXTRA_STATUS = "statusDetail";
    public static final String EXTRA_SPECIES = "speciesDetail";
    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_GENDER= "genderDetail";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.image_detail);
        String url = getIntent().getStringExtra(EXTRA_URL);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String status = getIntent().getStringExtra(EXTRA_STATUS);
        String species = getIntent().getStringExtra(EXTRA_SPECIES);
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        String gender = getIntent().getStringExtra(EXTRA_GENDER);

        Picasso.with(this).load(url).fit().centerInside().into(imageView);

        TextView textViewName = findViewById(R.id.text_name_detail);
        textViewName.setText("NAME: " + name);
        TextView textViewStatus = findViewById(R.id.text_status_detail);
        textViewStatus.setText("STATUS: "+ status);
        TextView textViewSpecies = findViewById(R.id.text_species_detail);
        textViewSpecies.setText("SPECIES: " + species);
        TextView textViewType = findViewById(R.id.text_type_detail);
        textViewType.setText("TYPE: " + type);
        TextView textViewGender = findViewById(R.id.text_gender_detail);
        textViewGender.setText("GENDER: "+gender);
    }

}
