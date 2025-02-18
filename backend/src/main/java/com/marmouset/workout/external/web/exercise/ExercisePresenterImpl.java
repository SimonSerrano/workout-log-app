package com.marmouset.workout.external.web.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import org.springframework.stereotype.Component;

@Component
class ExercisePresenterImpl implements ExercisePresenter {

  @Override
  public ExerciseResponse present(Exercise exercise) {
    return new ExerciseResponse(exercise.name());
  }

}
