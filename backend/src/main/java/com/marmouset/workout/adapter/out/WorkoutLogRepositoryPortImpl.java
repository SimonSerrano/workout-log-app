package com.marmouset.workout.adapter.out;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.adapter.out.mapper.WorkoutLogResponseMapper;
import com.marmouset.workout.adapter.out.persistence.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Repository
public class WorkoutLogRepositoryPortImpl implements WorkoutLogRepositoryPort {

  private final WorkoutLogRepository repository;
  private final WorkoutLogResponseMapper mapper;

  public WorkoutLogRepositoryPortImpl(WorkoutLogRepository repository, WorkoutLogResponseMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;

    createWorkoutLog(new WorkoutLog("Toto"));
    createWorkoutLog(new WorkoutLog("Titi"));
  }

  @Override
  public Iterable<WorkoutLogListElementResponse> getAllLogs() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(mapper::toWorkoutLogListElementDTO).collect(Collectors.toList());
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
