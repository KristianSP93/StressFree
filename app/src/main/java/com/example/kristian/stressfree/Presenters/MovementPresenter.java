package com.example.kristian.stressfree.Presenters;

import android.app.Activity;
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
    private Activity activity;
    private ArrayList<Exercise> exerciseListLow, exerciseListMedium, exerciseListHigh;

    // Constructor
    public MovementPresenter(MovementPresenter.Context view) {
        this.view = view;
        activity = (Activity) view;
        CreateLists();
    }

    private void CreateLists(){
        exerciseListLow = new ArrayList<>();
        exerciseListLow.add(new Exercise(activity.getResources().getString(R.string.GåPåStedet),activity.getResources().getString(R.string.GåPåStedet_beskrivelse),1));
        exerciseListLow.add(new Exercise(activity.getResources().getString(R.string.GåEnTur), activity.getResources().getString(R.string.GåEnTur_beskrivelse),1));
        exerciseListLow.add(new Exercise(activity.getResources().getString(R.string.HurtigUdstrækning),activity.getResources().getString(R.string.HurtigUdstrækning_beskrivelse),1));
        exerciseListLow.add(new Exercise(activity.getResources().getString(R.string.RygUdstrækning),activity.getResources().getString(R.string.RygUdstrækning_beskrivelse),1));

        exerciseListMedium = new ArrayList<>();
        exerciseListMedium.add(new Exercise(activity.getResources().getString(R.string.Armstrækninger),activity.getResources().getString(R.string.Armstrækninger_beskrivelse),2));
        exerciseListMedium.add(new Exercise(activity.getResources().getString(R.string.Stepups),activity.getResources().getString(R.string.Stepups_beskrivelse),2));
        exerciseListMedium.add(new Exercise(activity.getResources().getString(R.string.Squats),activity.getResources().getString(R.string.Squats_beskrivelse),2));
        exerciseListMedium.add(new Exercise(activity.getResources().getString(R.string.Skulderløft),activity.getResources().getString(R.string.Skulderløft_Beskrivelse),2));
        exerciseListMedium.add(new Exercise(activity.getResources().getString(R.string.Mavebøjninger),activity.getResources().getString(R.string.Mavebøjninger_beskrivelse),2));

        exerciseListHigh = new ArrayList<>();
        exerciseListHigh.add(new Exercise(activity.getResources().getString(R.string.HøjeKnæløft),activity.getResources().getString(R.string.HøjeKnæløft_beskrivelse),3));
        exerciseListHigh.add(new Exercise(activity.getResources().getString(R.string.armbøjninger50),activity.getResources().getString(R.string.armbøjninger50_beskrivelse),3));
        exerciseListHigh.add(new Exercise(activity.getResources().getString(R.string.Løb5km),activity.getResources().getString(R.string.Løb5km_beskrivelse),3));
        exerciseListHigh.add(new Exercise(activity.getResources().getString(R.string.Løb10km),activity.getResources().getString(R.string.Løb10km_beskrivelse),3));
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
