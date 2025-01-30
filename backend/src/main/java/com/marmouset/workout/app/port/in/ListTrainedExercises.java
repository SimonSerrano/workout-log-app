package com.marmouset.workout.app.port.in;

import java.util.UUID;

import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;

public interface ListTrainedExercises {
  Iterable<TrainedExerciseResponse> list(UUID logId);
}
