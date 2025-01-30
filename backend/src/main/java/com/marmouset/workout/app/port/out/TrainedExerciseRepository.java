package com.marmouset.workout.app.port.out;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.dto.CreateTrainedExerciseRepoRequest;

public interface TrainedExerciseRepository {
  Iterable<TrainedExercise> getTrainedExercises(WorkoutLog log);

  TrainedExercise createTrainedExercise(CreateTrainedExerciseRepoRequest request);
}
