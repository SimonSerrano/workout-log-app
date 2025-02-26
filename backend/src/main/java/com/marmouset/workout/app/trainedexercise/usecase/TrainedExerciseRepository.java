package com.marmouset.workout.app.trainedexercise.usecase;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.DeleteTrainedExerciseRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
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
  List<? extends TrainedExercise> read(WorkoutLog log);

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
   * @param request the request containing required data to delete the exercise
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

  /**
   * Get the trained exercise by an exercise.
   *
   * @param request the request containing required data
   * @return a list of trained exercises
   */
  List<TrainedExercise> getTrainedExerciseByExerciseId(
      GetTrainedExerciseByExerciseIdRepoRequest request);
}
