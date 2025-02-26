package com.marmouset.workout.app.exercise.adapter.dto;

import java.util.Objects;

/**
 * Record representing the response.
 *
 * @param name its name
 */
public record ExerciseResponse(String name) {


  /**
   * Creates an ExerciseResponse.
   *
   * @param name the name of the exercise
   */
  public ExerciseResponse {
    Objects.requireNonNull(name, "Name is null");
  }
}
