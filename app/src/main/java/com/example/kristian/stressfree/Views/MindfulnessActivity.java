package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.MindfulnessPresenter;
import com.example.kristian.stressfree.Presenters.VideoPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenVidActivity;
import com.example.kristian.stressfree.Utilities.ImageAdapter;

public class MindfulnessActivity extends OptionsMenu {

    private MindfulnessPresenter presenter;
    private GridView gridView;
    private String[] mindfulnessList, mindfulnessThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);
        presenter = new MindfulnessPresenter(this);

        mindfulnessList = presenter.getMindfullList();
        mindfulnessThumbnail = presenter.getMindfullThumbnail();

        gridView = findViewById(R.id.gridViewVideos);
        gridView.setAdapter(new ImageAdapter(MindfulnessActivity.this, mindfulnessThumbnail));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(MindfulnessActivity.this, FullscreenVidActivity.class);
                    fullScreenIntent.putExtra("picURI", mindfulnessList[i]);
                    startActivity(fullScreenIntent);
            }
        });
    }




}
