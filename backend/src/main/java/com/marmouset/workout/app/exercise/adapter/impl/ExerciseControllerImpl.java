package com.marmouset.workout.app.exercise.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.ExerciseController;
import com.marmouset.workout.app.exercise.adapter.ExerciseResponsePresenter;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.exercise.usecase.ListExercisesUseCase;
import java.util.List;

/**
 * Converts data from the web to the use case and vice versa.
 * It uses a presenter to do the use case to web flow.
 */
public class ExerciseControllerImpl implements ExerciseController {

  private final ExerciseResponsePresenter presenter;
  private final ListExercisesUseCase listExercisesUseCase;

  /**
   * Creates a ExerciseControllerImpl.
   *
   * @param listExercisesUseCase the list use case
   */
  public ExerciseControllerImpl(ListExercisesUseCase listExercisesUseCase) {
    this.presenter = new ExerciseResponsePresenterImpl();
    this.listExercisesUseCase = listExercisesUseCase;
  }

  @Override
  public List<ExerciseResponse> list() {
    return listExercisesUseCase.list().stream()
        .map(presenter::present)
        .toList();
  }
}
