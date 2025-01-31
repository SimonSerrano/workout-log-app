package com.marmouset.workout.app.usecase;

import com.marmouset.workout.app.port.in.exercise.ListExercises;
import com.marmouset.workout.app.port.out.exercise.ExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Component;

/**
 * Use case to list all exercises.
 */
@Component
public class ListExercisesUseCase implements ListExercises {
  private final ExerciseRepository exerciseRepositoryPort;
  private final ExercisePresenter presenter;

  /**
   * Constructor for this use case.
   *
   * @param repository the exercise repository
   * @param presenter  the exercise presenter
   */
  public ListExercisesUseCase(
      ExerciseRepository repository,
      ExercisePresenter presenter) {
    this.exerciseRepositoryPort = repository;
    this.presenter = presenter;
  }

  @Override
  public Iterable<ExerciseResponse> listExercises() {
    return StreamSupport
        .stream(exerciseRepositoryPort.getExercises().spliterator(), false)
        .map(presenter::present)
        .toList();
  }

}
