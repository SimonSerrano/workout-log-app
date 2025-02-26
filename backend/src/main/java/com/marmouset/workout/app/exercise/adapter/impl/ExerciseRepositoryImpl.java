package com.marmouset.workout.app.exercise.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.ExerciseRepositoryGateway;
import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.entity.ExerciseFactory;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.dto.CreateExerciseRepoRequest;
import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Converts data from the database to the use case and vice versa.
 * This repository is for exercises only.
 */
public class ExerciseRepositoryImpl implements ExerciseRepository {

  private final ExerciseRepositoryGateway repositoryGateway;
  private final ExerciseFactory factory;

  /**
   * Creates a ExerciseRepositoryImpl.
   *
   * @param repositoryGateway the gateway
   * @param factory           the exercise factory
   */
  public ExerciseRepositoryImpl(ExerciseRepositoryGateway repositoryGateway,
                                ExerciseFactory factory) {
    this.repositoryGateway = repositoryGateway;
    this.factory = factory;
  }

  @Override
  public List<? extends Exercise> read() {
    return repositoryGateway.findAll();
  }

  @Override
  public Exercise readReference(String id)
      throws NotFoundException {
    try {
      return repositoryGateway.getReferenceById(id);
    } catch (EntityNotFoundException e) {
      throw new NotFoundException();
    }
  }

  @Override
  public Exercise create(CreateExerciseRepoRequest request) {
    var exercise = factory.create(request.name());
    return repositoryGateway.save(exercise);
  }

}
