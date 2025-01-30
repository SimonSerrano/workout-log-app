package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.port.out.dto.ExerciseResponse;

public interface ListExercises {
  Iterable<ExerciseResponse> listExercises();
}
