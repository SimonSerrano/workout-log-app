package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import java.util.List;

/**
 * Interface for listing exercises use case.
 */
public interface ListExercises {
  /**
   * List exercises.
   *
   * @return exercises
   */
  List<ExerciseResponse> list();
}
