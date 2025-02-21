package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import java.util.List;

public class UpdateTrainedExerciseRepoRequestBuilder {
  private Long trainedId;
  private ExerciseEntityContainer exerciseContainer;
  private List<Integer> sets;
  private Integer weight;

  public UpdateTrainedExerciseRepoRequestBuilder setTrainedId(Long trainedId) {
    this.trainedId = trainedId;
    return this;
  }

  public UpdateTrainedExerciseRepoRequestBuilder setExerciseContainer(
      ExerciseEntityContainer exerciseContainer) {
    this.exerciseContainer = exerciseContainer;
    return this;
  }

  public UpdateTrainedExerciseRepoRequestBuilder setSets(List<Integer> sets) {
    this.sets = sets;
    return this;
  }

  public UpdateTrainedExerciseRepoRequestBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  public UpdateTrainedExerciseRepoRequest build() {
    return new UpdateTrainedExerciseRepoRequest(trainedId, exerciseContainer,
        sets, weight);
  }
}