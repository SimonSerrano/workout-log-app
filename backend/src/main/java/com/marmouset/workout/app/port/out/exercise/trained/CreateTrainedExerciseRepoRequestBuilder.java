package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import java.util.List;

/**
 * Builder for building a request to create a trained exercise.
 */
public class CreateTrainedExerciseRepoRequestBuilder {
  private WorkoutLogEntityContainer logContainer;
  private ExerciseEntityContainer exerciseContainer;
  private List<Integer> sets;
  private Integer weight;

  /**
   * Sets the log container.
   *
   * @param logContainer the log container
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setLogContainer(
      WorkoutLogEntityContainer logContainer) {
    this.logContainer = logContainer;
    return this;
  }

  /**
   * Sets the exercise container.
   *
   * @param exerciseContainer the exercise container
   * @return this
   */
  public CreateTrainedExerciseRepoRequestBuilder setExerciseContainer(
      ExerciseEntityContainer exerciseContainer) {
    this.exerciseContainer = exerciseContainer;
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
        logContainer,
        exerciseContainer,
        sets,
        weight);
  }

}