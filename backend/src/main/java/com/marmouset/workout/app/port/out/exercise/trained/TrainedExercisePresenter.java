package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;

public interface TrainedExercisePresenter {
  TrainedExerciseResponse toResponse(TrainedExercise exercise);
}
