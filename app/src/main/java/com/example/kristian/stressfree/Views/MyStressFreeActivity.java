package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kristian.stressfree.R;

public class MyStressFreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_free);
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

        if (id == R.id.btSettings) {
            Intent intent =  new Intent(MyStressFreeActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        if (id == R.id.btLogoff) {
            Intent intent = new Intent(MyStressFreeActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return false;
    }
}
