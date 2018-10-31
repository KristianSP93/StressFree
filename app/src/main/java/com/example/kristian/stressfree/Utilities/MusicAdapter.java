package com.example.kristian.stressfree.Utilities;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kristian.stressfree.Models.Music;
import com.example.kristian.stressfree.R;

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

}
