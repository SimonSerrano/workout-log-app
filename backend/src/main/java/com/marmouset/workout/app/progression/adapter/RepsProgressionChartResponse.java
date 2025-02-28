package com.marmouset.workout.app.progression.adapter;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import java.util.List;

/**
 * Interface representing the reps progression chart as a response.
 */
public interface RepsProgressionChartResponse {
  /**
   * Get the exercise of the progression chart.
   *
   * @return the exercise as a response
   */
  ExerciseResponse exercise();

  /**
   * Get the list of data points.
   *
   * @return the list of data points
   */
  List<? extends RepsDataPointResponse> chart();
}
