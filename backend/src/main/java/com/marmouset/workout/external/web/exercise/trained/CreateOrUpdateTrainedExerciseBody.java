package com.marmouset.workout.external.web.exercise.trained;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class CreateOrUpdateTrainedExerciseBody {
  @Valid
  @NotNull
  @NotEmpty
  private String exerciseId;

  @Valid
  private List<Integer> sets;

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
}
