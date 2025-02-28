package com.marmouset.workout.app.progression.adapter;

import com.marmouset.workout.app.progression.entity.RepsProgressionChart;

/**
 * Interface to convert data from the use case to the web.
 */
public interface RepsProgressionChartResponsePresenter {
  /**
   * Presents a reps prog chart for the web.
   *
   * @param chart the chart to present
   * @return the response
   */
  RepsProgressionChartResponse present(RepsProgressionChart chart);
}
