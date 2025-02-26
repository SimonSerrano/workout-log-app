package com.marmouset.workout.app.exerciseset.entity;

/**
 * Interface for the exerciseContainer set factory.
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
