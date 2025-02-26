package com.marmouset.workout.app.workout.usecase.impl;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.UpdateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogRepoRequest;

/**
 * Use case to update a workout log.
 */
public class UpdateWorkoutLogUseCaseImpl implements UpdateWorkoutLogUseCase {

  private final WorkoutLogRepository repository;

  /**
   * Creates a UpdateWorkoutLogUseCaseImpl.
   *
   * @param repository the repository
   */
  public UpdateWorkoutLogUseCaseImpl(WorkoutLogRepository repository) {
    this.repository = repository;
  }

  @Override
  public WorkoutLog update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException {
    try {
      return repository.update(
          new UpdateWorkoutLogRepoRequest(command.id(), command.name()));
    } catch (NotFoundException e) {
      throw new WorkoutLogNotFoundException(command.id());
    }
  }
}
