package com.marmouset.workout.app.trainedexercise.external.spring.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

class CreateOrUpdateTrainedExerciseBody {
  @Valid
  @NotNull(message = "exerciseId cannot be null")
  @NotEmpty(message = "exerciseId cannot be empty")
  private String exerciseId;

  @Valid
  private List<Integer> sets;

  @Valid
  @Min(value = 0, message = "Weight must be > 0")
  private Integer weight;

  public String getExerciseId() {
    return exerciseId;
  }

  public CreateOrUpdateTrainedExerciseBody setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
    return this;
  }

  public Optional<List<Integer>> getSets() {
    return Optional.ofNullable(sets);
  }

  public CreateOrUpdateTrainedExerciseBody setSets(
      List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  public Optional<Integer> getWeight() {
    return Optional.ofNullable(weight);
  }

  public CreateOrUpdateTrainedExerciseBody setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }
}
