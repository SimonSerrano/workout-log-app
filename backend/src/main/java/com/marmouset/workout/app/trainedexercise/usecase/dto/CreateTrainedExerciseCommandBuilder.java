package com.marmouset.workout.app.trainedexercise.usecase.dto;

import java.util.List;
import java.util.UUID;

/**
 * Builder to build a command to create a trained exercise.
 */
public class CreateTrainedExerciseCommandBuilder {
  private UUID logId;
  private String exerciseId;
  private List<Integer> sets;
  private Integer weight;

  /**
   * Sets the logId.
   *
   * @param logId the log id
   * @return this
   */
  public CreateTrainedExerciseCommandBuilder setLogId(UUID logId) {
    this.logId = logId;
    return this;
  }

  /**
   * Sets the exercise id.
   *
   * @param exerciseId the exercise id
   * @return this
   */
  public CreateTrainedExerciseCommandBuilder setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
    return this;
  }

  /**
   * Sets the sets.
   *
   * @param sets the sets
   * @return this
   */
  public CreateTrainedExerciseCommandBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight
   * @return this
   */
  public CreateTrainedExerciseCommandBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Build the command.
   *
   * @return a new CreateTrainedExerciseCommand
   */
  public CreateTrainedExerciseCommand build() {
    return new CreateTrainedExerciseCommand(logId, exerciseId, sets, weight);
  }
}