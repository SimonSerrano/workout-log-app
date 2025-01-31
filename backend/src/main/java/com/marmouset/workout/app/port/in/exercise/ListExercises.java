package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;

public interface ListExercises {
  Iterable<ExerciseResponse> listExercises();
}
