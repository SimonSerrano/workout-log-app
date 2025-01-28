package com.marmouset.workout.app.port.out;

import java.util.UUID;

import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public interface TrainedExerciseRepositoryPort {
  Iterable<TrainedExercise> getTrainedExercises(UUID logId);

  TrainedExercise createTrainedExercise(TrainedExercise exercise);
}
