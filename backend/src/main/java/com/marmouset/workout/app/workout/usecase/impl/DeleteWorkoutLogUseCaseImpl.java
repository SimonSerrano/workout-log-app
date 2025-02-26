package com.marmouset.workout.app.workout.usecase.impl;

import com.marmouset.workout.app.workout.usecase.DeleteWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import java.util.UUID;

/**
 * Use case to delete a workout log.
 */
public class DeleteWorkoutLogUseCaseImpl implements DeleteWorkoutLogUseCase {

  private final WorkoutLogRepository repository;

  /**
   * Creates a DeleteWorkoutLogUseCaseImpl.
   *
   * @param repository the repository
   */
  public DeleteWorkoutLogUseCaseImpl(WorkoutLogRepository repository) {
    this.repository = repository;
  }


  @Override
  public void delete(UUID uuid) {
    repository.delete(uuid);
  }

}
