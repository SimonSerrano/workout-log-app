package com.marmouset.workout.app.log;

import java.util.UUID;

public class WorkoutLogNotFound extends Exception {

  public WorkoutLogNotFound(UUID id) {
    super("Workout log with id " + id + " is not found");
  }

}
