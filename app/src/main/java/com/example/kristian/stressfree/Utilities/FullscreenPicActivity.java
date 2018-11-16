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
    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picfullscreen);

        //fullScreenImageView = findViewById(R.id.IVFullScreen);
        fullScreenImageView = findViewById(R.id.IVFullScreen);
        Intent callingActivityIntent = getIntent();
        uri = callingActivityIntent.getStringExtra("picURI");

        /*
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2Fwatergreen.jpg?alt=media&token=18df1692-db9c-4d43-8334-ecc6f8dab04d")
                .into(fullScreenImageView);
         */



       Glide.with(this)
                .load(uri)
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


