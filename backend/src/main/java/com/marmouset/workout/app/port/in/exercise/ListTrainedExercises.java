package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import java.util.UUID;

public interface ListTrainedExercises {
  Iterable<TrainedExerciseResponse> list(UUID logId) throws
      WorkoutLogNotFoundException;
}
