package com.marmouset.workout.external.web.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.ExercisePresenter;
import com.marmouset.workout.app.port.out.dto.ExerciseResponse;

public class ExercisePresenterImpl implements ExercisePresenter {

  @Override
  public ExerciseResponse prepareResponse(Exercise exercise) {
    return null;
  }

}
