package com.marmouset.workout.app.domain.exercise;

import java.util.List;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.domain.workout.WorkoutLog;

public interface TrainedExercise {

  Exercise getExercise();

  TrainedExercise setExercise(Exercise exercise);

  List<ExerciseSet> getSets();

  TrainedExercise addSet(ExerciseSet set);

  TrainedExercise removeSet(ExerciseSet set);

  WorkoutLog getLog();
}
