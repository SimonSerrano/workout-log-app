package com.marmouset.workout.app.exerciseset.adapter.dto;

import java.util.Objects;

/**
 * Record for the exerciseContainer set.
 *
 * @param id   set id
 * @param reps number of repetition
 */
public record ExerciseSetResponse(Long id, Integer reps) {

  /**
   * Creates an ExerciseSetResponse.
   *
   * @param id   the id
   * @param reps the reps
   */
  public ExerciseSetResponse {
    Objects.requireNonNull(id, "id cannot be null");
    Objects.requireNonNull(reps, "reps cannot be null");
  }
}
