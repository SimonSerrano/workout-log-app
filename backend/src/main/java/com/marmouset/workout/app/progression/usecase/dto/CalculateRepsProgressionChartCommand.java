package com.marmouset.workout.app.progression.usecase.dto;

import java.util.Objects;

public record CalculateRepsProgressionChartCommand(String exerciseId) {

  public CalculateRepsProgressionChartCommand {
    Objects.requireNonNull(exerciseId, "Exercise id cannot be null");
  }
}
