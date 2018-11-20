package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Models.Exercise;

import java.util.ArrayList;

public class MovementPresenter {
    private MovementPresenter.Context view;
    private ArrayList<Exercise> exerciseListLow, exerciseListMedium, exerciseListHigh;
    // Constructor
    public MovementPresenter(MovementPresenter.Context view) {
        this.view = view;

        exerciseListLow = new ArrayList<>();
        exerciseListLow.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen", 1));
        exerciseListLow.add(new Exercise("Rejs dig op", "Stil dig op i 10 minutter og bevæg dig stille fra side til side", 1));
        exerciseListLow.add(new Exercise("En øvelse med et meget meget meget meget langt navn som måske slet ikke kan være der, men det kan det faktisk måske alligevel, men hvad nu hvis det faktisk slet ikke kan det alligevel og vi skal til at lave det hele om eller lave noget andet", "Med noget", 1));
        exerciseListLow.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 1));

        exerciseListMedium = new ArrayList<>();
        exerciseListMedium.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 2));

        exerciseListHigh = new ArrayList<>();
        exerciseListHigh.add(new Exercise("Gåtur", "Gå en lang tur rundt om bygningen eller noget med en sætning som er ekstra meget længere og derfor kan gøre at vores fine lille alertbox slet ikke kan følge me dog vi e rnødt ti at sende en hjelt ny form for box men det håber jeg ikke bliver nødvendigt", 3));
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
