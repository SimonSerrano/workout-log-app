package com.marmouset.workout.adapter.out;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.adapter.out.mapper.WorkoutLogResponseMapper;
import com.marmouset.workout.adapter.out.persistence.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.WorkoutLogRepositoryPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@Repository
public class WorkoutLogRepositoryImpl implements WorkoutLogRepositoryPort {

  private final WorkoutLogRepository repository;
  private final WorkoutLogResponseMapper mapper;

  public WorkoutLogRepositoryImpl(@Lazy WorkoutLogRepository repository, WorkoutLogResponseMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
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
  public WorkoutLog createWorkoutLog(CreateWorkoutLogCommand command) {
    return repository.save(new WorkoutLog(command.getTitle()));
  }

  @Override
  public void deleteWorkoutLog(UUID uuid) {
    repository.deleteById(uuid);
  }

}
