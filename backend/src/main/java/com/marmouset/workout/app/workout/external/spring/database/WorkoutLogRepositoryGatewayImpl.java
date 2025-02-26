package com.marmouset.workout.app.workout.external.spring.database;

import com.marmouset.workout.app.workout.adapter.WorkoutLogRepositoryGateway;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * Interacts with the JPA repository for workout logs.
 */
@Repository
public class WorkoutLogRepositoryGatewayImpl
    implements WorkoutLogRepositoryGateway {

  private final JpaWorkoutLogRepository repository;

  /**
   * Creates a WorkoutLogRepositoryGatewayImpl.
   *
   * @param repository the jpa repository
   */
  public WorkoutLogRepositoryGatewayImpl(JpaWorkoutLogRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<? extends WorkoutLog> findAllByOrderByCreatedAtDesc() {
    return repository.findAllByOrderByCreatedAtDesc();
  }

  @Override
  public Optional<? extends WorkoutLog> findById(UUID id) {
    return repository.findById(id);
  }

  @Override
  public WorkoutLog save(WorkoutLog entity) {
    if (entity instanceof WorkoutLogImpl) {
      return repository.save((WorkoutLogImpl) entity);
    }

    throw new IllegalStateException("Unsupported WorkoutLog type");
  }

  @Override
  public void deleteById(UUID id) {
    repository.deleteById(id);
  }

  @Override
  public WorkoutLog getReferenceById(UUID id) {
    return repository.getReferenceById(id);
  }

  @Override
  public boolean existsById(UUID uuid) {
    return repository.existsById(uuid);
  }
}
