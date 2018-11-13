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
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MusicAdapter;

import java.util.ArrayList;

public class    SoundActivity extends AppCompatActivity {

    private ArrayList<Music> arrayList;
    private MusicAdapter adapter;
    private ListView lwSound;

    private Button btMusic;
    private Button btNature;

    private Boolean isEmpty = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        lwSound = (ListView) findViewById(R.id.lwSound);
        arrayList = new ArrayList<>();
        btMusic = findViewById(R.id.btMusic);
        btNature = findViewById(R.id.btNature);


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


    // creating action bar using menu from res
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // open settings from this activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            Intent intent =  new Intent(SoundActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        return false;
    }
}
