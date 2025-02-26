package com.marmouset.workout.app.trainedexercise.adapter;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.trainedexercise.adapter.dto.TrainedExerciseResponse;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Interface to convert data from the web to data for use cases.
 */
public interface TrainedExerciseController {
  /**
   * Create a trained exerciseContainer.
   *
   * @param command the command containing data to create trained exercises
   * @return the trained exerciseContainer response
   * @throws ExerciseNotFoundException   if the exerciseContainer is not found
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException;

  /**
   * Deletes a trained exerciseContainer.
   *
   * @param logId     the id of the workout logContainer
   * @param trainedId the id of the exerciseContainer to delete
   */
  void delete(UUID logId, Long trainedId) throws WorkoutLogNotFoundException;

  /**
   * List trained exercises.
   *
   * @param logId the id of the logContainer
   * @return the trained exercises
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  List<TrainedExerciseResponse> list(UUID logId) throws
      WorkoutLogNotFoundException;

  /**
   * Update a trained exerciseContainer.
   *
   * @param command the command containing the new information
   * @return the new trained exerciseContainer
   */
  TrainedExerciseResponse update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException;
}
