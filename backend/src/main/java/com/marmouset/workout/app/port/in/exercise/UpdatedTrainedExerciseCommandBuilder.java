package com.marmouset.workout.app.port.in.exercise;

import java.util.List;
import java.util.UUID;

public class UpdatedTrainedExerciseCommandBuilder {
  private Long trainedId;
  private UUID logId;
  private String exerciseId;
  private List<Integer> sets;
  private Integer weight;

  public UpdatedTrainedExerciseCommandBuilder setTrainedId(Long trainedId) {
    this.trainedId = trainedId;
    return this;
  }

  public UpdatedTrainedExerciseCommandBuilder setLogId(UUID logId) {
    this.logId = logId;
    return this;
  }

  public UpdatedTrainedExerciseCommandBuilder setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
    return this;
  }

  public UpdatedTrainedExerciseCommandBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  public UpdatedTrainedExerciseCommandBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  public UpdatedTrainedExerciseCommand build() {
    return new UpdatedTrainedExerciseCommand(trainedId, logId, exerciseId, sets,
        weight);
  }
}