package com.example.listheadphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_INFO = "extra_info";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PHOTO = "extra_photo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvNamaReceived = findViewById(R.id.tv_item_nama);
        TextView tvInfoReceived = findViewById(R.id.tv_item_info);
        ImageView imgPhotoReceived = findViewById(R.id.img_item_photo);

        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String info = getIntent().getStringExtra(EXTRA_INFO);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);

        tvNamaReceived.setText(nama);
        tvInfoReceived.setText(info);
        Glide.with(this).load(photo).into(imgPhotoReceived);


    }
}
