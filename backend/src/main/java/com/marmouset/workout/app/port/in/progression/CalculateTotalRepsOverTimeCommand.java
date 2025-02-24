package com.marmouset.workout.app.port.in.progression;

import java.util.Objects;

public record CalculateTotalRepsOverTimeCommand(String exerciseId) {

  public CalculateTotalRepsOverTimeCommand {
    Objects.requireNonNull(exerciseId, "Exercise id cannot be null");
  }
}
