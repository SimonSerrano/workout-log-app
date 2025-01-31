package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;

public interface CreateTrainedExercise {
  TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFound;
}
