package com.marmouset.workout.app.port.in.progression;

import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeResponse;

public interface CalculateTotalRepsOverTime {
  RepsOverTimeResponse calculate(CalculateTotalRepsOverTimeCommand command)
      throws ExerciseNotFoundException;
}
