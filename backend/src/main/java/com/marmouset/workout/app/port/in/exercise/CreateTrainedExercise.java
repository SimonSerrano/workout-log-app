package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;

/**
 * Interface for creating trained exercises use case.
 */
public interface CreateTrainedExercise {
  /**
   * Create a trained exercise.
   *
   * @param command the command containing data to create trained exercises
   * @return the trained exercise response
   * @throws ExerciseNotFoundException   if the exercise is not found
   * @throws WorkoutLogNotFoundException if the log is not found
   */
  TrainedExerciseResponse create(CreateTrainedExerciseCommand command)
      throws ExerciseNotFoundException, WorkoutLogNotFoundException;
}
