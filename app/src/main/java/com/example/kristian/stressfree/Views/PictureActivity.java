package com.example.kristian.stressfree.Views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kristian.stressfree.Presenters.MainPresenter;
import com.example.kristian.stressfree.Presenters.PicturePresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.example.kristian.stressfree.Utilities.FullscreenVidActivity;
import com.example.kristian.stressfree.Utilities.Globals;
import com.example.kristian.stressfree.Utilities.ImageAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class PictureActivity extends OptionsMenu implements PicturePresenter.Context{

    private GridView gridview;
    private PicturePresenter presenter;
    private Button btAnimals, btNature;
    private String[] mNatureUris, mAnimalUris;
    private int flip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        presenter = new PicturePresenter(this);

        mAnimalUris = presenter.getAnimalURIarray();
        mNatureUris = presenter.getNatureURIarray();

        // Initialising widgets
        gridview = findViewById(R.id.gridViewPictures);
        btAnimals = findViewById(R.id.btPicAnimals);
        btNature = findViewById(R.id.btPicNature);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(PictureActivity.this, FullscreenPicActivity.class);
                if(flip == 1){
                    fullScreenIntent.putExtra("picURI", mAnimalUris[i]);
                    startActivity(fullScreenIntent);
                } else if (flip == 2){
                    fullScreenIntent.putExtra("picURI", mNatureUris[i]);
                    startActivity(fullScreenIntent);
                } else {
                Toast.makeText(PictureActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        btAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridview.setAdapter(new ImageAdapter(   PictureActivity.this, mAnimalUris));
                flip = 1;
            }
        });

        btNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridview.setAdapter(new ImageAdapter(   PictureActivity.this, mNatureUris));
                flip = 2;
            }
        });
    }


}
