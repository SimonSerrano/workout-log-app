package com.marmouset.workout.external.web.workout;

import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import org.springframework.stereotype.Component;

@Component
public class WorkoutLogRequestMapper {

  public CreateWorkoutLogCommand toCreateWorkoutLogCommand(
      CreateWorkoutLogRequest request) {
    return new CreateWorkoutLogCommand(request.getTitle());
  }

}
