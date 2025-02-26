package com.marmouset.workout.app.exercise.usecase.dto;

import java.util.Objects;

/**
 * Record to create an exerciseContainer in a repo.
 *
 * @param name the name of the exerciseContainer
 */
public record CreateExerciseRepoRequest(String name) {

  public CreateExerciseRepoRequest {
    Objects.requireNonNull(name, "Name is null");
  }
}
