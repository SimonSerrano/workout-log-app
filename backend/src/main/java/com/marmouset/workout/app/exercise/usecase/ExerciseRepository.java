package com.marmouset.workout.app.exercise.usecase;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.usecase.dto.CreateExerciseRepoRequest;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
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
  List<? extends Exercise> read();

  /**
   * Reads an exercise by its id.
   *
   * @param id the id
   * @return the exercise
   * @throws NotFoundException if the exercise cannot be found
   */
  Exercise read(String id) throws NotFoundException;

  /**
   * Read an exercise only with its id populated.
   *
   * @param id the id
   * @return the exercise container
   * @throws NotFoundException if the exercise is not found
   */
  Exercise readReference(String id) throws NotFoundException;

  /**
   * Creates an exercise.
   *
   * @param request the values to create an exercise
   * @return the exercise
   */
  Exercise create(CreateExerciseRepoRequest request);
}
