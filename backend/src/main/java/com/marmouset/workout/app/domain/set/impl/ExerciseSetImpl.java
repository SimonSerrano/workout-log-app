package com.marmouset.workout.app.domain.set.impl;

import com.marmouset.workout.app.domain.set.ExerciseSet;

/**
 * Represents an exercise set.
 */
public class ExerciseSetImpl implements ExerciseSet {

  private int reps;

  /**
   * Constructs an exercise set.
   *
   * @param reps the number of reps of that set
   */
  public ExerciseSetImpl(int reps) {
    this.reps = reps;
  }

  @Override
  public int getReps() {
    return reps;
  }

  @Override
  public ExerciseSet setReps(int reps) {
    this.reps = reps;
    return this;
  }
}
