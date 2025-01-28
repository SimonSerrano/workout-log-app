package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;

@Component
public class ListWorkoutLogsUseCase implements ListWorkoutLogsPort {
  private final WorkoutLogRepositoryPort workoutLogRepository;

  public ListWorkoutLogsUseCase(WorkoutLogRepositoryPort workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public Iterable<WorkoutLogListElementResponse> listWorkouts() {
    return workoutLogRepository.getAllLogs();
  }
}
