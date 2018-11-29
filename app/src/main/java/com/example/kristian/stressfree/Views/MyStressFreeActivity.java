package com.example.kristian.stressfree.Views;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.MyStressFreePresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.example.kristian.stressfree.Utilities.Globals;
import com.example.kristian.stressfree.Utilities.ImageAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MyStressFreeActivity extends OptionsMenu implements MyStressFreePresenter.Context {

    private MyStressFreePresenter presenter;

    public Uri getFilePath() {
        return filePath;
    }

    public Uri filePath;
    private Button btupload, btchoose;


    private GridView gridView;
    private ImageView imageView;
    final private String LOG = "MYSTRESSFREEACTIVITY";
    final private String GETSHARED = "GETSHAREDSTRESSFREE";
    private ArrayList<String> LocalPictureArray;

    private final int PICK_IMAGE_REQUEST = 71;

    // Firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    // Shared Preferences
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_free);
        presenter = new MyStressFreePresenter(this);


        // Firebase initializaion
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        // Shared Preferences init
        sp = getPreferences(Context.MODE_PRIVATE);
        try {
            LocalPictureArray = new ArrayList<>(Arrays.asList(sp.getString(GETSHARED, "").split(",")));
            presenter.setMyPictureArray(LocalPictureArray);
        } catch (Exception e) {
            Log.d(LOG, "onCreate: " + e.getMessage());
        }

        btupload = findViewById(R.id.btUpload);
        btchoose = findViewById(R.id.btChoose);
        gridView = findViewById(R.id.gridViewMyPictures);

        imageView = findViewById(R.id.imageView);

        setGridView(LocalPictureArray);

        btchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.chooseImage();
            }
        });

        btupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.UploadImage();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(MyStressFreeActivity.this, FullscreenPicActivity.class);
                fullScreenIntent.putExtra("picURI", LocalPictureArray.get(i));
                startActivity(fullScreenIntent);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                presenter.DeleteSelectedImage(position);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(MyStressFreeActivity.this);
                builder.setMessage(R.string.SikkerPåSlet).setPositiveButton(R.string.Ja, dialogClickListener)
                        .setNegativeButton(R.string.Nej, dialogClickListener).show();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setGridView(ArrayList<String> pictureArray) {
        String[] s = new String[pictureArray.size()];
        s = pictureArray.toArray(s);
        gridView.setAdapter(new ImageAdapter(MyStressFreeActivity.this, s));
    }




}
