package com.marmouset.workout.app.domain.workout;

import java.util.UUID;

/**
 * Exception when a workout logContainer is not found.
 */
public class WorkoutLogNotFoundException extends Exception {

  /**
   * Creates a WorkoutLogNotFoundException.
   *
   * @param id the id of the logContainer
   */
  public WorkoutLogNotFoundException(UUID id) {
    super("Workout logContainer with id " + id + " is not found");
  }

}
