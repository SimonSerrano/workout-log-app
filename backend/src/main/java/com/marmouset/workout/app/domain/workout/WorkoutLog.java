package com.marmouset.workout.app.domain.workout;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface WorkoutLog {

  UUID getId();

  String getName();

  void rename(String title);

  List<TrainedExercise> getExercises();

  WorkoutLog addExercise(TrainedExercise exercise);

  Instant getCreatedAt();

}
