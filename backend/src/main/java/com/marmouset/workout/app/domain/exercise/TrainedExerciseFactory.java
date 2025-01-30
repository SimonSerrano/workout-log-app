package com.marmouset.workout.app.domain.exercise;

import com.marmouset.workout.app.domain.workout.WorkoutLog;

public interface TrainedExerciseFactory {
  TrainedExercise create(WorkoutLog log, Exercise exercise);
}
