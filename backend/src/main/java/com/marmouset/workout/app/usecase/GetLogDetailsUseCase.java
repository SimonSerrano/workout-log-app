package com.marmouset.workout.app.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.GetLogDetailsPort;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Component
public class GetLogDetailsUseCase implements GetLogDetailsPort {
  private final WorkoutLogRepositoryPort workoutLogRepository;

  public GetLogDetailsUseCase(WorkoutLogRepositoryPort workoutLogRepository) {
    this.workoutLogRepository = workoutLogRepository;
  }

  @Override
  public WorkoutLog getDetails(UUID uuid) throws WorkoutLogNotFound {
    return workoutLogRepository.getLogDetails(uuid);
  }
}
