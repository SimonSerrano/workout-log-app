package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.workout.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.UpdateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
    return repository.findAllByOrderByCreatedAtDesc().stream()
        .map(mapper::toWorkoutLog).toList();
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
    var workoutLog = new WorkoutLogEntityImpl(request.name());
    return mapper.toWorkoutLog(repository.save(workoutLog));
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }

  @Override
  public WorkoutLogEntityContainer readReference(
      UUID uuid) throws NotFoundException {
    try {
      return new WorkoutLogEntityContainerImpl(
          repository.getReferenceById(uuid));
    } catch (EntityNotFoundException e) {
      throw new NotFoundException();
    }
  }

  @Override
  public WorkoutLog update(UpdateWorkoutLogRepoRequest request)
      throws NotFoundException {
    var entity = repository.findById(request.id()).orElseThrow(
        NotFoundException::new);
    entity.setName(request.name());
    return mapper.toWorkoutLog(repository.save(entity));
  }

  @Override
  public boolean exists(UUID id) {
    return repository.existsById(id);
  }

}
