package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Request to create a trained exercise in a repository.
 *
 * @param logContainer      the workout log container with
 *                          the log entity to associate with
 * @param exerciseContainer the exerciseContainer container
 *                          with the exerciseContainer entity to associate with
 * @param sets              the sets practiced
 * @param weight            the weight practiced during that exercise
 */
public record CreateTrainedExerciseRepoRequest(
    WorkoutLogEntityContainer logContainer,
    ExerciseEntityContainer exerciseContainer,
    List<Integer> sets,
    Integer weight) {

  /**
   * Creates a request for creating a trained exercise.
   *
   * @param logContainer      the log container
   * @param exerciseContainer the exercise container
   * @param sets              the sets
   * @param weight            the weight
   */
  public CreateTrainedExerciseRepoRequest {
    Objects.requireNonNull(logContainer, "Log container cannot be null");
    Objects.requireNonNull(exerciseContainer,
        "Exercise container cannot be null");
    if (Objects.isNull(sets)) {
      sets = Collections.emptyList();
    }
  }


}
