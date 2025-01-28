package com.marmouset.workout.app.port.in;

import com.marmouset.workout.adapter.in.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

public interface CreateTrainedExercisePort {
  TrainedExercise create(CreateTrainedExerciseCommand command);
}
