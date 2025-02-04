package com.marmouset.workout.external.web.exercise.trained;

import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class CreateOrUpdateTrainedExerciseBody {
  @Valid
  private UUID exerciseId;

  public UUID getExerciseId() {
    return exerciseId;
  }

  public CreateOrUpdateTrainedExerciseBody setExerciseId(UUID exerciseId) {
    this.exerciseId = exerciseId;
    return this;
  }
}
