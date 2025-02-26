package com.marmouset.workout.app.exercise.adapter;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import java.util.List;

/**
 * Converts data from the use case to the web and vice versa.
 */
public interface ExerciseController {

  /**
   * Lists all exercises.
   *
   * @return a list of exercise response
   */
  List<ExerciseResponse> list();
}
