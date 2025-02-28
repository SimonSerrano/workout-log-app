package com.marmouset.workout.app.progression.entity;

import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.List;

/**
 * Interface representing a reps over time progression chart.
 */
public interface RepsProgressionChart {
  /**
   * Gets the exercise for which the progression is charted.
   *
   * @return the exercise
   */
  Exercise getExercise();

  /**
   * Get the list of data points representing the chart.
   *
   * @return the list of data points
   */
  List<? extends RepsDataPoint> getChart();
}
