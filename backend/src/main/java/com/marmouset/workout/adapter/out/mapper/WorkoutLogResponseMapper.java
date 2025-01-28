package com.marmouset.workout.adapter.out.mapper;

import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.domain.WorkoutLog;

@Component
public class WorkoutLogResponseMapper {

  public WorkoutLogListElementResponse toWorkoutLogListElementDTO(WorkoutLog workoutLog) {
    return new WorkoutLogListElementResponse(
        workoutLog.getId(),
        workoutLog.getTitle(),
        workoutLog.getCreatedAt().toEpochSecond(ZoneOffset.UTC));
  }

}
