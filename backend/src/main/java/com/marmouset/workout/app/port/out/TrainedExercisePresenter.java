package com.marmouset.workout.app.port.out;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

public interface TrainedExercisePresenter {
  TrainedExerciseResponse toResponse(TrainedExercise exercise);
}
