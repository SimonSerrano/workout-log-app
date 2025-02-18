package com.marmouset.workout.external.web.exercise.trained;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class CreateOrUpdateTrainedExerciseBody {
  @Valid
  private UUID exerciseId;

  @Valid
  private List<Integer> sets;

  public UUID getExerciseId() {
    return exerciseId;
  }

  public CreateOrUpdateTrainedExerciseBody setExerciseId(UUID exerciseId) {
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
