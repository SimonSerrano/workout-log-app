package com.marmouset.workout.app.domain.set;

/**
 * Interface for the exercise set factory.
 */
public interface ExerciseSetFactory {
  /**
   * Creates an ExerciseSet.
   *
   * @param reps the number of reps in that set
   * @return a new ExerciseSet
   */
  ExerciseSet create(int reps);
}
