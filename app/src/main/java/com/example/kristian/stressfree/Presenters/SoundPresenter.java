package com.example.kristian.stressfree.Presenters;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kristian.stressfree.Views.SoundActivity;
import com.example.kristian.stressfree.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SoundPresenter {


    private SoundPresenter.Context view;
    private Uri tUri;
    private FirebaseAuth mAuth;
    private String SOUNDPRESENTER = "SOUND PRESENTER";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;

    // Constructor
    public SoundPresenter(SoundPresenter.Context view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
        storageRef = storage.getReference();
    }

    public void getSoundURI(){
        
    }




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


    public interface Context{

    }


}
