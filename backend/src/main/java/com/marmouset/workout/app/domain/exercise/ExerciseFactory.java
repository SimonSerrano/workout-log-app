package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Factory to create Exercises.
 */
public interface ExerciseFactory {
  /**
   * Creates an exerciseContainer.
   *
   * @param id   the unique id of that exerciseContainer
   * @param name the unique name of that exerciseContainer
   * @return the exerciseContainer
   */
  Exercise create(UUID id, String name);
}
