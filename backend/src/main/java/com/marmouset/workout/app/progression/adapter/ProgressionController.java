package com.marmouset.workout.app.progression.adapter;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;

/**
 * Interface to convert data from the web to the use cases for the progression.
 */
public interface ProgressionController {
  /**
   * Calculates the repetition progression chart.
   *
   * @param command the command containing required data
   * @return the repetition progression chart
   * @throws ExerciseNotFoundException when the exercise is not found
   */
  RepsProgressionChartResponse calculateRepsProgressionChart(
      CalculateRepsProgressionChartCommand command)
      throws ExerciseNotFoundException;
}
