package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.List;
import java.util.UUID;

public class TrainedExerciseResponseBuilder {
  private Long id;
  private UUID logId;
  private ExerciseResponse exercise;
  private List<ExerciseSetResponse> sets;
  private Integer weight;

  public TrainedExerciseResponseBuilder setId(Long id) {
    this.id = id;
    return this;
  }

  public TrainedExerciseResponseBuilder setLogId(UUID logId) {
    this.logId = logId;
    return this;
  }

  public TrainedExerciseResponseBuilder setExercise(ExerciseResponse exercise) {
    this.exercise = exercise;
    return this;
  }

  public TrainedExerciseResponseBuilder setSets(
      List<ExerciseSetResponse> sets) {
    this.sets = sets;
    return this;
  }

  public TrainedExerciseResponseBuilder setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  public TrainedExerciseResponse build() {
    return new TrainedExerciseResponse(id, logId, exercise, sets, weight);
  }
}