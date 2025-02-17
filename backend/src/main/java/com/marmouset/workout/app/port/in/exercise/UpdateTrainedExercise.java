package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;

/**
 * Interface for updating a trained exerciseContainer.
 */
public interface UpdateTrainedExercise {
  /**
   * Update a trained exerciseContainer.
   *
   * @param command the command containing the new information
   * @return the new trained exerciseContainer
   */
  TrainedExerciseResponse update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException;
}
