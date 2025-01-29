package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;
import com.marmouset.workout.adapter.out.mapper.WorkoutLogResponseMapper;
import com.marmouset.workout.app.port.in.GetLogDetailsPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Component
public class GetLogDetailsUseCase implements GetLogDetailsPort {
  private final WorkoutLogRepositoryPort workoutLogRepository;
  private final WorkoutLogResponseMapper mapper;

  public GetLogDetailsUseCase(WorkoutLogRepositoryPort workoutLogRepository, WorkoutLogResponseMapper mapper) {
    this.workoutLogRepository = workoutLogRepository;
    this.mapper = mapper;
  }

  @Override
  public WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound {
    return mapper.toWorkoutLogListElementDTO(workoutLogRepository.getLogDetails(uuid));
  }
}
