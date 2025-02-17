package com.marmouset.workout.app.domain.set;

/**
 * Interface for the exerciseContainer set factory.
 */
public interface ExerciseSetFactory {
  /**
   * Creates an ExerciseSet.
   *
   * @param id   the id of the set
   * @param reps the number of reps in that set
   * @return a new ExerciseSet
   */
  ExerciseSet create(Long id, int reps);
}
