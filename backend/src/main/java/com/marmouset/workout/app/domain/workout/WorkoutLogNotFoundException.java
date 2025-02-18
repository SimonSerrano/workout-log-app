package com.marmouset.workout.app.domain.workout;

import java.util.UUID;

/**
 * Exception when a workout log is not found.
 */
public class WorkoutLogNotFoundException extends Exception {

  /**
   * Creates a WorkoutLogNotFoundException.
   *
   * @param id the id of the log
   */
  public WorkoutLogNotFoundException(UUID id) {
    super("Workout log with id " + id + " is not found");
  }

}
