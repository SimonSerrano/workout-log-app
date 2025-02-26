package com.marmouset.workout.app.trainedexercise.adapter.dto;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exerciseset.adapter.dto.ExerciseSetResponse;
import java.util.List;
import java.util.UUID;

/**
 * Builder for the trained exercise response.
 */
public class TrainedExerciseResponseBuilder {
  private Long id;
  private UUID logId;
  private ExerciseResponse exercise;
  private List<ExerciseSetResponse> sets;
  private Integer weight;

  /**
   * Sets the id.
   *
   * @param id the id
   * @return this
   */
  public TrainedExerciseResponseBuilder setId(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Sets the log id.
   *
   * @param logId the log id
   * @return this.
   */
  public TrainedExerciseResponseBuilder setLogId(UUID logId) {
    this.logId = logId;
    return this;
  }

  /**
   * Sets the exercise response.
   *
   * @param exercise the exercise
   * @return this
   */
  public TrainedExerciseResponseBuilder setExercise(ExerciseResponse exercise) {
    this.exercise = exercise;
    return this;
  }

  /**
   * Sets the sets.
   *
   * @param sets the sets
   * @return this
   */
  public TrainedExerciseResponseBuilder setSets(
      List<ExerciseSetResponse> sets) {
    this.sets = sets;
    return this;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight
   * @return this
   */
  public TrainedExerciseResponseBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Builds the response.
   *
   * @return a new TrainedExerciseResponse
   */
  public TrainedExerciseResponse build() {
    return new TrainedExerciseResponse(id, logId, exercise, sets, weight);
  }
}