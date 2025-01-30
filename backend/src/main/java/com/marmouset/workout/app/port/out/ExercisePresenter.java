package com.marmouset.workout.app.port.out;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.dto.ExerciseResponse;

public interface ExercisePresenter {
  ExerciseResponse prepareResponse(Exercise exercise);
}
