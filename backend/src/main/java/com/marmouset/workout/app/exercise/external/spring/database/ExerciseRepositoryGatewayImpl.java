package com.marmouset.workout.app.exercise.external.spring.database;

import com.marmouset.workout.app.exercise.adapter.ExerciseRepositoryGateway;
import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * Repository gateway implementation to interact with a Spring repository.
 */
@Repository
public class ExerciseRepositoryGatewayImpl implements
    ExerciseRepositoryGateway {

  private final JpaExerciseRepository repository;

  /**
   * Creates a ExerciseRepositoryGatewayImpl.
   *
   * @param repository the Jpa spring repository
   */
  public ExerciseRepositoryGatewayImpl(JpaExerciseRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<? extends Exercise> findAll() {
    return repository.findAll();
  }

  @Override
  public Exercise getReferenceById(String id) {
    return repository.getReferenceById(id);
  }

  @Override
  public Exercise save(Exercise exercise) {
    if (exercise instanceof ExerciseImpl) {
      return repository.save((ExerciseImpl) exercise);
    }

    throw new IllegalArgumentException("Unsupported Exercise type");
  }

  @Override
  public Optional<? extends Exercise> findById(String id) {
    return repository.findById(id);
  }
}
