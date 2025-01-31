package com.marmouset.workout.app.port.in.exercise;

import java.util.UUID;

public class CreateTrainedExerciseCommand {
  private final UUID logId;
  private final UUID exerciseId;

  public CreateTrainedExerciseCommand(UUID logId, UUID exerciseId) {
    this.logId = logId;
    this.exerciseId = exerciseId;
  }

  public UUID getExerciseId() {
    return exerciseId;
  }

  public UUID getLogId() {
    return logId;
  }

}
