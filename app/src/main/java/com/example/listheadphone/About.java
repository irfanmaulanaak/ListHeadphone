package com.example.listheadphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class About extends AppCompatActivity {
    public static final String foto = "https://bit.ly/2OO7hWz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Glide.with(this).load(foto).into((ImageView) findViewById(R.id.foto_about));
    }
}
