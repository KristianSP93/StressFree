package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.SoundPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenVidActivity;
import com.example.kristian.stressfree.Utilities.ImageAdapter;

public class    SoundActivity extends OptionsMenu  {
    private SoundPresenter presenter;
    private GridView gridView;
    private String[] natureList, natureThumbnail, musicList, musicThumbnail;
    private Button btMusic, btNature;

    private int flip = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        presenter = new SoundPresenter(this);

        natureList = presenter.getNatureList();
        natureThumbnail = presenter.getNatureThumbnail();
        musicList = presenter.getMusicList();
        musicThumbnail = presenter.getMusicThumbnail();

        //Initialising
        btMusic = findViewById(R.id.btMusic);
        btNature = findViewById(R.id.btNature);
        gridView = findViewById(R.id.gridViewSound);

        btNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridView.setAdapter(new ImageAdapter(SoundActivity.this, natureThumbnail));
                flip = 1;
            }
        });

        btMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridView.setAdapter(new ImageAdapter(SoundActivity.this, musicThumbnail));
                flip = 2;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(SoundActivity.this, FullscreenVidActivity.class);
                if (flip == 1) {
                    fullScreenIntent.putExtra("picURI", natureList[i]);
                    startActivity(fullScreenIntent);
                } else if (flip == 2) {
                    fullScreenIntent.putExtra("picURI", musicList[i]);
                    startActivity(fullScreenIntent);
                } else {
                    Toast.makeText(SoundActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void setAdapter(){
        if(flip == 1){
            gridView.setAdapter(new ImageAdapter(   SoundActivity.this, natureList));
        } else if (flip == 2){
            gridView.setAdapter(new ImageAdapter(   SoundActivity.this, musicList));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("FlipValue", flip);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        flip = savedInstanceState.getInt("FlipValue", flip);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setAdapter();
    }

}
