package com.example.kristian.stressfree.Presenters;

import android.app.Application;
import android.content.Context;

import com.example.kristian.stressfree.Models.Exercise;
import com.example.kristian.stressfree.R;
import java.util.ArrayList;
import android.content.Context;
import android.content.res.Resources;

public class MovementPresenter extends Application {
    private MovementPresenter.Context view;
    public static Context context;

    private ArrayList<Exercise> exerciseListLow, exerciseListMedium, exerciseListHigh;
    // Constructor
    public MovementPresenter(MovementPresenter.Context view) {
        this.view = view;

/*
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
        */
    }

    public ArrayList<Exercise> getExerciseListLow() {
        return exerciseListLow;
    }

    public ArrayList<Exercise> getExerciseListMedium() {
        return exerciseListMedium;
    }

    public ArrayList<Exercise> getExerciseListHigh() {
        return exerciseListHigh;
    }

    // Interface to the methods in MovementActivity
    public interface Context {

    }
}
