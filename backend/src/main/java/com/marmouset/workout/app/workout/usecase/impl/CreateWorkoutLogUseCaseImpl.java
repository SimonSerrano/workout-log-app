package com.marmouset.workout.app.workout.usecase.impl;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.usecase.CreateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogRepoRequest;

/**
 * Use case to create a workout log.
 */
public class CreateWorkoutLogUseCaseImpl implements CreateWorkoutLogUseCase {

  private final WorkoutLogRepository workoutLogRepository;

  /**
   * Creates a CreateWorkoutLogUseCaseImpl.
   *
   * @param workoutLogRepository the repository
   */
  public CreateWorkoutLogUseCaseImpl(
      WorkoutLogRepository workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public WorkoutLog create(CreateWorkoutLogCommand command) {
    return workoutLogRepository
        .create(new CreateWorkoutLogRepoRequest(command.name()));
  }

}
