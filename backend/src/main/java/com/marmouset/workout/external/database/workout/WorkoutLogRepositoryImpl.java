package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.CreateWorkoutLogRepoRequest;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
class WorkoutLogRepositoryImpl implements WorkoutLogRepository {

  private final JpaWorkoutLogRepository repository;
  private final WorkoutLogMapper mapper;

  public WorkoutLogRepositoryImpl(JpaWorkoutLogRepository repository,
                                  WorkoutLogMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;

    createWorkoutLog(new CreateWorkoutLogRepoRequest("Toto"));
    createWorkoutLog(new CreateWorkoutLogRepoRequest("Titi"));
  }

  @Override
  public Iterable<WorkoutLog> getAllLogs() {
    return repository.findAll().stream().map(mapper::toWorkoutLog).toList();
  }

  @Override
  public WorkoutLog getLogDetails(UUID uuid) throws WorkoutLogNotFound {
    return mapper.toWorkoutLog(
        repository
            .findById(uuid)
            .orElseThrow(() -> new WorkoutLogNotFound(uuid)));
  }

  @Override
  public WorkoutLog createWorkoutLog(CreateWorkoutLogRepoRequest request) {
    var workoutLog = new WorkoutLogEntity(request.name());
    return mapper.toWorkoutLog(repository.save(workoutLog));
  }

  @Override
  public void deleteWorkoutLog(UUID uuid) {
    repository.deleteById(uuid);
  }

  @Override
  public WorkoutLog getLogReference(UUID uuid) {
    return mapper.toWorkoutLog(repository.getReferenceById(uuid));
  }

}
