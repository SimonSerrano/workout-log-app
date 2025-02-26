package com.marmouset.workout.app.progression.usecase;

import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
import com.marmouset.workout.app.progression.adapter.RepsOverTimeResponse;
import com.marmouset.workout.app.progression.usecase.dto.CalculateTotalRepsOverTimeCommand;

public interface CalculateTotalRepsOverTimeUseCase {
  RepsOverTimeResponse calculate(CalculateTotalRepsOverTimeCommand command)
      throws ExerciseNotFoundException;
}
