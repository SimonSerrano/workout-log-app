package com.marmouset.workout.adapter.out.mapper;

import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;
import com.marmouset.workout.domain.WorkoutLog;

@Component
public class WorkoutLogResponseMapper {

  public WorkoutLogResponse toWorkoutLogListElementDTO(WorkoutLog workoutLog) {
    return new WorkoutLogResponse(
        workoutLog.getId(),
        workoutLog.getTitle(),
        workoutLog.getCreatedAt().toEpochSecond(ZoneOffset.UTC));
  }

}
