package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.kristian.stressfree.Models.Music;
import com.example.kristian.stressfree.Presenters.SoundPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MusicAdapter;

import java.util.ArrayList;

public class    SoundActivity extends OptionsMenu  {

    private ArrayList<Music> arrayList;
    private MusicAdapter adapter;
    private ListView lwSound;
    private SoundPresenter soundPresenter;

    private String[] mNatureUris, mMusicUris;

    private Button btMusic;
    private Button btNature;

    private int flip = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);


        //URL String array
        mMusicUris = new String[]{


        };

        mNatureUris = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FCold%20Wind.mp3?alt=media&token=d731b281-acd8-4b79-8e57-f8bd1a55c7b3",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FJungle.mp3?alt=media&token=92596046-3b82-4ecb-94f0-a13f702b13ae",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FLarge%20Waterfall.mp3?alt=media&token=27b7af73-9108-49ce-99c3-8df2cf2bd68a",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSmall%20Waterfall.mp3?alt=media&token=aed0e9c2-c50b-4264-975b-f60a87471b0e",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FSmall%20Waterfall.mp3?alt=media&token=aed0e9c2-c50b-4264-975b-f60a87471b0e",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/SoundNature%2FStrong%20Wind.mp3?alt=media&token=cc969803-7b93-4e18-a3fd-65703048473b"
        };



        //Initialising
        lwSound = (ListView) findViewById(R.id.lwSound);
        arrayList = new ArrayList<>();
        btMusic = findViewById(R.id.btMusic);
        btNature = findViewById(R.id.btNature);
        //soundPresenter = new SoundPresenter(this);

        adapter = new MusicAdapter(this, R.layout.music_item, arrayList);
        lwSound.setAdapter(adapter);


        btMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clearing the list first and then adding the music



                /**if (isEmpty) {
                    arrayList.clear();
                    arrayList.add(new Music("Mama Said", "Lukas Graham", R.raw.mama_said));
                    adapter.notifyDataSetChanged();
                    isEmpty = false;
                }
                // If it gets clicked again, it will clear first before adding the music
                else {
                    arrayList.clear();
                    arrayList.add(new Music("Mama Said", "Lukas Graham", R.raw.mama_said));
                    adapter.notifyDataSetChanged();
                    isEmpty = true;
                }
                 */




            }
        });

        btNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  lwSound.setAdapter(new MusicAdapter(SoundActivity.this, R.layout.music_item, mNatureUris));






                //clearing the list first and then adding the music
               /** if (isEmpty) {
                    arrayList.clear();
                    arrayList.add(new Music("Happy Home", "Lukas Graham", R.raw.happy_home));
                    adapter.notifyDataSetChanged();
                    isEmpty = false;
                } else
                // If it gets clicked again, it will clear first before adding the music
                {
                    arrayList.clear();
                    arrayList.add(new Music("Happy Home", "Lukas Graham", R.raw.happy_home));
                    adapter.notifyDataSetChanged();
                    isEmpty = true;

                }
                */
            }
        });

    }

}
