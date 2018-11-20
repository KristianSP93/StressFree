package com.example.kristian.stressfree.Views;

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
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MovementAdapter;

import java.util.ArrayList;

public class MovementActivity extends OptionsMenu {

    private Button btLow, btMedium, btHigh;
    private MovementAdapter mAdapter;
    private ListView listView;
    private TextView twName, twDiff;
    private ArrayList<Exercise> currentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);

        btLow = findViewById(R.id.btMovLow);
        btMedium = findViewById(R.id.btMovMedium);
        btHigh = findViewById(R.id.btMovHigh);
        listView = findViewById(R.id.movementListView);
        twName = findViewById(R.id.twExerciseName);
        twDiff = findViewById(R.id.twExerciseDifficulty);

        twName.setVisibility(View.INVISIBLE);
        twDiff.setVisibility(View.INVISIBLE);
    
        final ArrayList<Exercise> exerciseListLow = new ArrayList<>();
        exerciseListLow.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen", 1));
        exerciseListLow.add(new Exercise("Rejs dig op", "Stil dig op i 10 minutter og bevæg dig stille fra side til side", 1));
        exerciseListLow.add(new Exercise("En øvelse med et meget meget meget meget langt navn som måske slet ikke kan være der, men det kan det faktisk måske alligevel, men hvad nu hvis det faktisk slet ikke kan det alligevel og vi skal til at lave det hele om eller lave noget andet", "Med noget", 1));
        exerciseListLow.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 1));


        final ArrayList<Exercise> exerciseListMedium = new ArrayList<>();
        exerciseListMedium.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 2));


        final ArrayList<Exercise> exerciseListHigh = new ArrayList<>();
        exerciseListHigh.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 3));

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

