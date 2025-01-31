package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFound;
import com.marmouset.workout.app.port.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

public interface CreateTrainedExercise {
  TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFound;
}
