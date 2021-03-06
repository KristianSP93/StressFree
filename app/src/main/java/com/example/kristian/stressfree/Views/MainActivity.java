package com.example.kristian.stressfree.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.MainPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.Globals;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements MainPresenter.Context {

    private Button btpic, btvid, btmind, btsound, btstressfree, btmovement;
    static boolean active = false;
    private MainPresenter presenter;
    private Globals g;

    @Override
    public void onBackPressed() {
        // If the user is logged in will show a dialog box with Yes/No and the user can choose to log out
        if (presenter.IsUserLoggedIn()) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            presenter.LogOut();
                            finish();
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.LogafTekst).setPositiveButton(R.string.Ja, dialogClickListener)
                    .setNegativeButton(R.string.Nej, dialogClickListener).show();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        active = true;
    }


    @Override
    protected void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = new Globals(this);

        if (savedInstanceState != null) {
            // Get user  and save it. Not saved yet
            savedInstanceState.getSerializable("userLogIn");
        }

        // Initialising widgets
        btpic = findViewById(R.id.btnPictures);
        btvid = findViewById(R.id.btnVideos);
        btmind = findViewById(R.id.btnMindfulness);
        btsound = findViewById(R.id.btnSound);
        btstressfree = findViewById(R.id.btnMyStressFree);
        btmovement = findViewById(R.id.btnMovement);
        presenter = new MainPresenter(this);

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
                if(g.IsUserLoggedIn()){
                    Intent intent = new Intent(MainActivity.this, MyStressFreeActivity.class);
                    startActivity(intent);
                } else{
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    break;
                            }
                        }
                    };
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(R.string.BrugerLoggetind).setPositiveButton(R.string.Ok, dialogClickListener);
                    builder.show();
                }

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

        if(g.IsUserLoggedIn()){
            int id = item.getItemId();

            if (id == R.id.btSettings) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);

            }
            if (id == R.id.btLogoff) {
                if(g.IsUserLoggedIn()){
                    g.LogOut();

                }
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            return false;
        } else{
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            break;
                    }
                }
            };
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
            builder.setMessage(R.string.BrugerLoggetind).setPositiveButton(R.string.Ok, dialogClickListener);
            builder.show();
            return false;
        }


    }
}
