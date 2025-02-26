package com.marmouset.workout.app.trainedexercise.usecase.dto;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;

/**
 * Builder for building a request to create a trained exercise.
 */
public class CreateTrainedExerciseRepoRequestBuilder {
  private WorkoutLog log;
  private Exercise exercise;
  private List<Integer> sets;
  private Integer weight;

  /**
   * Sets the log container.
   *
   * @param log the log container
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setLog(
      WorkoutLog log) {
    this.log = log;
    return this;
  }

  /**
   * Sets the exercise container.
   *
   * @param exercise the exercise container
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setExercise(
      Exercise exercise) {
    this.exercise = exercise;
    return this;
  }

  /**
   * Sets the sets.
   *
   * @param sets the sets
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Builds the request.
   *
   * @return this
   */
  public CreateTrainedExerciseRepoRequest build() {
    return new CreateTrainedExerciseRepoRequest(
        log,
        exercise,
        sets,
        weight);
  }

}