package com.marmouset.workout.domain;

import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class WorkoutLogAdapter {

  public WorkoutLogListElementDTO toWorkoutLogListElementDTO(WorkoutLog workoutLog) {
    return new WorkoutLogListElementDTO(
        workoutLog.getId(),
        workoutLog.getTitle(),
        workoutLog.getCreatedAt().toEpochSecond(ZoneOffset.UTC));
  }

}
