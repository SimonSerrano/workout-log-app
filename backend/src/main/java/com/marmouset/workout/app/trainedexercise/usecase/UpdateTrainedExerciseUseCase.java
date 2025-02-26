package com.marmouset.workout.app.trainedexercise.usecase;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.dto.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;

/**
 * Interface for updating a trained exerciseContainer.
 */
public interface UpdateTrainedExerciseUseCase {
  /**
   * Update a trained exerciseContainer.
   *
   * @param command the command containing the new information
   * @return the new trained exercise
   */
  TrainedExercise update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException;
}
