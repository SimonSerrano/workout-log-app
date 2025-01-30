package com.marmouset.workout.external.web.workout;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.dto.CreateWorkoutLogCommand;

@Component
public class WorkoutLogRequestMapper {

  public CreateWorkoutLogCommand toCreateWorkoutLogCommand(CreateWorkoutLogRequest request) {
    return new CreateWorkoutLogCommand(request.getTitle());
  }

}
