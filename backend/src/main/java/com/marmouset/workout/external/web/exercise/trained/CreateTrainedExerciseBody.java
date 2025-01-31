package com.marmouset.workout.external.web.exercise.trained;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreateTrainedExerciseBody {
  @org.hibernate.validator.constraints.UUID
  private UUID exerciseId;

  public UUID getExerciseId() {
    return exerciseId;
  }

}
