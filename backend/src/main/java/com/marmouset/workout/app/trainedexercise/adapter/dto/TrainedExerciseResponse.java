package com.marmouset.workout.app.trainedexercise.adapter.dto;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Response for the trained exerciseContainer.
 *
 * @param id       the id
 * @param logId    the workout logContainer id
 * @param exercise the trained exerciseContainer
 * @param sets     the sets for that exerciseContainer
 * @param weight   the optional weight
 */
public record TrainedExerciseResponse(Long id, UUID logId,
                                      ExerciseResponse exercise,
                                      List<ExerciseSetResponse> sets,
                                      Integer weight) {

  /**
   * Creates a TrainedExerciseResponse.
   *
   * @param id       the trained exercise id
   * @param logId    the workout log id
   * @param exercise the exercise
   * @param sets     the sets
   * @param weight   the weight
   */
  public TrainedExerciseResponse {
    Objects.requireNonNull(id, "Id cannot be null");
    Objects.requireNonNull(logId, "Log id cannot be null");
    Objects.requireNonNull(exercise, "Exercise response cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }
  }
}
