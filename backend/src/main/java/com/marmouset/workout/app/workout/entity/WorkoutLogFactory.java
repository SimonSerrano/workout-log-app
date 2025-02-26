package com.marmouset.workout.app.workout.entity;

/**
 * Factory to create workout logs.
 */
public interface WorkoutLogFactory {
  /**
   * Creates a workout logContainer.
   *
   * @param name the name
   * @return the workout logContainer
   */
  WorkoutLog create(String name);
}
