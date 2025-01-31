package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.port.out.dto.TrainedExerciseResponse;
import java.util.UUID;

public interface ListTrainedExercises {
  Iterable<TrainedExerciseResponse> list(UUID logId) throws WorkoutLogNotFound;
}
