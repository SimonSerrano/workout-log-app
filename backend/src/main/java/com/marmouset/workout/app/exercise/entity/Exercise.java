package com.marmouset.workout.app.exercise.entity;

import com.marmouset.workout.app.shared.entity.Entity;

/**
 * Interface representing an exercise entity.
 */
public interface Exercise extends Entity<String> {

  /**
   * Gets the name of the exercise.
   *
   * @return the name
   */
  String getName();
}
