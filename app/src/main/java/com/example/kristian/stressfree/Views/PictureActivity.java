package com.example.kristian.stressfree.Views;

import android.content.Context;
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

import com.example.kristian.stressfree.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PictureActivity extends AppCompatActivity {

    private StorageReference mStorageRef;
    private boolean boo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        final GridView gridview = (GridView) findViewById(R.id.gridViewPictures);


        gridview.setAdapter(new ImageAdapter(   this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(boo == true) {
                    gridview.getChildAt(i).setMinimumWidth(200);
                    gridview.getChildAt(i).setMinimumHeight(200);
                    boo = false;
                } else{
                    gridview.getChildAt(i).setMinimumWidth(20);
                    gridview.getChildAt(i).setMinimumHeight(20);
                    boo = true;
                }
            }

        });

    }

    public void getPictures() throws IOException {
        StorageReference picturesRef = mStorageRef.child("images/rivers.jpg");
        File localFile = File.createTempFile("images", "jpg");
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

        if (id == R.id.mybutton) {
            Intent intent =  new Intent(PictureActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        return false;
    }

}
