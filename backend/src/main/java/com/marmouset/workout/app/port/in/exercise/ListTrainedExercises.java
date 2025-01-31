package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFound;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import java.util.UUID;

public interface ListTrainedExercises {
  Iterable<TrainedExerciseResponse> list(UUID logId) throws WorkoutLogNotFound;
}
