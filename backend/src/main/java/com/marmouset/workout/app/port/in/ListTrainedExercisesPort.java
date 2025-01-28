package com.marmouset.workout.app.port.in;

import java.util.UUID;

import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public interface ListTrainedExercisesPort {
  Iterable<TrainedExercise> listTrainedExercises(UUID logId);
}
