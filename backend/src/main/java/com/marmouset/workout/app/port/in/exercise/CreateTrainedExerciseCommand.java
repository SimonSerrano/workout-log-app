package com.marmouset.workout.app.port.in.exercise;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO to create a trained exercise in the business layer.
 *
 * @param logId      the log id
 * @param exerciseId the exercise id
 * @param sets       the sets practiced
 * @param weight     the weight used for that exercise
 */
public record CreateTrainedExerciseCommand(
    UUID logId,
    String exerciseId,
    List<Integer> sets,
    Integer weight) {

  /**
   * Creates a trained exercise command.
   *
   * @param logId      the log id
   * @param exerciseId the exercise id
   * @param sets       the optional sets
   * @param weight     the optional weight
   */
  public CreateTrainedExerciseCommand {
    Objects.requireNonNull(logId, "Log id cannot be null");
    Objects.requireNonNull(exerciseId, "Exercise id cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }

  }
}
