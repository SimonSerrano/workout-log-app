package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;
import com.marmouset.workout.adapter.out.mapper.WorkoutLogResponseMapper;
import com.marmouset.workout.app.port.in.CreateWorkoutLogPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;

@Component
public class CreateWorkoutLogUseCase implements CreateWorkoutLogPort {

  private final WorkoutLogRepositoryPort workoutLogRepository;
  private final WorkoutLogResponseMapper mapper;

  public CreateWorkoutLogUseCase(WorkoutLogRepositoryPort workoutLogRepository, WorkoutLogResponseMapper mapper) {
    this.workoutLogRepository = workoutLogRepository;
    this.mapper = mapper;
  }

  @Override
  public WorkoutLogResponse createWorkoutLog(CreateWorkoutLogCommand command) {
    return mapper.toWorkoutLogListElementDTO(workoutLogRepository.createWorkoutLog(new WorkoutLog(command.getTitle())));
  }

}
