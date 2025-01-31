package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;

public interface ExercisePresenter {
  ExerciseResponse prepareResponse(Exercise exercise);
}
