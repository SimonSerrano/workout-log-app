package com.marmouset.workout.app.port.out;

import com.marmouset.workout.domain.exercise.Exercise;

public interface ExerciseRepositoryPort {
  Iterable<Exercise> getExercises();
}
