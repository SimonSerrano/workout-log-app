package com.marmouset.workout.app.port.in.exercise;

import java.util.List;
import java.util.UUID;

/**
 * Builder for building a command to update a trained exercise.
 */
public class UpdatedTrainedExerciseCommandBuilder {
  private Long trainedId;
  private UUID logId;
  private String exerciseId;
  private List<Integer> sets;
  private Integer weight;

  /**
   * Sets the trained exercise id.
   *
   * @param trainedId the trained exercise id
   * @return this
   */
  public UpdatedTrainedExerciseCommandBuilder setTrainedId(Long trainedId) {
    this.trainedId = trainedId;
    return this;
  }

  /**
   * Sets the log id.
   *
   * @param logId the log id
   * @return this
   */
  public UpdatedTrainedExerciseCommandBuilder setLogId(UUID logId) {
    this.logId = logId;
    return this;
  }

  /**
   * Sets the exercise id.
   *
   * @param exerciseId the exercise id
   * @return this
   */
  public UpdatedTrainedExerciseCommandBuilder setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
    return this;
  }

  /**
   * Sets the sets.
   *
   * @param sets the sets
   * @return this
   */
  public UpdatedTrainedExerciseCommandBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight
   * @return this
   */
  public UpdatedTrainedExerciseCommandBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Builds the command.
   *
   * @return the new UpdatedTrainedExerciseCommand
   */
  public UpdatedTrainedExerciseCommand build() {
    return new UpdatedTrainedExerciseCommand(trainedId, logId, exerciseId, sets,
        weight);
  }
}