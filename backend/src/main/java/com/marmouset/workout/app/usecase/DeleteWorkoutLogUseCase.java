package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.DeleteWorkoutLogPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;

@Component
public class DeleteWorkoutLogUseCase implements DeleteWorkoutLogPort {

  private final WorkoutLogRepositoryPort workoutLogRepository;

  public DeleteWorkoutLogUseCase(WorkoutLogRepositoryPort workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public void deleteWorkoutLog(UUID uuid) {
    workoutLogRepository.deleteWorkoutLog(uuid);
  }

}
