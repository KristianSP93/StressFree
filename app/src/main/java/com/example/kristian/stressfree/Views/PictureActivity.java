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

import com.example.kristian.stressfree.Presenters.MainPresenter;
import com.example.kristian.stressfree.Presenters.PicturePresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.example.kristian.stressfree.Utilities.Globals;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PictureActivity extends AppCompatActivity implements PicturePresenter.Context{

    private PicturePresenter presenter;
    private Button btAnimals, btNature;
    private Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        presenter = new PicturePresenter(this);
        globals = new Globals(this);

        // Initialising widgets
        final GridView gridview = findViewById(R.id.gridViewPictures);
        Button btAnimals = findViewById(R.id.btPicAnimals);
        Button btNature = findViewById(R.id.btPicNature);

        gridview.setAdapter(new ImageAdapter(   this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(PictureActivity.this, FullscreenPicActivity.class);
                presenter.getPictureURI();
                //fullScreenIntent.setData(tUri);
                startActivity(fullScreenIntent);
            }
        });

        btAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mNatureIds.length;
        }

        public Object getItem(int position) {

            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mNatureIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mNatureIds = {
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background,
                R.drawable.beautiful_green_forest_background
        };
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
            Intent intent =  new Intent(PictureActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        if (id == R.id.btLogoff) {
            globals.LogOutDialog();
        }
        return false;
    }

}
