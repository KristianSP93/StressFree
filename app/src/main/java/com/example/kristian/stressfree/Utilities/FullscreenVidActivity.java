package com.example.kristian.stressfree.Utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.kristian.stressfree.R;

public class FullscreenVidActivity extends AppCompatActivity {

    private String stringUri;
    private VideoView videoView;
    private MediaController mediaController;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidfullscreen);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);

        Intent callingActivityIntent = getIntent();
        stringUri = callingActivityIntent.getStringExtra("picURI");

        playVideo();
    }

    public void playVideo() {
        Uri uri = Uri.parse(stringUri);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        progDailog = ProgressDialog.show(this, getResources().getString(R.string.VentVenligst), getResources().getString(R.string.HenterData), true);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                progDailog.dismiss();
                videoView.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
