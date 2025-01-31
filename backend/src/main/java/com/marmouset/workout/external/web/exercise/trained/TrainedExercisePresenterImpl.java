package com.marmouset.workout.external.web.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import org.springframework.stereotype.Component;

@Component
class TrainedExercisePresenterImpl implements TrainedExercisePresenter {
  @Override
  public TrainedExerciseResponse present(TrainedExercise exercise) {
    return new TrainedExerciseResponse(
        exercise.getExercise(),
        exercise.getSets());
  }
}
