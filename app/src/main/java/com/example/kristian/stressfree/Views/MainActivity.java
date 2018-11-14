package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kristian.stressfree.Models.User;
import com.example.kristian.stressfree.R;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private Button btpic, btvid, btmind, btsound, btstressfree, btmovement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user;

        if (savedInstanceState != null) {
            // Get user  and save it. Not saved yet
            savedInstanceState.getSerializable("userLogIn");
        }

        btpic = findViewById(R.id.btnPictures);
        btvid =  findViewById(R.id.btnVideos);
        btmind = findViewById(R.id.btnMindfulness);
        btsound =  findViewById(R.id.btnSound);
        btstressfree = findViewById(R.id.btnMyStressFree);
        btmovement = findViewById(R.id.btnMovement);

        btpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                startActivity(intent);
            }
        });

        btsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SoundActivity.class);
                startActivity(intent);
            }
        });

        btvid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        btmind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MindfulnessActivity.class);
                startActivity(intent);
            }
        });

        btmovement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MovementActivity.class);
                startActivity(intent);
            }
        });

        btstressfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyStressFreeActivity.class);
                startActivity(intent);
            }
        });


    }

    // creating action bar using menu from res
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // open settings from this activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.btSettings) {
            Intent intent =  new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        if (id == R.id.btLogoff) {
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return false;
    }








}
