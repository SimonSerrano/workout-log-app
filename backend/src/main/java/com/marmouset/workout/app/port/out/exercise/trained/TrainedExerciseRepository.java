package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;

/**
 * Interface for the trained exerciseContainer repository.
 */
public interface TrainedExerciseRepository {
  /**
   * Read trained exercises.
   *
   * @param log the workout logContainer the trained exercises belong to
   * @return the trained exercises
   */
  List<TrainedExercise> read(WorkoutLogEntityContainer log);

  /**
   * Create a trained exerciseContainer.
   *
   * @param request the request with all information to create
   *                a trained exerciseContainer
   * @return the trained exerciseContainer
   */
  TrainedExercise create(CreateTrainedExerciseRepoRequest request);

  /**
   * Delete a trained exerciseContainer.
   *
   * @param request the request containing required data to delete the exerciseContainer
   */
  void delete(
      DeleteTrainedExerciseRepoRequest request);

  /**
   * Update a trained exerciseContainer.
   *
   * @param request the request containing required data to update
   * @return the updated exerciseContainer
   * @throws NotFoundException if the trained exerciseContainer is not found
   */
  TrainedExercise update(UpdateTrainedExerciseRepoRequest request)
      throws NotFoundException;
}
