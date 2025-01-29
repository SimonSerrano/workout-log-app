package com.marmouset.workout.adapter.out;

import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.out.persistence.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Repository
public class WorkoutLogRepositoryPortImpl implements WorkoutLogRepositoryPort {

  private final WorkoutLogRepository repository;

  public WorkoutLogRepositoryPortImpl(WorkoutLogRepository repository) {
    this.repository = repository;

    createWorkoutLog(new WorkoutLog("Toto"));
    createWorkoutLog(new WorkoutLog("Titi"));
  }

  @Override
  public Iterable<WorkoutLog> getAllLogs() {
    return repository.findAll();
  }

  @Override
  public WorkoutLog getLogDetails(UUID uuid) throws WorkoutLogNotFound {
    return repository.findById(uuid).orElseThrow(() -> new WorkoutLogNotFound(uuid));
  }

  @Override
  public WorkoutLog createWorkoutLog(WorkoutLog workoutLog) {
    return repository.save(workoutLog);
  }

  @Override
  public void deleteWorkoutLog(UUID uuid) {
    repository.deleteById(uuid);
  }

  @Override
  public WorkoutLog getLogReference(UUID uuid) {
    return repository.getReferenceById(uuid);
  }

}
