package com.marmouset.workout.app.usecase.workout;

import com.marmouset.workout.app.port.in.workout.CreateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.workout.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogPresenter;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import org.springframework.stereotype.Component;

@Component
class CreateWorkoutLogUseCase implements CreateWorkoutLog {

  private final WorkoutLogRepository workoutLogRepository;
  private final WorkoutLogPresenter presenter;

  public CreateWorkoutLogUseCase(WorkoutLogRepository workoutLogRepository,
                                 WorkoutLogPresenter presenter) {
    this.workoutLogRepository = workoutLogRepository;
    this.presenter = presenter;
  }

  @Override
  public WorkoutLogResponse create(CreateWorkoutLogCommand command) {
    var log = workoutLogRepository
        .create(new CreateWorkoutLogRepoRequest(command.getName()));
    return presenter.present(log);
  }

}
