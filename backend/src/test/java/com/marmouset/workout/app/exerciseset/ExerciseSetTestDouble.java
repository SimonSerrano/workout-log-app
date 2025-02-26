package com.marmouset.workout.app.exerciseset;

import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;

/**
 * Exercise set test double with static values.
 */
public class ExerciseSetTestDouble implements ExerciseSet {

  private final Long id = 10L;
  private int reps = 8;

  @Override
  public int getReps() {
    return reps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExerciseSetTestDouble that = (ExerciseSetTestDouble) o;

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

  @Override
  public ExerciseSet setReps(int reps) {
    this.reps = reps;
    return this;
  }

  @Override
  public Long getId() {
    return id;
  }
}
