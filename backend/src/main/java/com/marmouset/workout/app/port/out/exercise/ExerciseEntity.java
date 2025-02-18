package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.port.out.Entity;

/**
 * Interface representing an exercise entity.
 */
public interface ExerciseEntity extends Entity<String> {

  /**
   * Gets the name of the exercise.
   *
   * @return the name
   */
  String getName();
}
