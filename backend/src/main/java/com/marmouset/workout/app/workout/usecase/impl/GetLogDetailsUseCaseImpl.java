package com.marmouset.workout.app.workout.usecase.impl;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.GetLogDetailsUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;

/**
 * Use case to get the log details.
 */
public class GetLogDetailsUseCaseImpl implements GetLogDetailsUseCase {
  private final WorkoutLogRepository workoutLogRepository;

  /**
   * Creates a GetLogDetailsUseCaseImpl.
   *
   * @param workoutLogRepository the repository
   */
  public GetLogDetailsUseCaseImpl(WorkoutLogRepository workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public WorkoutLog get(UUID uuid) throws
      WorkoutLogNotFoundException {
    try {
      return workoutLogRepository.read(uuid);
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(uuid);
    }
  }
}
