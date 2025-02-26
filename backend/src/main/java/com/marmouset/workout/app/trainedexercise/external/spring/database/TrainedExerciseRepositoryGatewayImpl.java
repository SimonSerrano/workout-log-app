package com.marmouset.workout.app.trainedexercise.external.spring.database;

import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseRepositoryGateway;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * Gateway implementation for accessing trained exercise entities in the db.
 */
@Repository
public class TrainedExerciseRepositoryGatewayImpl
    implements TrainedExerciseRepositoryGateway {

  private final JpaTrainedExerciseRepository repository;

  /**
   * CReates a TrainedExerciseRepositoryGatewayImpl.
   *
   * @param repository the jap repository
   */
  public TrainedExerciseRepositoryGatewayImpl(
      JpaTrainedExerciseRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<? extends TrainedExercise> findByLog(WorkoutLog log) {
    return repository.findByLog(log);
  }

  @Override
  public TrainedExercise save(TrainedExercise trainedExercise) {
    if (trainedExercise instanceof TrainedExerciseImpl) {
      return repository.save((TrainedExerciseImpl) trainedExercise);
    }

    throw new IllegalArgumentException("Unsupported TrainedExercise type");
  }

  @Override
  public void deleteById(Long trainedId) {
    repository.deleteById(trainedId);
  }

  @Override
  public Optional<? extends TrainedExercise> findById(Long id) {
    return repository.findById(id);
  }
}
