package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.VideoPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.example.kristian.stressfree.Utilities.FullscreenVidActivity;
import com.example.kristian.stressfree.Utilities.ImageAdapter;

public class VideoActivity extends OptionsMenu implements VideoPresenter.Context {

    private VideoPresenter presenter;
    private Button btVidNature, btVidAnimal;
    private GridView gridView;
    private String[] natureList, animalList, natureThumbnail, animalThumbnail;
    private int flip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        presenter = new VideoPresenter(this);

        natureList = presenter.getNatureList();
        natureThumbnail = presenter.getNatureThumbnail();
        animalList = presenter.getAnimalList();
        animalThumbnail = presenter.getAnimalThumbnail();

        btVidAnimal = findViewById(R.id.btVidAnimals);
        btVidNature = findViewById(R.id.btVidNature);
        gridView = findViewById(R.id.gridViewVideos);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(VideoActivity.this, FullscreenVidActivity.class);
                if (flip == 1) {
                    fullScreenIntent.putExtra("picURI", natureList[i]);
                    startActivity(fullScreenIntent);
                } else if (flip == 2) {
                    fullScreenIntent.putExtra("picURI", animalList[i]);
                    startActivity(fullScreenIntent);
                } else {
                    Toast.makeText(VideoActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        btVidNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridView.setAdapter(new ImageAdapter(VideoActivity.this, natureThumbnail));
                flip = 1;
            }
        });

        btVidAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridView.setAdapter(new ImageAdapter(VideoActivity.this, animalThumbnail));
                flip = 2;
            }
        });

    }


    public void setAdapter(){
        if(flip == 1){
            gridView.setAdapter(new ImageAdapter(   VideoActivity.this, natureThumbnail));
        } else if (flip == 2){
            gridView.setAdapter(new ImageAdapter(   VideoActivity.this, animalThumbnail));
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
