package com.marmouset.workout.app.port.in;

import com.marmouset.workout.domain.exercise.Exercise;

public interface ListExercisesPort {
  Iterable<Exercise> listExercises();
}
