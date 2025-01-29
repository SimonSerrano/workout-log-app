package com.marmouset.workout.app.port.out;

import java.util.UUID;

import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

public interface WorkoutLogRepositoryPort {
  Iterable<WorkoutLog> getAllLogs();

  WorkoutLog getLogDetails(UUID uuid) throws WorkoutLogNotFound;

  WorkoutLog createWorkoutLog(WorkoutLog workoutLog);

  void deleteWorkoutLog(UUID uuid);

  WorkoutLog getLogReference(UUID uuid);
}
