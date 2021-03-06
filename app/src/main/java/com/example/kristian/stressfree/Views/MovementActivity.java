package com.example.kristian.stressfree.Views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kristian.stressfree.Models.Exercise;
import com.example.kristian.stressfree.Presenters.MovementPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MovementAdapter;

import java.util.ArrayList;

public class MovementActivity extends OptionsMenu implements MovementPresenter.Context{

    private Button btLow, btMedium, btHigh;
    private ListView listView;
    private TextView twName, twDiff;
    private ArrayList<Exercise> currentList, exerciseListLow, exerciseListMedium, exerciseListHigh;
    private MovementPresenter presenter;
    private int flip = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);
        presenter = new MovementPresenter(this);

        btLow = findViewById(R.id.btMovLow);
        btMedium = findViewById(R.id.btMovMedium);
        btHigh = findViewById(R.id.btMovHigh);
        listView = findViewById(R.id.movementListView);
        twName = findViewById(R.id.twExerciseName);
        twDiff = findViewById(R.id.twExerciseDifficulty);

        twName.setVisibility(View.INVISIBLE);
        twDiff.setVisibility(View.INVISIBLE);

        exerciseListLow = presenter.getExerciseListLow();
        exerciseListMedium = presenter.getExerciseListMedium();
        exerciseListHigh = presenter.getExerciseListHigh();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MovementActivity.this);
                dlgAlert.setMessage(currentList.get(i).getExerciseDescription());
                dlgAlert.setTitle(getResources().getString(R.string.Øvelsesbeskrivelse));
                dlgAlert.setPositiveButton(getResources().getString(R.string.Ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });

        btLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextViews();
                flip = 1;
                currentList = exerciseListLow;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

        btMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextViews();
                flip = 2;
                currentList = exerciseListMedium;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

        btHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextViews();
                flip = 3;
                currentList = exerciseListHigh;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

    }

    public void showTextViews() {
        twName.setVisibility(View.VISIBLE);
        twDiff.setVisibility(View.VISIBLE);
    }

    public void setAdapter(){
        if(flip == 1){
            showTextViews();
            listView.setAdapter(new MovementAdapter(MovementActivity.this, exerciseListLow));
        } else if (flip == 2){
            showTextViews();
            listView.setAdapter(new MovementAdapter(MovementActivity.this, exerciseListMedium));
        } else if(flip == 3){
            showTextViews();
            listView.setAdapter(new MovementAdapter(MovementActivity.this, exerciseListHigh));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("FlipValue", flip);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        flip = savedInstanceState.getInt("FlipValue", flip);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setAdapter();
    }


}

