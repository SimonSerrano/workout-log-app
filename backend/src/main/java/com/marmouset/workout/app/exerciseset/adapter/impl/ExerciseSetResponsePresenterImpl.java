package com.marmouset.workout.app.exerciseset.adapter.impl;

import com.marmouset.workout.app.exerciseset.adapter.ExerciseSetResponsePresenter;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;

/**
 * Converts exercise set from the use cases to the web.
 */
public class ExerciseSetResponsePresenterImpl
    implements ExerciseSetResponsePresenter {
  @Override
  public ExerciseSetResponse present(ExerciseSet exerciseSet) {
    return new ExerciseSetResponse(exerciseSet.getId(), exerciseSet.getReps());
  }
}
