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
/*
        exerciseListLow = presenter.getExerciseListLow();
        exerciseListMedium = presenter.getExerciseListMedium();
        exerciseListHigh = presenter.getExerciseListHigh();


*/
        exerciseListLow = new ArrayList<>();
        exerciseListLow.add(new Exercise(getResources().getString(R.string.GåPåStedet),getResources().getString(R.string.GåPåStedet_beskrivelse),1));
        exerciseListLow.add(new Exercise(getResources().getString(R.string.GåEnTur), getResources().getString(R.string.GåEnTur_beskrivelse),1));
        exerciseListLow.add(new Exercise(getResources().getString(R.string.HurtigUdstrækning),getResources().getString(R.string.HurtigUdstrækning_beskrivelse),1));
        exerciseListLow.add(new Exercise(getResources().getString(R.string.RygUdstrækning),getResources().getString(R.string.RygUdstrækning_beskrivelse),1));

        exerciseListMedium = new ArrayList<>();
        exerciseListMedium.add(new Exercise(getResources().getString(R.string.Armstrækninger),getResources().getString(R.string.Armstrækninger_beskrivelse),2));
        exerciseListMedium.add(new Exercise(getResources().getString(R.string.Stepups),getResources().getString(R.string.Stepups_beskrivelse),2));
        exerciseListMedium.add(new Exercise(getResources().getString(R.string.Squats),getResources().getString(R.string.Squats_beskrivelse),2));
        exerciseListMedium.add(new Exercise(getResources().getString(R.string.Skulderløft),getResources().getString(R.string.Skulderløft_Beskrivelse),2));
        exerciseListMedium.add(new Exercise(getResources().getString(R.string.Mavebøjninger),getResources().getString(R.string.Mavebøjninger_beskrivelse),2));

        exerciseListHigh = new ArrayList<>();
        exerciseListHigh.add(new Exercise(getResources().getString(R.string.HøjeKnæløft),getResources().getString(R.string.HøjeKnæløft_beskrivelse),3));
        exerciseListHigh.add(new Exercise(getResources().getString(R.string.armbøjninger50),getResources().getString(R.string.armbøjninger50_beskrivelse),3));
        exerciseListHigh.add(new Exercise(getResources().getString(R.string.Løb5km),getResources().getString(R.string.Løb5km_beskrivelse),3));
        exerciseListHigh.add(new Exercise(getResources().getString(R.string.Løb10km),getResources().getString(R.string.Løb10km_beskrivelse),3));


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
                currentList = exerciseListLow;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

        btMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextViews();
                currentList = exerciseListMedium;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

        btHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextViews();
                currentList = exerciseListHigh;
                listView.setAdapter(new MovementAdapter(MovementActivity.this, currentList));
            }
        });

    }

    public void showTextViews() {
        twName.setVisibility(View.VISIBLE);
        twDiff.setVisibility(View.VISIBLE);
    }


}

