package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.port.in.DeleteWorkoutLog;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class DeleteWorkoutLogUseCase implements DeleteWorkoutLog {

  private final WorkoutLogRepository repository;

  public DeleteWorkoutLogUseCase(WorkoutLogRepository repository) {
    this.repository = repository;
  }


  @Override
  public void deleteWorkoutLog(UUID uuid) {
    repository.deleteWorkoutLog(uuid);
  }

}
