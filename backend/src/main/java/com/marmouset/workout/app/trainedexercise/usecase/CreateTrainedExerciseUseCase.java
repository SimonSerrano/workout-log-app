package com.marmouset.workout.app.trainedexercise.usecase;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.usecase.dto.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;

/**
 * Interface for creating trained exercises use case.
 */
public interface CreateTrainedExerciseUseCase {
  /**
   * Create a trained exerciseContainer.
   *
   * @param command the command containing data to create trained exercises
   * @return the trained exerciseContainer response
   * @throws ExerciseNotFoundException   if the exerciseContainer is not found
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  TrainedExercise create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException;
}
