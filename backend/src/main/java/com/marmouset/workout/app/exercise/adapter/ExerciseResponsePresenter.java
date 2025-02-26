package com.marmouset.workout.app.exercise.adapter;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.shared.adapter.Presenter;

/**
 * Converts data from the use case to the web for the exercise.
 */
public interface ExerciseResponsePresenter extends
    Presenter<Exercise, ExerciseResponse> {
}
