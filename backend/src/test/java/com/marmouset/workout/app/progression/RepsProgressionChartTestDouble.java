package com.marmouset.workout.app.progression;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.progression.entity.RepsDataPoint;
import com.marmouset.workout.app.progression.entity.RepsProgressionChart;
import com.marmouset.workout.app.progression.entity.impl.RepsDataPointImpl;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Test double for the reps progression chart with static values.
 */
public class RepsProgressionChartTestDouble implements RepsProgressionChart {
  private final Exercise exercise = new ExerciseTestDouble();
  private final List<RepsDataPoint> chart = List.of(
      new RepsDataPointImpl(
          new GregorianCalendar(
              2025,
              1,
              27).toInstant(),
          30),
      new RepsDataPointImpl(
          new GregorianCalendar(
              2025,
              2,
              1).toInstant(),
          39),
      new RepsDataPointImpl(
          new GregorianCalendar(
              2025,
              2,
              4).toInstant(),
          45));

  @Override
  public Exercise getExercise() {
    return exercise;
  }

  @Override
  public List<? extends RepsDataPoint> getChart() {
    return chart;
  }

}
