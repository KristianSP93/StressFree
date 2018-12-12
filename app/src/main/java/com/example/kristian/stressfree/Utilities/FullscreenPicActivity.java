package com.example.kristian.stressfree.Utilities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kristian.stressfree.R;


public class FullscreenPicActivity extends AppCompatActivity {

    private ImageView fullScreenImageView;
    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picfullscreen);

        fullScreenImageView = findViewById(R.id.IVFullScreen);
        Intent callingActivityIntent = getIntent();
        uri = callingActivityIntent.getStringExtra("picURI");

        showImage();
    }

    public void showImage(){
        try {
            Glide.with(this)
                    .load(uri)
                    .into(fullScreenImageView);
        } catch (Exception e) {
            Toast.makeText(this, R.string.Netværksfejl + ": " + e, Toast.LENGTH_LONG).show();
        }
    }


}


