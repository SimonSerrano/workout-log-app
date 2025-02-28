package com.marmouset.workout.app.progression.adapter.impl;

import com.marmouset.workout.app.exercise.adapter.ExerciseResponsePresenter;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponse;
import com.marmouset.workout.app.progression.adapter.RepsProgressionChartResponsePresenter;
import com.marmouset.workout.app.progression.adapter.dto.RepsDataPointResponseImpl;
import com.marmouset.workout.app.progression.adapter.dto.RepsProgressionChartResponseImpl;
import com.marmouset.workout.app.progression.entity.RepsProgressionChart;

/**
 * Presents progression chart from the use case to the web.
 */
public class RepsProgressionChartResponsePresenterImpl
    implements RepsProgressionChartResponsePresenter {

  private final ExerciseResponsePresenter exercisePresenter;

  /**
   * Creates a RepsProgressionChartResponsePresenterImpl.
   *
   * @param exercisePresenter the exercise presenter
   */
  public RepsProgressionChartResponsePresenterImpl(
      ExerciseResponsePresenter exercisePresenter) {
    this.exercisePresenter = exercisePresenter;
  }

  @Override
  public RepsProgressionChartResponse present(RepsProgressionChart chart) {
    return new RepsProgressionChartResponseImpl(
        exercisePresenter.present(chart.getExercise()),
        chart.getChart().stream()
            .map(dp -> new RepsDataPointResponseImpl(
                dp.date().getEpochSecond(),
                dp.reps()))
            .toList());
  }

}
