package com.marmouset.workout.app.exerciseset.entity;

import com.marmouset.workout.app.shared.entity.Entity;

/**
 * Interface to represent the exercise set entity.
 */
public interface ExerciseSet extends Entity<Long> {

  /**
   * Get the number of repetitions during that set.
   *
   * @return the numer of reps
   */
  int getReps();

  /**
   * Set the number of reps.
   *
   * @param reps the number of reps.
   * @return this
   */
  ExerciseSet setReps(int reps);
}
