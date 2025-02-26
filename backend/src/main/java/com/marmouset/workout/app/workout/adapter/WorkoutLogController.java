package com.marmouset.workout.app.workout.adapter;

import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import java.util.List;
import java.util.UUID;

/**
 * Interface to convert data from the web to the use cases for workout logs.
 */
public interface WorkoutLogController {

  /**
   * Creates workout logs.
   *
   * @param command the command
   * @return the workout logContainer response
   */
  WorkoutLogResponse create(CreateWorkoutLogCommand command);

  /**
   * Delete a workout logContainer.
   *
   * @param uuid the id
   */
  void delete(UUID uuid);

  /**
   * Get the details of a logContainer.
   *
   * @param uuid the id of the logContainer
   * @return the workout logContainer as a response
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  WorkoutLogResponse get(UUID uuid) throws WorkoutLogNotFoundException;

  /**
   * List workout logs.
   *
   * @return workout logs
   */
  List<WorkoutLogResponse> list();

  /**
   * Updates a workout logContainer.
   *
   * @param command update command
   * @return the updated workout logContainer
   */
  WorkoutLogResponse update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException;
}
