package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import java.util.List;
import java.util.UUID;

/**
 * Interface for listing trained exercises use case.
 */
public interface ListTrainedExercises {
  /**
   * List trained exercises.
   *
   * @param logId the id of the logContainer
   * @return the trained exercises
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  List<TrainedExerciseResponse> list(UUID logId) throws
      WorkoutLogNotFoundException;
}
