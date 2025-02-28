package com.marmouset.workout.app.progression.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.impl.ExerciseResponsePresenterImpl;
import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.adapter.ProgressionController;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponse;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponsePresenter;
import com.marmouset.workout.app.progression.usecase.CalculateRepsProgressionChartUseCase;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;

/**
 * Converts data from the web to the use cases and vice versa using a presenter.
 */
public class ProgressionControllerImpl implements ProgressionController {

  private final RepsProgressionChartResponsePresenter presenter;
  private final CalculateRepsProgressionChartUseCase calcRepsProgChartUseCase;

  /**
   * Creates a ProgressionControllerImpl.
   *
   * @param calcRepsProgChartUseCase the reps prog chart use case
   */
  public ProgressionControllerImpl(
      CalculateRepsProgressionChartUseCase calcRepsProgChartUseCase) {
    presenter = new RepsProgressionChartResponsePresenterImpl(
        new ExerciseResponsePresenterImpl());
    this.calcRepsProgChartUseCase = calcRepsProgChartUseCase;
  }

  @Override
  public RepsProgressionChartResponse calculateRepsProgressionChart(
      CalculateRepsProgressionChartCommand command)
      throws ExerciseNotFoundException {
    return presenter.present(calcRepsProgChartUseCase.calculate(command));
  }

}
