package com.marmouset.workout.app.trainedexercise.usecase;

import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for listing trained exercises use case.
 */
public interface ListTrainedExercisesUseCase {
  /**
   * List trained exercises.
   *
   * @param logId the id of the logContainer
   * @return the trained exercises
   * @throws WorkoutLogNotFoundException if the log is not found
   */
  List<? extends TrainedExercise> list(UUID logId) throws
      WorkoutLogNotFoundException;
}
