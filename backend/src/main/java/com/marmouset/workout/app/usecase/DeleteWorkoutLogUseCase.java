package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.DeleteWorkoutLog;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;

@Component
public class DeleteWorkoutLogUseCase implements DeleteWorkoutLog {

  private final WorkoutLogRepository workoutLogRepository;

  public DeleteWorkoutLogUseCase(WorkoutLogRepository workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public void deleteWorkoutLog(UUID uuid) {
    workoutLogRepository.deleteWorkoutLog(uuid);
  }

}
