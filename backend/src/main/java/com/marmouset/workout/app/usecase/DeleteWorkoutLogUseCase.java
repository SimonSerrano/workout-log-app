package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.port.in.workout.DeleteWorkoutLog;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
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
