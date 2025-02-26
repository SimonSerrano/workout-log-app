package com.marmouset.workout.app.workout.adapter.impl;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.adapter.WorkoutLogRepositoryGateway;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogFactory;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogRepoRequest;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Converts data from the use cases to the db and vice versa for workout logs.
 */
public class WorkoutLogRepositoryImpl implements WorkoutLogRepository {

  private final WorkoutLogRepositoryGateway repositoryGateway;
  private final WorkoutLogFactory factory;

  /**
   * Creates a WorkoutLogRepositoryImpl.
   *
   * @param repositoryGateway the repo gateway
   * @param factory           the workout factory
   */
  public WorkoutLogRepositoryImpl(WorkoutLogRepositoryGateway repositoryGateway,
                                  WorkoutLogFactory factory) {
    this.repositoryGateway = repositoryGateway;
    this.factory = factory;

  }

  @Override
  public List<? extends WorkoutLog> read() {
    return repositoryGateway.findAllByOrderByCreatedAtDesc();
  }

  @Override
  public WorkoutLog read(UUID uuid) throws NotFoundException {
    return repositoryGateway
        .findById(uuid)
        .orElseThrow(NotFoundException::new);
  }

  @Override
  public WorkoutLog create(CreateWorkoutLogRepoRequest request) {
    var workoutLog = factory.create(request.name());
    return repositoryGateway.save(workoutLog);
  }

  @Override
  public void delete(UUID uuid) {
    repositoryGateway.deleteById(uuid);
  }

  @Override
  public WorkoutLog readReference(
      UUID uuid) throws NotFoundException {
    try {
      return repositoryGateway.getReferenceById(uuid);
    } catch (EntityNotFoundException e) {
      throw new NotFoundException();
    }
  }

  @Override
  public WorkoutLog update(UpdateWorkoutLogRepoRequest request)
      throws NotFoundException {
    var entity = repositoryGateway.findById(request.id()).orElseThrow(
        NotFoundException::new);
    entity.rename(request.name());
    return repositoryGateway.save(entity);
  }

  @Override
  public boolean exists(UUID id) {
    return repositoryGateway.existsById(id);
  }


}
