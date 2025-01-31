package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;

/**
 * Presenter for the Exercise.
 */
public interface ExercisePresenter {
  /**
   * Presents an Exercise to an ExerciseResponse.
   *
   * @param exercise the exercise to present
   * @return the response
   */
  ExerciseResponse present(Exercise exercise);
}
