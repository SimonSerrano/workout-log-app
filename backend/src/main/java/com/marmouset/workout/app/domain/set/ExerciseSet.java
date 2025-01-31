package com.marmouset.workout.app.domain.set;

import java.util.UUID;

public interface ExerciseSet {

  UUID getId();

  int getReps();

  ExerciseSet setReps(int reps);
}
