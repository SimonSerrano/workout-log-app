package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Exception when an exerciseContainer cannot be found.
 */
public class ExerciseNotFoundException extends Exception {

  /**
   * Constructs an ExerciseNotFound.
   *
   * @param id the id of the exerciseContainer
   */
  public ExerciseNotFoundException(UUID id) {
    super("The exerciseContainer of id " + id + " could not be found");
  }
}
