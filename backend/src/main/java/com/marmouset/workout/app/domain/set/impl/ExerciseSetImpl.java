package com.marmouset.workout.app.domain.set.impl;

import com.marmouset.workout.app.domain.set.ExerciseSet;

/**
 * Represents an exerciseContainer set.
 */
public class ExerciseSetImpl implements ExerciseSet {

  private final Long id;
  private int reps;

  /**
   * Constructs an exerciseContainer set.
   *
   * @param id   the id
   * @param reps the number of reps of that set
   */
  public ExerciseSetImpl(Long id, int reps) {
    this.id = id;
    this.reps = reps;
  }

  @Override
  public Long getId() {
    return id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExerciseSetImpl that = (ExerciseSetImpl) o;

    if (reps != that.reps) {
      return false;
    }
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + reps;
    return result;
  }
}
