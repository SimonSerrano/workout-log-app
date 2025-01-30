package com.marmouset.workout.app.usecase;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.CreateWorkoutLog;
import com.marmouset.workout.app.port.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.dto.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

@Component
public class CreateWorkoutLogUseCase implements CreateWorkoutLog {

  private final WorkoutLogRepository workoutLogRepository;
  private final WorkoutLogPresenter presenter;

  public CreateWorkoutLogUseCase(WorkoutLogRepository workoutLogRepository,
      WorkoutLogPresenter presenter) {
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public WorkoutLogResponse createWorkoutLog(CreateWorkoutLogCommand command) {
    var log = workoutLogRepository
        .createWorkoutLog(new CreateWorkoutLogRepoRequest(command.getName()));
    return presenter.prepareSuccessfulResponse(log);
  }

}
