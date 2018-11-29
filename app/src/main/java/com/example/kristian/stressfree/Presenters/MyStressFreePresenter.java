package com.example.kristian.stressfree.Presenters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.ImageAdapter;
import com.example.kristian.stressfree.Views.MyStressFreeActivity;
import com.example.kristian.stressfree.Views.OptionsMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.UUID;

public class MyStressFreePresenter {
    private MyStressFreePresenter.Context view;
    private Activity activity;
    private Uri filePath2;
    private String LOG = "MYSTRESSFREEPRESENTER";
    private final int PICK_IMAGE_REQUEST = 71;
    final private String GETSHARED = "GETSHAREDSTRESSFREE";

    public void setMyPictureArray(ArrayList<String> myPictureArray) {
        this.myPictureArray = myPictureArray;
    }

    private ArrayList<String> myPictureArray;
    private FirebaseAuth mAuth;

    // Firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    // Shared Preferences
    SharedPreferences sp;


    public MyStressFreePresenter(MyStressFreeActivity view) {
        this.view = view;
        activity = (Activity) view;
        mAuth = FirebaseAuth.getInstance();
        sp = activity.getPreferences(android.content.Context.MODE_PRIVATE);
        // Firebase initializaion
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
    }


    public void UploadImage() {

        if (view.getFilePath() != null) {
            final ProgressDialog progressdialog = new ProgressDialog(activity);
            progressdialog.setTitle(activity.getResources().getString(R.string.Uploader));
            progressdialog.show();
            final String uuid = UUID.randomUUID().toString();

            final StorageReference ref = storageReference.child("MyStressFree/" + mAuth.getCurrentUser().getEmail() + "/" + uuid);
            ref.putFile(view.getFilePath())
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            // Hacker løsning - hvis der er tid skal en anden findes
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                Log.d(LOG, "onComplete: " + e);
                            }
                            storageReference.child("MyStressFree/" + mAuth.getCurrentUser().getEmail() + "/" + uuid).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    // Got the download URL for
                                    myPictureArray.add(uri.toString());

                                    uploadSharedPreferences();

                                    view.setGridView(myPictureArray);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle any errors
                                    Toast.makeText(activity, exception.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                            progressdialog.dismiss();
                            //Toast.makeText(MyStressFreeActivity.this, getResources().getString(R.string.UploadSuccesfuld), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressdialog.dismiss();
                            Toast.makeText(activity, activity.getResources().getString(R.string.UploadFejlede) + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressdialog.setMessage(activity.getResources().getString(R.string.Uploader) + (int) progress + "%");
                        }
                    });
        }
    }

    public void DeleteSelectedImage(int Position){
        myPictureArray.remove(Position);
        uploadSharedPreferences();
        view.setGridView(myPictureArray);
    }

    public void uploadSharedPreferences(){
        SharedPreferences.Editor editor = sp.edit();
        StringBuilder sb = new StringBuilder();
        for (String s : myPictureArray) {
            sb.append(s);
            sb.append(",");
        }
        editor.putString(GETSHARED, sb.toString());
        editor.commit();
    }

    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }





    // Interface to the methods in MyStressFree
    public interface Context {
        void setGridView(ArrayList<String> pictureArray);
        Uri getFilePath();
    }
}


