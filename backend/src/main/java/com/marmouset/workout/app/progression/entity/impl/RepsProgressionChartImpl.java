package com.marmouset.workout.app.progression.entity.impl;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.progression.entity.RepsDataPoint;
import com.marmouset.workout.app.progression.entity.RepsProgressionChart;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the reps progression chart.
 */
public class RepsProgressionChartImpl implements RepsProgressionChart {

  private final Exercise exercise;
  private final List<? extends RepsDataPoint> chart;

  /**
   * Creates a RepsProgressionChartImpl with an empty chart.
   *
   * @param exercise the exercise
   */
  public RepsProgressionChartImpl(Exercise exercise) {
    this(exercise, new ArrayList<>());
  }

  /**
   * Creates a RepsProgressionChartImpl.
   *
   * @param exercise the exercise
   * @param chart    the chart data points
   */
  public RepsProgressionChartImpl(
      Exercise exercise,
      List<? extends RepsDataPoint> chart) {
    this.exercise = exercise;
    this.chart = chart;
  }

  @Override
  public Exercise getExercise() {
    return exercise;
  }

  @Override
  public List<? extends RepsDataPoint> getChart() {
    return chart;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
    result = prime * result + ((chart == null) ? 0 : chart.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    RepsProgressionChartImpl other = (RepsProgressionChartImpl) obj;
    if (exercise == null) {
      if (other.exercise != null) {
        return false;
      }
    } else if (!exercise.equals(other.exercise)) {
      return false;
    }
    if (chart == null) {
      if (other.chart != null) {
        return false;
      }
    } else if (!chart.equals(other.chart)) {
      return false;
    }
    return true;
  }

}
