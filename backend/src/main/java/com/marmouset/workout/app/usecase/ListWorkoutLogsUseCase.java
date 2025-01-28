package com.marmouset.workout.app.usecase;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLogAdapter;
import com.marmouset.workout.domain.WorkoutLogListElementDTO;

@Component
public class ListWorkoutLogsUseCase implements ListWorkoutLogsPort {
  private final WorkoutLogRepositoryPort workoutLogRepository;
  private final WorkoutLogAdapter adapter;

  public ListWorkoutLogsUseCase(WorkoutLogRepositoryPort workoutLogRepository, WorkoutLogAdapter adapter) {
    this.workoutLogRepository = workoutLogRepository;
    this.adapter = adapter;
  }

  @Override
  public Iterable<WorkoutLogListElementDTO> listWorkouts() {
    return StreamSupport.stream(workoutLogRepository.getAllLogs().spliterator(), false)
        .map(adapter::toWorkoutLogListElementDTO).collect(Collectors.toList());
  }
}
