package com.marmouset.workout.app.domain.workout;

import java.util.UUID;

public class WorkoutLogNotFoundException extends Exception {

  public WorkoutLogNotFoundException(UUID id) {
    super("Workout log with id " + id + " is not found");
  }

}
