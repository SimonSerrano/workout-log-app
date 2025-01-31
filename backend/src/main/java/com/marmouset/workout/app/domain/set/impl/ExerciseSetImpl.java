package com.marmouset.workout.app.domain.set.impl;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.UUID;

/**
 * Represents an exercise set.
 */
public class ExerciseSetImpl implements ExerciseSet {

  private final UUID id;
  private int reps;

  /**
   * Constructs an exercise set.
   *
   * @param id   the id
   * @param reps the number of reps of that set
   */
  public ExerciseSetImpl(UUID id, int reps) {
    this.id = id;
    this.reps = reps;
  }

  @Override
  public UUID getId() {
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
}
