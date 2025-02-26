package com.marmouset.workout.app.progression.adapter;

import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import java.util.List;

public interface RepsOverTimeResponse {
  ExerciseResponse exercise();

  List<RepsOverTimeRecordResponse> chart();
}
