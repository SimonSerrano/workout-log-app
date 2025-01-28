package com.marmouset.workout.app.port.out;

import java.util.UUID;

import com.marmouset.workout.domain.exercise.Exercise;

public interface ExerciseRepositoryPort {
  Iterable<Exercise> getExercises();

  Exercise getExerciseReference(UUID id);
}
