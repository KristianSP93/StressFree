package com.example.kristian.stressfree.Utilities;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kristian.stressfree.Models.Music;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Views.SoundActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {

    // The MusicAdapter is strongly inspired by https://www.youtube.com/watch?v=tZM4EF88OFk

    private Context c;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean bool = true;



    public MusicAdapter(Context c, int layout, ArrayList<Music> arrayList) {
        this.c = c;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        TextView txtSongName;
        TextView txtSinger;
        ImageView im_play;
        ImageView im_stop;

    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            view = layoutInflater.inflate(layout, null);
            viewHolder.txtSongName = (TextView) view.findViewById(R.id.txtSongName);
            viewHolder.txtSinger = (TextView) view.findViewById(R.id.txtSinger);
            viewHolder.im_play = (ImageView) view.findViewById(R.id.play);
            viewHolder.im_stop = (ImageView) view.findViewById(R.id.stop);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Music music = arrayList.get(position);
        viewHolder.txtSongName.setText(music.getSongName());
        viewHolder.txtSinger.setText(music.getSinger());



        viewHolder.im_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bool)
                {
                    try {
                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FLukas%20Graham%20-%20Mama%20Said.mp3?alt=media&token=5e7ec0e9-53a0-4067-b7f5-cc9b622e5c92");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer = MediaPlayer.create(c, music.getSong());
                    bool = false;
                }
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    viewHolder.im_play.setImageResource(R.drawable.im_play);
                }
                else
                {
                    mediaPlayer.start();
                    viewHolder.im_play.setImageResource(R.drawable.im_pause);
                }
            }
        });



        viewHolder.im_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bool)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    bool = true;
                }
                viewHolder.im_play.setImageResource(R.drawable.im_play);

            }
        });


        return view;

    }

    /*
    private void fetchAudioFromFirebase(){
        final FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundMusic%2FAkon%20-%20Smack%20That%20ft.%20Eminem.mp3?alt=media&token=e5dc5a38-586f-4eae-a2c0-89bddbbf7be6");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                try {
                    final String url = uri.toString();
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.setOnPreparedListener(MusicAdapter.this);
                    mediaPlayer.prepareAsync();
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
