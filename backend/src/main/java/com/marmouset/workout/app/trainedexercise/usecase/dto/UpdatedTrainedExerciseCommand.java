package com.marmouset.workout.app.trainedexercise.usecase.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for updating a trained exerciseContainer.
 *
 * @param trainedId  the trained exerciseContainer id
 * @param logId      the logContainer id
 * @param exerciseId the new exerciseContainer id
 * @param sets       the number of repetitions during that set
 * @param weight     the weight of the exercise
 */
public record UpdatedTrainedExerciseCommand(
    Long trainedId,
    UUID logId,
    String exerciseId,
    List<Integer> sets,
    Integer weight) {

  /**
   * Creates a UpdatedTrainedExerciseCommand.
   *
   * @param trainedId  the trained exercise id
   * @param logId      the log id
   * @param exerciseId the exercise id
   * @param sets       the sets
   * @param weight     the weight of the exercise
   */
  public UpdatedTrainedExerciseCommand {
    Objects.requireNonNull(trainedId, "Trained exercise id cannot be null");
    Objects.requireNonNull(logId, "Log id cannot be null");
    Objects.requireNonNull(exerciseId, "Exercise id cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }
  }
}
