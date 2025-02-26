package com.marmouset.workout.app.exerciseset.adapter;

import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.shared.adapter.Presenter;

/**
 * Converts exercise set from the use case to the web.
 */
public interface ExerciseSetResponsePresenter
    extends Presenter<ExerciseSet, ExerciseSetResponse> {
}
