package com.example.kristian.stressfree.Presenters;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Views.SoundActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class SoundPresenter {

    /*
    private MediaPlayer mMediaplayer;


        mMediaplayer = new MediaPlayer();
        mMediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        fetchAudioFromFirebase();


    private void fetchAudioFromFirebase(){
        final FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FAkon%20-%20Smack%20That%20ft.%20Eminem.mp3?alt=media&token=e5dc5a38-586f-4eae-a2c0-89bddbbf7be6");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                try {
                    final String url = uri.toString();
                    mMediaplayer.setDataSource(url);
                    mMediaplayer.setOnPreparedListener(SoundActivity.class);
                    mMediaplayer.prepareAsync();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("TAG", e.getMessage());
                    }
                });

    }
    */

}
