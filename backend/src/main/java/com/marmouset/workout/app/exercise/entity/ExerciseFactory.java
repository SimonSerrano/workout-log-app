package com.marmouset.workout.app.exercise.entity;

/**
 * Factory to create Exercises.
 */
public interface ExerciseFactory {
  /**
   * Creates an exerciseContainer.
   *
   * @param name the unique name of that exerciseContainer
   * @return the exerciseContainer
   */
  Exercise create(String name);
}
