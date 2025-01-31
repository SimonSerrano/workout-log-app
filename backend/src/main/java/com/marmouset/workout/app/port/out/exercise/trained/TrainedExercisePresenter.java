package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;

/**
 * Presenter of a TrainedExercise.
 */
public interface TrainedExercisePresenter {
  /**
   * Presents a TrainedExercise to a TrainedExerciseResponse.
   *
   * @param exercise the trained exercise to present
   * @return the response
   */
  TrainedExerciseResponse present(TrainedExercise exercise);
}
