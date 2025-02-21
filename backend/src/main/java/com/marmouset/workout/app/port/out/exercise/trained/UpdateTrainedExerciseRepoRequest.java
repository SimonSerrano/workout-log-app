package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * DTO to update a trained exercise.
 *
 * @param trainedId         the trained exercise id
 * @param exerciseContainer the exercise container with the exercise trained
 * @param sets              the repetitions
 * @param weight            the weight
 */
public record UpdateTrainedExerciseRepoRequest(
    Long trainedId,
    ExerciseEntityContainer exerciseContainer,
    List<Integer> sets,
    Integer weight) {

  /**
   * Constructs a UpdateTrainedExerciseRepoRequest.
   *
   * @param trainedId         the trained exercise id
   * @param exerciseContainer the exercise container with the exercise trained
   * @param sets              the repetitions
   * @param weight            the weight
   */
  public UpdateTrainedExerciseRepoRequest {
    Objects.requireNonNull(trainedId, "Trained exercise id cannot be null");
    Objects.requireNonNull(exerciseContainer,
        "Exercise container cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }

  }
}
