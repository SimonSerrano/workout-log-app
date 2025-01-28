package com.marmouset.workout.adapter.out;

import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.out.persistence.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Repository
public class WorkoutLogRepositoryImpl implements WorkoutLogRepositoryPort {

  private final WorkoutLogRepository repository;

  public WorkoutLogRepositoryImpl(@Lazy WorkoutLogRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<WorkoutLog> getAllLogs() {
    return repository.findAll();
  }

  @Override
  public WorkoutLog getLogDetails(UUID uuid) throws WorkoutLogNotFound {
    return repository.findById(uuid).orElseThrow(() -> new WorkoutLogNotFound(uuid));
  }

}
