package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.port.in.DeleteWorkoutLog;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Use case for the workout log deletion.
 */
@Component
public class DeleteWorkoutLogUseCase implements DeleteWorkoutLog {

  private final WorkoutLogRepository workoutLogRepository;

  /**
   * Constructor for this use case.
   *
   * @param repository the workout log repository
   */
  public DeleteWorkoutLogUseCase(WorkoutLogRepository repository) {
    this.workoutLogRepository = repository;
  }


  @Override
  public void deleteWorkoutLog(UUID uuid) {
    workoutLogRepository.deleteWorkoutLog(uuid);
  }

}
