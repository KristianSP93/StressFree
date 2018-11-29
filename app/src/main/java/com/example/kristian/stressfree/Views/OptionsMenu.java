package com.example.kristian.stressfree.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.Globals;

public class OptionsMenu extends AppCompatActivity {


    private Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        globals = new Globals(this);
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
        if(globals.IsUserLoggedIn()){
            int id = item.getItemId();

            if (id == R.id.btSettings) {
                Intent intent =  new Intent(OptionsMenu.this, SettingsActivity.class);
                startActivity(intent);

            }
            if (id == R.id.btLogoff) {
                globals.LogOutDialog();
            }
            return false;
        } else{
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            break;
                    }
                }
            };
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(OptionsMenu.this);
            builder.setMessage(R.string.BrugerLoggetind).setPositiveButton(R.string.Ok, dialogClickListener);
            builder.show();
        }
        return false;




    }
}
