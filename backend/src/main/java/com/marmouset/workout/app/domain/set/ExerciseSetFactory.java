package com.marmouset.workout.app.domain.set;

import java.util.UUID;

/**
 * Interface for the exercise set factory.
 */
public interface ExerciseSetFactory {
  /**
   * Creates an ExerciseSet.
   *
   * @param id
   * @param reps the number of reps in that set
   * @return a new ExerciseSet
   */
  ExerciseSet create(UUID id, int reps);
}
