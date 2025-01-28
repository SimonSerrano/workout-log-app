package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.in.CreateWorkoutLogPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;

@Component
public class CreateWorkoutLogUseCase implements CreateWorkoutLogPort {

  private final WorkoutLogRepositoryPort workoutLogRepository;

  public CreateWorkoutLogUseCase(WorkoutLogRepositoryPort workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public WorkoutLog createWorkoutLog(CreateWorkoutLogCommand command) {
    return workoutLogRepository.createWorkoutLog(new WorkoutLog(command.getTitle()));
  }

}
