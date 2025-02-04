package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;

/**
 * Interface for updating a trained exercise.
 */
public interface UpdateTrainedExercise {
  /**
   * Update a trained exercise.
   *
   * @param command the command containing the new information
   * @return the new trained exercise
   */
  TrainedExerciseResponse update(UpdatedTrainedExerciseCommand command)
      throws WorkoutLogNotFoundException, ExerciseNotFoundException;
}
