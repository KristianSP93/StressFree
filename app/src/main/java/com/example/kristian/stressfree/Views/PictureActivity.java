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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PictureActivity extends AppCompatActivity {

    private Uri tUri;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        storageRef = storage.getReference();

        // Initialising widgets
        final GridView gridview = findViewById(R.id.gridViewPictures);

        gridview.setAdapter(new ImageAdapter(   this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(PictureActivity.this, FullscreenPicActivity.class);
                getPictureURI();
                fullScreenIntent.setData(tUri);
                startActivity(fullScreenIntent);
            }
        });
    }

    public void getPictureURI(){
        //StorageReference filepath = mStorageRef.child("PictureNature").child("beautiful_green_forest_background.png");

        storageRef.child("PictureNature/watergreen.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                tUri = uri;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                tUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2Fbeautiful_green_forest_background.png?alt=media&token=7e9e262b-6155-4e69-9964-a04ad35d0b1d");
                Toast.makeText(PictureActivity.this, "Fejl: " + exception.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getPictures() throws IOException {
        StorageReference picturesRef = storageRef.child("PictureNature/beautiful_green_forest_background.png");
        File localFile = File.createTempFile("images", "png");
        picturesRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });
    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
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

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                //R.drawable.agriculture_bright_clouds_440731,
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


/*
    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }


        public Object getItem(int position){
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                //imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
                //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        private Integer[] mThumbIds = {
                R.drawable.agriculture_bright_clouds_440731,
                R.drawable.beautiful_green_forest_background
        };


    }

    */

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
            Intent intent = new Intent(PictureActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return false;
    }

}
