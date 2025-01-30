package com.marmouset.workout.app.port.out;

import java.util.UUID;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.dto.CreateExerciseRepoRequest;

public interface ExerciseRepository {
  Iterable<Exercise> getExercises();

  Exercise getExerciseReference(UUID id);

  Exercise createExercise(CreateExerciseRepoRequest request);
}
