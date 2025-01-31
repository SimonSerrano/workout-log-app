package com.marmouset.workout.app.domain.exercise;

/**
 * Factory to create trained exercises.
 */
public interface TrainedExerciseFactory {
  /**
   * Creates a Trained exercise.
   *
   * @param exercise the trained exercise
   * @return the trained exercise
   */
  TrainedExercise create(Exercise exercise);
}
