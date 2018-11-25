package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.kristian.stressfree.Presenters.MyStressFreePresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.ImageAdapter;

import java.io.IOException;

public class MyStressFreeActivity extends OptionsMenu implements MyStressFreePresenter.Context {

    private MyStressFreePresenter presenter;
    private Uri filePath;
    private Button btupload, btchoose;
    private GridView gridView;
    private String[] myPictureArray;

    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_free);
        presenter = new MyStressFreePresenter(this);

        btupload = findViewById(R.id.btUpload);
        btchoose = findViewById(R.id.btChoose);
        gridView = findViewById(R.id.gridViewMyPictures);

        myPictureArray = new String[]{};


        gridView.setAdapter(new ImageAdapter(MyStressFreeActivity.this, myPictureArray));

        btchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        btupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImage();
            }
        });

    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void UploadImage() {
    }




}
