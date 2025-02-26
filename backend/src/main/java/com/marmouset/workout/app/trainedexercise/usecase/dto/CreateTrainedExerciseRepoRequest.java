package com.marmouset.workout.app.trainedexercise.usecase.dto;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Request to create a trained exercise in a repository.
 *
 * @param log      the workout log container with
 *                 the log entity to associate with
 * @param exercise the exerciseContainer container
 *                 with the exerciseContainer entity to associate with
 * @param sets     the sets practiced
 * @param weight   the weight practiced during that exercise
 */
public record CreateTrainedExerciseRepoRequest(
    WorkoutLog log,
    Exercise exercise,
    List<Integer> sets,
    Integer weight) {

  /**
   * Creates a request for creating a trained exercise.
   *
   * @param log      the log container
   * @param exercise the exercise container
   * @param sets     the sets
   * @param weight   the weight
   */
  public CreateTrainedExerciseRepoRequest {
    Objects.requireNonNull(log, "Log container cannot be null");
    Objects.requireNonNull(exercise,
        "Exercise container cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }
  }


}
