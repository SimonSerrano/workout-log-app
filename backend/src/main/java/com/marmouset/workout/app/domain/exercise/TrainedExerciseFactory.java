package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Factory to create trained exercises.
 */
public interface TrainedExerciseFactory {
  /**
   * Creates a Trained exercise.
   *
   * @param id
   * @param exercise the trained exercise
   * @return the trained exercise
   */
  TrainedExercise create(UUID id, Exercise exercise);
}
