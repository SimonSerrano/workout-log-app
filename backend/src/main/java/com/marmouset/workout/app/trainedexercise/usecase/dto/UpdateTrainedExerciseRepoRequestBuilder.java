package com.marmouset.workout.app.trainedexercise.usecase.dto;

import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.List;

/**
 * Builder to create an update trained exercise repo request.
 */
public class UpdateTrainedExerciseRepoRequestBuilder {
  private Long trainedId;
  private Exercise exercise;
  private List<Integer> sets;
  private Integer weight;

  /**
   * Sets the trained id.
   *
   * @param trainedId the trained id
   * @return this.
   */
  public UpdateTrainedExerciseRepoRequestBuilder setTrainedId(Long trainedId) {
    this.trainedId = trainedId;
    return this;
  }

  /**
   * Sets the exercise.
   *
   * @param exercise the exercise
   * @return this
   */
  public UpdateTrainedExerciseRepoRequestBuilder setExercise(
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
  public UpdateTrainedExerciseRepoRequestBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight
   * @return this
   */
  public UpdateTrainedExerciseRepoRequestBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Builds the request.
   *
   * @return the newly built request
   */
  public UpdateTrainedExerciseRepoRequest build() {
    return new UpdateTrainedExerciseRepoRequest(trainedId, exercise,
        sets, weight);
  }
}