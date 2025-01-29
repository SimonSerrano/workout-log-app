package com.marmouset.workout.app.usecase;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;
import com.marmouset.workout.adapter.out.mapper.WorkoutLogResponseMapper;
import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;

@Component
public class ListWorkoutLogsUseCase implements ListWorkoutLogsPort {
  private final WorkoutLogRepositoryPort workoutLogRepository;
  private final WorkoutLogResponseMapper mapper;

  public ListWorkoutLogsUseCase(WorkoutLogRepositoryPort workoutLogRepository, WorkoutLogResponseMapper mapper) {
    this.workoutLogRepository = workoutLogRepository;
    this.mapper = mapper;
  }

  @Override
  public Iterable<WorkoutLogResponse> listWorkouts() {
    return StreamSupport.stream(workoutLogRepository.getAllLogs().spliterator(), false)
        .map(mapper::toWorkoutLogListElementDTO).collect(Collectors.toList());
  }
}
