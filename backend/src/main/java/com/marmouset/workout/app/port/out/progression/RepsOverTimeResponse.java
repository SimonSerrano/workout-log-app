package com.marmouset.workout.app.port.out.progression;

import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import java.util.List;

public interface RepsOverTimeResponse {
  ExerciseResponse exercise();

  List<RepsOverTimeRecordResponse> chart();
}
