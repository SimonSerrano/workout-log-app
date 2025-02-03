package com.marmouset.workout.external.database.exercise.trained;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Composite primary key for trained exercises.
 */
@Embeddable
public class TrainedExercisePrimaryKey implements Serializable {
  @Column(nullable = false)
  private UUID workoutLogId;

  @Column(nullable = false)
  private Long trainedExerciseId;

  public TrainedExercisePrimaryKey() {
  }

  public UUID getWorkoutLogId() {
    return workoutLogId;
  }

  public TrainedExercisePrimaryKey setWorkoutLogId(UUID workoutLogId) {
    this.workoutLogId = workoutLogId;
    return this;
  }

  public Long getTrainedExerciseId() {
    return trainedExerciseId;
  }

  public TrainedExercisePrimaryKey setTrainedExerciseId(
      Long trainedExerciseId) {
    this.trainedExerciseId = trainedExerciseId;
    return this;
  }
}
