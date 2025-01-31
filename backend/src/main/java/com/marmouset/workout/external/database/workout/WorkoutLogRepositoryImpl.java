package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.workout.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;
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

    create(new CreateWorkoutLogRepoRequest("Toto"));
    create(new CreateWorkoutLogRepoRequest("Titi"));
  }

  @Override
  public List<WorkoutLog> read() {
    return repository.findAll().stream().map(mapper::toWorkoutLog).toList();
  }

  @Override
  public WorkoutLog read(UUID uuid) throws NotFoundException {
    return mapper.toWorkoutLog(
        repository
            .findById(uuid)
            .orElseThrow(NotFoundException::new));
  }

  @Override
  public WorkoutLog create(CreateWorkoutLogRepoRequest request) {
    var workoutLog = new WorkoutLogEntity(request.name());
    return mapper.toWorkoutLog(repository.save(workoutLog));
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }

  @Override
  public WorkoutLog readReference(UUID uuid)
      throws NotFoundException {
    return mapper.toWorkoutLog(repository.findById(uuid)
        .orElseThrow(NotFoundException::new));
  }

}
