package com.marmouset.workout.app.progression.usecase;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.entity.RepsProgressionChart;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;

/**
 * Use case to calculate the total number of repetitions over time for a given
 * exercise.
 */
public interface CalculateRepsProgressionChartUseCase {
  /**
   * Calculates the total number of reps for a given exercise.
   *
   * @param command the command with necessary data
   * @return the number of repetitions over time
   * @throws ExerciseNotFoundException if the requested exercise does not exist
   */
  RepsProgressionChart calculate(
      CalculateRepsProgressionChartCommand command)
      throws ExerciseNotFoundException;
}
