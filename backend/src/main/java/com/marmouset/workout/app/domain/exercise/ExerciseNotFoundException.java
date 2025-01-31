package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Exception when an exercise cannot be found.
 */
public class ExerciseNotFoundException extends Exception {

  /**
   * Constructs an ExerciseNotFound.
   *
   * @param id the id of the exercise
   */
  public ExerciseNotFoundException(UUID id) {
    super("The exercise of id " + id + " could not be found");
  }
}
