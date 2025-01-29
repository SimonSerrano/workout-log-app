package com.marmouset.workout.app.port.out;

import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public interface TrainedExerciseRepositoryPort {
  Iterable<TrainedExercise> getTrainedExercises(WorkoutLog log);

  TrainedExercise createTrainedExercise(TrainedExercise exercise);
}
