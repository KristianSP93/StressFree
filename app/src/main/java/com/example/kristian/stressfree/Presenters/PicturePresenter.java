package com.example.kristian.stressfree.Presenters;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.kristian.stressfree.Views.PictureActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PicturePresenter {
    private PicturePresenter.Context view;
    private Uri tUri;
    private FirebaseAuth mAuth;
    private String PICTUREPRESENTER = "PICTURE PRESENTER";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;

    // Constructor
    public PicturePresenter(PicturePresenter.Context view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
        storageRef = storage.getReference();
    }


    public void getPictureURI(){
        storageRef.child("PictureNature/watergreen.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                tUri = uri;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(PICTUREPRESENTER, exception.toString());
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


    // Interface to the methods in MainActivity
    public interface Context {

    }
}
