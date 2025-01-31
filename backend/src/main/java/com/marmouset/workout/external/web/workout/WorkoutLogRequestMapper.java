package com.marmouset.workout.external.web.workout;

import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import org.springframework.stereotype.Component;

@Component
class WorkoutLogRequestMapper {

  public CreateWorkoutLogCommand toCreateWorkoutLogCommand(
      CreateWorkoutLogBody request) {
    return new CreateWorkoutLogCommand(request.getTitle());
  }

}
