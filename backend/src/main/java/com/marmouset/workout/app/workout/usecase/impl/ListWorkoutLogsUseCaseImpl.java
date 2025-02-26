package com.marmouset.workout.app.workout.usecase.impl;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.usecase.ListWorkoutLogsUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.List;

/**
 * Use case for listing the workout logs.
 */
public class ListWorkoutLogsUseCaseImpl implements ListWorkoutLogsUseCase {
  private final WorkoutLogRepository repository;

  /**
   * Constructor for this use case.
   *
   * @param repository the workout logContainer repository
   */
  public ListWorkoutLogsUseCaseImpl(WorkoutLogRepository repository) {
    this.repository = repository;
  }


  @Override
  public List<? extends WorkoutLog> list() {
    return repository.read();
  }
}
