package com.example.kristian.stressfree.Models;

public class Exercise {

    public Exercise(String exerciseName, String exerciseDescription, Integer exerciseDifficulty) {
        ExerciseName = exerciseName;
        ExerciseDescription = exerciseDescription;
        ExerciseDifficulty = exerciseDifficulty;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return ExerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        ExerciseDescription = exerciseDescription;
    }

    public Integer getExerciseDifficulty() {
        return ExerciseDifficulty;
    }

    public void setExerciseDifficulty(Integer exerciseDifficulty) {
        ExerciseDifficulty = exerciseDifficulty;
    }

    private String ExerciseName;
    private String ExerciseDescription;
    private Integer ExerciseDifficulty;
}
