package com.marmouset.workout.app.port.out;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.dto.CreateExerciseRepoRequest;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.UUID;

public interface ExerciseRepository {
  Iterable<Exercise> getExercises();

  Exercise getExerciseReference(UUID id) throws NotFoundException;

  Exercise createExercise(CreateExerciseRepoRequest request);
}
