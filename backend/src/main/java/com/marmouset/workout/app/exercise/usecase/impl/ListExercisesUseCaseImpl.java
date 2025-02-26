package com.marmouset.workout.app.exercise.usecase.impl;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.ListExercisesUseCase;
import java.util.List;

/**
 * Use case to list all exercises.
 */
public class ListExercisesUseCaseImpl implements ListExercisesUseCase {
  private final ExerciseRepository repository;

  /**
   * Constructor for this use case.
   *
   * @param repository the exerciseContainer repository
   */
  public ListExercisesUseCaseImpl(ExerciseRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<? extends Exercise> list() {
    return repository.read();
  }

}
