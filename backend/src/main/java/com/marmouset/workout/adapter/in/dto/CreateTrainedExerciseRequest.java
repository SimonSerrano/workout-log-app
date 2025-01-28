package com.marmouset.workout.adapter.in.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CreateTrainedExerciseRequest {
  @org.hibernate.validator.constraints.UUID
  private UUID exerciseId;

  public UUID getExerciseId() {
    return exerciseId;
  }

}
