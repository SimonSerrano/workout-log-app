package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;

/**
 * Interface for the exercise repository.
 */
public interface ExerciseRepository {
  /**
   * Read all exercises.
   *
   * @return exercises
   */
  List<Exercise> read();

  /**
   * Read an exercise only with its id populated.
   *
   * @param id the id
   * @return the exercise container
   * @throws NotFoundException if the exercise is not found
   */
  ExerciseEntityContainer readReference(String id) throws NotFoundException;

  /**
   * Creates an exercise.
   *
   * @param request the values to create an exercise
   * @return the exercise
   */
  Exercise create(CreateExerciseRepoRequest request);
}
