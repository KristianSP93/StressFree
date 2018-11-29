package com.example.kristian.stressfree.Presenters;

import android.app.Activity;
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
    //private SoundPresenter.Context view;
    private Activity activity;
    private String[] natureList, natureThumbnail, musicList, musicThumbnail;

    public String[] getNatureList() {
        return natureList;
    }

    public String[] getNatureThumbnail() {
        return natureThumbnail;
    }

    public String[] getMusicList() {
        return musicList;
    }

    public String[] getMusicThumbnail() {
        return musicThumbnail;
    }

    // Constructor
    public SoundPresenter(SoundActivity view) {
        //this.view = view;
        this.activity = view;

        natureList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F1.mp4?alt=media&token=2551058f-2c3d-4fa7-baa1-8f294764990f",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F2.mp4?alt=media&token=11830c5e-90f8-43ae-ab61-9728b38d714d",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F3.mp4?alt=media&token=02567df3-b95d-466d-a7c4-bc5fa0106818",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F4.mp4?alt=media&token=7d48c280-8f51-45b0-a125-17de7a027bab",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F5.mp4?alt=media&token=b4efaaf7-b428-4b2a-81c0-a724d72a75ea",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FNatureSounds%2F6.mp4?alt=media&token=8d0650b6-9f91-41c2-9771-47cee5d18fd5"
        };

        natureThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft1.jpg?alt=media&token=15afa3bc-34ae-48ac-ba3d-6420d4c96420",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft2.jpg?alt=media&token=8e2ee45f-ce18-4bc6-944e-a18aa6aa33d4",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft3.jpg?alt=media&token=c69529b9-4b4a-4480-86d3-2ddfe503290e",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft4.jpg?alt=media&token=9cdbb218-1e92-4957-ab98-91f65d189237",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft5.jpg?alt=media&token=718cdc12-3d5f-4394-9928-dd2b8b53dfa3",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSoundNatureThumbnails%2Ft6.jpg?alt=media&token=70861506-8c7b-48cf-a245-94159de2e4db"
        };

        musicList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2FBell.mp4?alt=media&token=bffd8dbd-a983-469d-902d-04319cb9dff1",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2Fhappy.mp4?alt=media&token=e7886324-5f3f-4c6e-9dca-4c7dc718aafb",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2Fharp.mp4?alt=media&token=15227ecd-c553-4d7d-a937-9d75655a0e28",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2Fpiano.mp4?alt=media&token=c1ab32e3-895c-4d41-b4ca-5a4bdfdfc335",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2Fsad.mp4?alt=media&token=e2be6402-c27d-4620-8130-a8e398a8e2db",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusic%2Fspace.mp4?alt=media&token=6ad00367-53e1-45e2-a3c3-a4d77c2a31af"
        };

        musicThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2FBellt.jpg?alt=media&token=2c2da8e5-1e6b-4644-a317-5e0a9ed1cd32",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2Fhappy.jpg?alt=media&token=fb74e3ed-7d68-4765-844b-06060d214908",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2Fharp.jpg?alt=media&token=c70f08ed-bf21-431f-bd07-382d86dcfe71",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2Fpiano.jpg?alt=media&token=fba2e0db-5d86-405f-b27a-ce4f0ab70bf2",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2Fsad.jpg?alt=media&token=ff2acf35-cc49-4890-9af5-f924b1803d92",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FMusicThumbnail%2Fspace.jpg?alt=media&token=fa8e3200-2cd8-458c-af26-abb57e0ce162"
        };
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
