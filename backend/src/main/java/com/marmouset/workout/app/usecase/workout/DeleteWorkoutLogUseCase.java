package com.marmouset.workout.app.usecase.workout;

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
  public void delete(UUID uuid) {
    repository.delete(uuid);
  }

}
