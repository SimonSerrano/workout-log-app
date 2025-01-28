package com.marmouset.workout.adapter.in.mapper;

import org.springframework.stereotype.Component;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogRequest;

@Component
public class WorkoutLogRequestMapper {

  public CreateWorkoutLogCommand toCreateWorkoutLogCommand(CreateWorkoutLogRequest request) {
    return new CreateWorkoutLogCommand(request.getTitle());
  }

}
