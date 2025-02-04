package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;

/**
 * Interface for the trained exercise repository.
 */
public interface TrainedExerciseRepository {
  /**
   * Read trained exercises.
   *
   * @param log the workout log the trained exercises belong to
   * @return the trained exercises
   */
  List<TrainedExercise> read(WorkoutLog log);

  /**
   * Create a trained exercise.
   *
   * @param request the request with all information to create
   *                a trained exercise
   * @return the trained exercise
   */
  TrainedExercise create(CreateTrainedExerciseRepoRequest request);

  /**
   * Delete a trained exercise.
   *
   * @param request the request containing required data to delete the exercise
   */
  void delete(
      DeleteTrainedExerciseRepoRequest request);

  /**
   * Update a trained exercise.
   *
   * @param request the request containing required data to update
   * @return the updated exercise
   * @throws NotFoundException if the trained exercise is not found
   */
  TrainedExercise update(UpdateTrainedExerciseRepoRequest request)
      throws NotFoundException;
}
