package com.marmouset.workout.app.exercise.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.ExerciseResponsePresenter;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.Objects;

/**
 * Converts data from the use cases to the web.
 */
public class ExerciseResponsePresenterImpl
    implements ExerciseResponsePresenter {
  @Override
  public ExerciseResponse present(Exercise exercise) {
    Objects.requireNonNull(exercise, "Exercise is null");
    return new ExerciseResponse(exercise.getName());
  }
}
