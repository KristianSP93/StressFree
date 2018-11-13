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

import com.bumptech.glide.Glide;
import com.example.kristian.stressfree.R;


public class FullscreenPicActivity extends AppCompatActivity {

    private ImageView fullScreenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picfullscreen);

        //fullScreenImageView = findViewById(R.id.IVFullScreen);
        fullScreenImageView = findViewById(R.id.IVFullScreen);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2Fbeautiful_green_forest_background.png?alt=media&token=7e9e262b-6155-4e69-9964-a04ad35d0b1d")
                .into(fullScreenImageView);

        /*
        setContentView(R.layout.activity_picfullscreen);
        Intent callingActivityIntent = getIntent();
        if(callingActivityIntent != null){
            Uri imageUri = callingActivityIntent.getData();
            if(imageUri != null){
                Glide.with(this)
                        .load(imageUri)
                        .into(fullScreenImageView);
            }
        }

        */

    }
}


